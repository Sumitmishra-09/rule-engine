package com.act21.rule.engine.dsl.expression.functions;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import com.act21.rule.engine.dsl.datatype.TypeSystem;
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary;
import com.act21.rule.engine.dsl.model.Argument;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.FeatureCall;
import com.act21.rule.engine.dsl.model.FunctionDeclaration;
import com.act21.rule.engine.dsl.model.Parameter;
import com.act21.rule.engine.dsl.model.ParenthesizedExpression;
import com.act21.rule.engine.dsl.model.TypeReference;
import com.act21.rule.engine.dsl.model.VariableDeclaration;

/** Converts inferred DSL types to the registry's framework-independent signature format. */
public final class RegisteredFunctionTypes {
    private RegisteredFunctionTypes() { }

    public static void validate(FunctionRegistry.Definition function, List<Argument> arguments) {
        function.validateArgumentTypes(argumentTypes(arguments));
    }

    public static List<String> argumentTypes(List<Argument> arguments) {
        return arguments.stream().map(RegisteredFunctionTypes::typeOf)
                .collect(Collectors.toList());
    }

    /** Preserve generic signatures for custom calls without changing main's scalar type system or grammar. */
    public static String typeOf(EObject expression) {
        if (expression instanceof Argument) return typeOf(((Argument) expression).getValue());
        if (expression instanceof ParenthesizedExpression)
            return typeOf(((ParenthesizedExpression) expression).getExpression());
        if (expression instanceof ElementReferenceExpression)
            return typeOf(((ElementReferenceExpression) expression).getReference());
        if (expression instanceof FeatureCall) return typeOf(((FeatureCall) expression).getFeature());
        if (expression instanceof VariableDeclaration) return describe(((VariableDeclaration) expression).getType());
        if (expression instanceof Parameter) return describe(((Parameter) expression).getType());
        if (expression instanceof FunctionDeclaration && expression.eResource() != null
                && expression.eResource().getResourceSet() != null) {
            Object library = expression.eResource().getResourceSet().getLoadOptions().get(InBuiltLibrary.class.getName());
            if (library instanceof InBuiltLibrary) {
                FunctionRegistry.Definition function = ((InBuiltLibrary) library)
                        .getRegisteredFunction((FunctionDeclaration) expression);
                if (function != null) return function.getReturnType();
            }
        }
        String type = TypeSystem.inferType(expression);
        return type == null ? "unknown" : type;
    }

    public static boolean isListType(String type) {
        return "java.util.List".equals(type) || (type != null && type.startsWith("java.util.List<"));
    }

    private static String describe(TypeReference type) {
        if (type == null) return "unknown";
        return type.getIdentifier() + (type.getTypeArguments().isEmpty() ? ""
                : "<" + String.join(",", type.getTypeArguments()) + ">");
    }
}
