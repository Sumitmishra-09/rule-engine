package com.act21.rule.engine.dsl.expression.functions;

import java.util.List;
import java.util.stream.Collectors;

import com.act21.rule.engine.dsl.datatype.TypeSystem;
import com.act21.rule.engine.dsl.expression.util.Type;
import com.act21.rule.engine.dsl.model.Argument;

/** Converts inferred DSL types to the registry's framework-independent signature format. */
public final class RegisteredFunctionTypes {
    private RegisteredFunctionTypes() { }

    public static void validate(FunctionRegistry.Definition function, List<Argument> arguments) {
        function.validateArgumentTypes(arguments.stream()
                .map(argument -> describe(TypeSystem.inferType(argument))).collect(Collectors.toList()));
    }

    private static String describe(Type type) {
        if (type == null) return "unknown";
        if (type.getTypeArguments().isEmpty()) return type.getBaseType();
        return type.getBaseType() + "<" + type.getTypeArguments().stream()
                .map(RegisteredFunctionTypes::describe).collect(Collectors.joining(",")) + ">";
    }
}
