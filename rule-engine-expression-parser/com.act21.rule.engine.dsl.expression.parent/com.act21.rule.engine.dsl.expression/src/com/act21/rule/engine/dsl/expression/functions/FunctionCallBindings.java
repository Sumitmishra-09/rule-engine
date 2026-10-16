package com.act21.rule.engine.dsl.expression.functions;

import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry.Definition;

/**
 * Generation state for one Java rule class, shared by its cell expressions.
 * Only used functions get bindings. Custom expression generation requires this
 * context so the host can emit the supporting fields, methods and initializers.
 */
public final class FunctionCallBindings {
    public static final String CONTEXT_KEY = FunctionCallBindings.class.getName();
    private final ClassLoader classLoader;
    private final Map<Definition, String> targets = new LinkedHashMap<>();
    private final Map<List<String>, String> calls = new LinkedHashMap<>();
    private final StringBuilder methods = new StringBuilder();

    public FunctionCallBindings(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /** Validate before generating a direct call, including when grid validation is disabled. */
    public String compileCall(Definition function, List<String> argumentTypes, List<String> arguments) {
        function.validateArgumentTypes(argumentTypes);
        // An instance bridge has at most 254 single-slot (boxed/reference) parameters.
        if (arguments.size() > 254) {
            throw new IllegalArgumentException("Function " + function.getName()
                    + " supports at most 254 arguments in a generated direct call, got " + arguments.size());
        }
        String problem = directCallProblem(function);
        if (problem != null) {
            throw new IllegalArgumentException("Function " + function.getName()
                    + " cannot be generated as a direct call: " + problem);
        }
        List<String> signature = new ArrayList<>();
        signature.add(function.getName());
        signature.addAll(argumentTypes);
        String bridge = calls.get(signature);
        if (bridge == null) {
            bridge = "__gridFunction" + calls.size();
            calls.put(signature, bridge);
            String receiver = function.getDeclaringType().getCanonicalName();
            if (!function.isStatic()) {
                receiver = targets.computeIfAbsent(function, key -> "__gridFunctionTarget" + targets.size());
            }
            appendMethod(function, argumentTypes, bridge, receiver);
        }
        return bridge + "(" + String.join(",", arguments) + ")";
    }

    private String directCallProblem(Definition function) {
        Class<?> owner = function.getDeclaringType();
        if (classLoader == null) return "compilation class loader is missing";
        if (owner.getCanonicalName() == null || owner.getPackageName().isEmpty())
            return "declaring class must have a canonical name and a package: " + owner.getName();
        for (Class<?> type = owner; type != null; type = type.getEnclosingClass()) {
            if (!Modifier.isPublic(type.getModifiers())) return "class must be public: " + type.getName();
        }
        if (!owner.getModule().isExported(owner.getPackageName()))
            return "declaring package must be exported: " + owner.getPackageName();
        try {
            // The runtime compiler must see the same class and its bytecode, not a
            // same-named class in another loader or a resource-less runtime proxy.
            if (Class.forName(owner.getName(), false, classLoader) != owner)
                return "compilation class loader resolves a different class: " + owner.getName();
            if (classLoader.getResource(owner.getName().replace('.', '/') + ".class") == null)
                return "class bytecode is unavailable to the compiler: " + owner.getName();
            return null;
        } catch (ClassNotFoundException | SecurityException e) {
            return "compilation class loader cannot access " + owner.getName() + " (" + e + ")";
        }
    }

    private void appendMethod(Definition function, List<String> types, String bridge, String receiver) {
        List<String> parameters = new ArrayList<>();
        List<String> converted = new ArrayList<>();
        StringBuilder conversions = new StringBuilder();
        int fixed = function.getParameterTypes().size() - (function.isVarArgs() ? 1 : 0);
        for (int i = 0; i < types.size(); i++) {
            int parameter = Math.min(i, function.getParameterTypes().size() - 1);
            String expected = function.getParameterTypes().get(parameter);
            String actual = types.get(i);
            String argument = "arg" + i;
            parameters.add(("null".equals(actual) ? expected : actual) + " " + argument);
            String value = argument;
            if (Long.class.getName().equals(expected) && Integer.class.getName().equals(actual)) {
                value = argument + " == null ? null : java.lang.Long.valueOf(" + argument + ".longValue())";
            } else if (BigDecimal.class.getName().equals(expected)
                    && (Integer.class.getName().equals(actual) || Long.class.getName().equals(actual))) {
                value = argument + " == null ? null : java.math.BigDecimal.valueOf(" + argument + ".longValue())";
            }
            String local = "value" + i;
            conversions.append(expected).append(' ').append(local).append(" = ").append(value).append(";\n");
            Class<?> javaType = function.getJavaParameterType(parameter);
            if (javaType.isPrimitive()) {
                conversions.append("if (").append(local).append(" == null) throw new IllegalArgumentException(\"")
                        .append("Function ").append(function.getName()).append(" expects ")
                        .append(javaType.getName()).append(", got null\");\n");
            }
            // Exact Java parameter types prevent overload resolution from selecting
            // a different method. Primitive unboxing follows the explicit null check.
            converted.add("(" + (javaType.isPrimitive() ? javaType.getName() : expected) + ") " + local);
        }
        List<String> invocation = new ArrayList<>(converted.subList(0, fixed));
        if (function.isVarArgs()) {
            invocation.add("new " + function.getJavaParameterType(fixed).getCanonicalName() + "[]{"
                    + String.join(",", converted.subList(fixed, converted.size())) + "}");
        }
        methods.append("private ").append(function.getReturnType()).append(' ').append(bridge).append('(')
                .append(String.join(",", parameters)).append(") {\n").append(conversions)
                .append("try { return ").append(receiver).append('.').append(function.getMethodName())
                .append('(').append(String.join(",", invocation)).append("); }\n")
                .append("catch (Error failure) { throw failure; }\n")
                .append("catch (Throwable failure) { throw new IllegalStateException(\"Function ")
                .append(function.getName()).append(" failed\", failure); }\n}\n");
    }

    /** Emit after all cells have registered their calls; the host supplies the registry field. */
    public String declarations() {
        StringBuilder result = new StringBuilder();
        targets.forEach((function, field) -> result.append("private final ")
                .append(function.getDeclaringType().getCanonicalName()).append(' ').append(field).append(";\n"));
        return result.append(methods).toString();
    }

    /** Bind the caller's existing objects once when this compiled batch is constructed. */
    public String initializers() {
        StringBuilder result = new StringBuilder();
        targets.forEach((function, field) -> result.append("this.").append(field).append(" = (")
                .append(function.getDeclaringType().getCanonicalName()).append(") registeredFunctions.getDefinition(\"")
                .append(function.getName()).append("\").getTarget();\n"));
        return result.toString();
    }
}
