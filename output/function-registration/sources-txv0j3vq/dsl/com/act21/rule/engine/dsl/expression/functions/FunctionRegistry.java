package com.act21.rule.engine.dsl.expression.functions;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Application-owned, immutable bindings for explicitly registered Java methods.
 * All grid arguments are explicit; registration never inserts a decision header.
 * Target objects are retained and must support the application's concurrent calls.
 */
public final class FunctionRegistry {
    public static final String MODEL_CLASS = "RegisteredFunctions";
    private static final FunctionRegistry EMPTY = new FunctionRegistry(Collections.emptyMap());
    private static final Set<String> RESERVED = Set.of("addAll", "convertToString", "convertToInt",
            "convertToBigDecimal", "contains", "in", "max", "min", "avg", "diffDays",
            "class", "function", "let", "assign", "if", "true", "false", "null", "ALL", "PASS",
            "HelperFunctions", "RequestData", MODEL_CLASS);
    private final Map<String, Definition> definitions;

    private FunctionRegistry(Map<String, Definition> definitions) {
        this.definitions = Collections.unmodifiableMap(new LinkedHashMap<>(definitions));
    }

    public static FunctionRegistry empty() {
        return EMPTY;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Collection<Definition> getDefinitions() {
        return definitions.values();
    }

    public Definition getDefinition(String name) {
        Definition definition = definitions.get(name);
        if (definition == null) {
            throw new IllegalArgumentException("Unregistered function: " + name);
        }
        return definition;
    }

    /** Invoke the already resolved method; no method lookup occurs during execution. */
    public Object invoke(String name, Object... arguments) {
        return getDefinition(name).invoke(Objects.requireNonNull(arguments, "arguments"));
    }

    public static final class Builder {
        private final Map<String, Definition> definitions = new LinkedHashMap<>();

        public Builder register(String name, Object target, String methodName, Class<?>... parameterTypes) {
            Objects.requireNonNull(target, "target");
            return registerMethod(name, target, target.getClass(), methodName, parameterTypes, false);
        }

        public Builder registerStatic(String name, Class<?> owner, String methodName, Class<?>... parameterTypes) {
            return registerMethod(name, null, Objects.requireNonNull(owner, "owner"), methodName, parameterTypes, true);
        }

        private Builder registerMethod(String name, Object target, Class<?> owner, String methodName,
                Class<?>[] parameterTypes, boolean staticMethod) {
            if (name == null || !name.matches("[a-zA-Z_][a-zA-Z_0-9]*") || RESERVED.contains(name)) {
                throw new IllegalArgumentException("Invalid or reserved function name: " + name);
            }
            if (definitions.containsKey(name)) {
                throw new IllegalArgumentException("Duplicate function name: " + name);
            }
            try {
                Method method = owner.getMethod(methodName, parameterTypes);
                if (Modifier.isStatic(method.getModifiers()) != staticMethod || !method.canAccess(target)) {
                    throw new IllegalArgumentException("Function must be an accessible public "
                            + (staticMethod ? "static" : "instance") + " method: " + method);
                }
                definitions.put(name, new Definition(name, target, method));
                return this;
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("No matching public method for function: " + name, e);
            }
        }

        /** Each build takes a snapshot; later builder changes cannot alter an existing registry. */
        public FunctionRegistry build() {
            return new FunctionRegistry(definitions);
        }
    }

    /** Immutable signature shared by validation, declaration loading, and execution. */
    public static final class Definition {
        private final String name;
        private final Object target;
        private final Method method;
        private final List<String> parameterTypes;
        private final String returnType;

        private Definition(String name, Object target, Method method) {
            this.name = name;
            this.target = target;
            this.method = method;
            List<String> types = new ArrayList<>();
            Type[] parameters = method.getGenericParameterTypes();
            for (int i = 0; i < parameters.length; i++) {
                Type type = method.isVarArgs() && i == parameters.length - 1
                        ? method.getParameterTypes()[i].getComponentType() : parameters[i];
                types.add(languageType(type));
            }
            this.parameterTypes = Collections.unmodifiableList(types);
            this.returnType = languageType(method.getGenericReturnType());
        }

        public String getName() {
            return name;
        }

        public List<String> getParameterTypes() {
            return parameterTypes;
        }

        public String getReturnType() {
            return returnType;
        }

        public boolean isVarArgs() {
            return method.isVarArgs();
        }

        private int fixedCount() {
            return parameterTypes.size() - (isVarArgs() ? 1 : 0);
        }

        private void checkArity(int count) {
            if (count < fixedCount() || (!isVarArgs() && count != fixedCount())) {
                throw new IllegalArgumentException("Function " + name + " expects "
                        + (isVarArgs() ? "at least " : "") + fixedCount() + " arguments, got " + count);
            }
        }

        /** Only exact types, null references, and lossless numeric widening are accepted. */
        public void validateArgumentTypes(List<String> actualTypes) {
            checkArity(actualTypes.size());
            for (int i = 0; i < actualTypes.size(); i++) {
                int parameter = Math.min(i, parameterTypes.size() - 1);
                String expected = parameterTypes.get(parameter);
                String actual = actualTypes.get(i);
                Class<?> javaType = parameterClass(parameter);
                boolean compatible = expected.equals(actual)
                        || ("null".equals(actual) && !javaType.isPrimitive())
                        || (Long.class.getName().equals(expected) && Integer.class.getName().equals(actual))
                        || (BigDecimal.class.getName().equals(expected)
                            && (Integer.class.getName().equals(actual) || Long.class.getName().equals(actual)));
                if (!compatible) {
                    throw new IllegalArgumentException("Function " + name + " argument " + (i + 1)
                            + " expects " + expected + ", got " + actual);
                }
            }
        }

        private Class<?> parameterClass(int index) {
            Class<?> type = method.getParameterTypes()[index];
            return isVarArgs() && index == parameterTypes.size() - 1 ? type.getComponentType() : type;
        }

        private Object invoke(Object[] arguments) {
            checkArity(arguments.length);
            Object[] packed = new Object[parameterTypes.size()];
            for (int i = 0; i < fixedCount(); i++) {
                packed[i] = convert(arguments[i], parameterClass(i));
            }
            if (isVarArgs()) {
                Class<?> component = parameterClass(fixedCount());
                Object tail = Array.newInstance(component, arguments.length - fixedCount());
                for (int i = fixedCount(); i < arguments.length; i++) {
                    Array.set(tail, i - fixedCount(), convert(arguments[i], component));
                }
                packed[fixedCount()] = tail;
            }
            try {
                return method.invoke(target, packed);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof Error) {
                    throw (Error) cause;
                }
                throw new IllegalStateException("Function " + name + " failed", cause);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Function " + name + " is inaccessible", e);
            }
        }

        private Object convert(Object value, Class<?> targetType) {
            Class<?> boxed = boxed(targetType);
            if (value == null && !targetType.isPrimitive()) {
                return null;
            }
            if (boxed.isInstance(value)) {
                return value;
            }
            if (boxed == Long.class && value instanceof Integer) {
                return ((Integer) value).longValue();
            }
            if (boxed == BigDecimal.class && (value instanceof Integer || value instanceof Long)) {
                return BigDecimal.valueOf(((Number) value).longValue());
            }
            throw new IllegalArgumentException("Function " + name + " expects " + targetType.getTypeName()
                    + ", got " + (value == null ? "null" : value.getClass().getTypeName()));
        }
    }

    private static Class<?> boxed(Class<?> type) {
        if (type == int.class) return Integer.class;
        if (type == long.class) return Long.class;
        if (type == boolean.class) return Boolean.class;
        return type;
    }

    private static String languageType(Type type) {
        if (type instanceof Class<?>) {
            Class<?> boxed = boxed((Class<?>) type);
            if (boxed == Integer.class || boxed == Long.class || boxed == Boolean.class
                    || boxed == BigDecimal.class || boxed == String.class || boxed == Date.class) {
                return boxed.getName();
            }
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterized = (ParameterizedType) type;
            if (parameterized.getRawType() == List.class
                    && parameterized.getActualTypeArguments()[0] instanceof Class<?>) {
                return List.class.getName() + "<" + languageType(parameterized.getActualTypeArguments()[0]) + ">";
            }
        }
        throw new IllegalArgumentException("Unsupported grid function type: " + type.getTypeName());
    }
}
