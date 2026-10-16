package com.act21.rule.engine.dsl.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.act21.rule.engine.dsl.datatype.BasicDatatype;
import com.act21.rule.engine.dsl.datatype.TypeSystem;
import com.act21.rule.engine.dsl.expression.util.Utils;
import com.act21.rule.engine.dsl.model.ArrayExpression;
import com.act21.rule.engine.dsl.model.Decide;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.Expression;
import com.act21.rule.engine.dsl.model.FeatureCall;
import com.act21.rule.engine.dsl.model.LiteralExpression;
import com.act21.rule.engine.dsl.model.LogicalAndExpression;
import com.act21.rule.engine.dsl.model.LogicalNotExpression;
import com.act21.rule.engine.dsl.model.LogicalOrExpression;
import com.act21.rule.engine.dsl.model.LogicalRelationExpression;
import com.act21.rule.engine.dsl.model.NumericalExpression;
import com.act21.rule.engine.dsl.model.ParenthesizedExpression;
import com.google.inject.Singleton;

@Singleton
public class DecideExpressionValidator {

	public List<ValidationResult> validate(Decide decide, Expression exp) {
		Set<Object> possibleValues = Arrays
				.stream(((ArrayExpression) decide.getName().getValues()).getElements().toArray())
				.map((obj) -> Utils.getLiteralValue((((LiteralExpression) obj).getValue())))
				.collect(Collectors.toSet());
		List<ValidationResult> validationResult = new ArrayList<>();
		validate(exp, possibleValues, validationResult);
		return validationResult;
	}

	public void validate(Expression exp, Set<Object> possibleValues, List<ValidationResult> validationResult) {
		if (exp instanceof LogicalOrExpression) {
			validate(((LogicalOrExpression) exp).getLeftOperand(), possibleValues, validationResult);
			validate(((LogicalOrExpression) exp).getRightOperand(), possibleValues, validationResult);
			var leftType = TypeSystem.inferType(((LogicalOrExpression) exp).getLeftOperand());
			var rightType = TypeSystem.inferType(((LogicalOrExpression) exp).getRightOperand());
			if (leftType == null || rightType == null || !leftType.getBaseType().equals(BasicDatatype.BOOLEAN)
					|| !rightType.getBaseType().equals(BasicDatatype.BOOLEAN)) {
				validationResult.add(new ValidationResult(
						"Error: Invalid Type left-hand expression and right-hand should be of BOOLEAN type", "Error"));
			}
		} else if (exp instanceof LogicalAndExpression) {
			validate(((LogicalAndExpression) exp).getLeftOperand(), possibleValues, validationResult);
			validate(((LogicalAndExpression) exp).getRightOperand(), possibleValues, validationResult);
			var leftType = TypeSystem.inferType(((LogicalAndExpression) exp).getLeftOperand());
			var rightType = TypeSystem.inferType(((LogicalAndExpression) exp).getRightOperand());
			if (leftType == null || rightType == null || !leftType.getBaseType().equals(BasicDatatype.BOOLEAN)
					|| !rightType.getBaseType().equals(BasicDatatype.BOOLEAN)) {
				validationResult.add(new ValidationResult(
						"Error: Invalid Type left-hand expression and right-hand should be of BOOLEAN type", "Error"));
			}
		} else if (exp instanceof LogicalNotExpression) {
			validate(((LogicalNotExpression) exp).getOperand(), possibleValues, validationResult);
			var operandType = TypeSystem.inferType(((LogicalNotExpression) exp).getOperand());
			if (operandType == null || !operandType.getBaseType().equals(BasicDatatype.BOOLEAN)) {
				validationResult
						.add(new ValidationResult("Error: Invalid Type expression should be of BOOLEAN type", "Error"));
			}
		} else if (exp instanceof LogicalRelationExpression) {
			validate(((LogicalRelationExpression) exp).getLeftOperand(), possibleValues, validationResult);
			validate(((LogicalRelationExpression) exp).getRightOperand(), possibleValues, validationResult);
			var leftType = TypeSystem.inferType(((LogicalRelationExpression) exp).getLeftOperand());
			var rightType = TypeSystem.inferType(((LogicalRelationExpression) exp).getRightOperand());
			if (!Utils.isCompatible(leftType, rightType)) {
				validationResult.add(new ValidationResult(
						"Error: Invalid Type Expected type of Condition must be {" + leftType + "}", "Error"));
			}
		} else if (exp instanceof FeatureCall) {
			validate(((FeatureCall) exp).getOwner(), possibleValues, validationResult);
		} else if (exp instanceof ElementReferenceExpression) {
			if (((ElementReferenceExpression) exp).getReference().getName().equals("in")) {
				validateInExpression((ElementReferenceExpression) exp, possibleValues, validationResult);
			}
		} else if (exp instanceof ParenthesizedExpression) {
			validate(((ParenthesizedExpression) exp).getExpression(), possibleValues, validationResult);
		} else if (exp instanceof NumericalExpression) {
			validate(((NumericalExpression) exp).getLeftOperand(), possibleValues, validationResult);
			validate(((NumericalExpression) exp).getRightOperand(), possibleValues, validationResult);
		} else if (exp instanceof LiteralExpression) {
			checkValuePresent((LiteralExpression) exp, possibleValues, validationResult);
		}

	}

	private void validateInExpression(ElementReferenceExpression erd, Set<Object> possibleValues,
			List<ValidationResult> validationResult) {
		var lhs = erd.getArguments().get(0).getValue();
		var lhsType = TypeSystem.inferType(lhs);
		for (var index = 1; index < erd.getArguments().size(); index++) {
			var exp = erd.getArguments().get(index).getValue();
			var expType = TypeSystem.inferType(exp);
			if (!Utils.isCompatible(lhsType, expType)) {
				validationResult.add(new ValidationResult("Type Mismatch: In Values should be of same Type", "Error"));
			}
			if (exp instanceof LiteralExpression) {
				checkValuePresent((LiteralExpression) exp, possibleValues, validationResult);
			}
		}
	}

	private void checkValuePresent(LiteralExpression literal, Set<Object> possibleValues,
			List<ValidationResult> validationResult) {
		Object value = Utils.getLiteralValue(literal.getValue());
		if (possibleValues.size() != 0 && !possibleValues.contains(value)) {
			validationResult.add(new ValidationResult("Value Missing: value is missing in possible values", "Error"));
		}
	}

}
