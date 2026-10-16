package com.act21.rule.engine.dsl.datatype;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.act21.rule.engine.dsl.model.Argument;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.FeatureCall;
import com.act21.rule.engine.dsl.model.FunctionDeclaration;
import com.act21.rule.engine.dsl.model.LiteralExpression;
import com.act21.rule.engine.dsl.model.LogicalAndExpression;
import com.act21.rule.engine.dsl.model.LogicalNotExpression;
import com.act21.rule.engine.dsl.model.LogicalOrExpression;
import com.act21.rule.engine.dsl.model.LogicalRelationExpression;
import com.act21.rule.engine.dsl.model.NumericalExpression;
import com.act21.rule.engine.dsl.model.NumericalUnaryExpression;
import com.act21.rule.engine.dsl.model.Parameter;
import com.act21.rule.engine.dsl.model.ParenthesizedExpression;
import com.act21.rule.engine.dsl.model.TypeReference;
import com.act21.rule.engine.dsl.model.VariableDeclaration;
import com.act21.rule.engine.dsl.model.impl.AllLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.BoolLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.DateLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.DecimalLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.IntLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.LiteralExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalAndExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalOrExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalRelationExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NullLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalUnaryExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.ParenthesizedExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.PassLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.StringLiteralImpl;

public class TypeSystem {

	private static List<String> priortyType = Arrays.asList(BasicDatatype.NULL, BasicDatatype.INT, BasicDatatype.LONG,
			BasicDatatype.DECIMAL, BasicDatatype.STRING, BasicDatatype.ANY);

	public static String inferType(EObject exp) {
		if (exp instanceof IntLiteralImpl) {
			return BasicDatatype.LONG;
		}
		if (exp instanceof StringLiteralImpl) {
			return BasicDatatype.STRING;
		}
		if (exp instanceof DateLiteralImpl) {
			return BasicDatatype.DATE;
		}
		if (exp instanceof DecimalLiteralImpl) {
			return BasicDatatype.DECIMAL;
		}
		if (exp instanceof NullLiteralImpl) {
			return BasicDatatype.NULL;
		}
		if (exp instanceof PassLiteralImpl) {
			return BasicDatatype.PASS;
		}
		if (exp instanceof AllLiteralImpl) {
			return BasicDatatype.ALL;
		}
		if (exp instanceof BoolLiteralImpl) {
			return BasicDatatype.BOOLEAN;
		}
		if (exp instanceof LiteralExpressionImpl) {
			return inferType(((LiteralExpression) exp).getValue());
		}
		if (exp instanceof Parameter) {
			return getTypeReference(((Parameter) exp).getType());
		}
		if (exp instanceof Argument) {
			return inferType(((Argument) exp).getValue());
		}

		if (exp instanceof NumericalExpressionImpl) {
			var leftType = inferType(((NumericalExpression) exp).getLeftOperand());
			var rightType = inferType(((NumericalExpression) exp).getRightOperand());
			if (leftType.equals(rightType)) {
				return leftType;
			}
			return null;

		}
		if (exp instanceof NumericalUnaryExpressionImpl) {
			return inferType(((NumericalUnaryExpression) exp).getOperand());
		}
		if (exp instanceof ParenthesizedExpressionImpl) {
			return inferType(((ParenthesizedExpression) exp).getExpression());
		}
		if (exp instanceof ElementReferenceExpressionImpl) {
			return inferType(((ElementReferenceExpression) exp).getReference());
		}
		if (exp instanceof FeatureCall) {
			return inferType(((FeatureCall) exp).getFeature());
		}
		if (exp instanceof VariableDeclaration) {
			return getTypeReference(((VariableDeclaration) exp).getType());
		}
		if (exp instanceof FunctionDeclaration) {
			return ((FunctionDeclaration) exp).getReturnType();
		}
		if (exp instanceof LogicalAndExpressionImpl) {
			var leftType = inferType(((LogicalAndExpression) exp).getLeftOperand());
			var rightType = inferType(((LogicalAndExpression) exp).getRightOperand());
			if (BasicDatatype.BOOLEAN.equals(leftType) && BasicDatatype.BOOLEAN.equals(rightType)) {
				return BasicDatatype.BOOLEAN;
			}
			return null;
		}
		if (exp instanceof LogicalOrExpressionImpl) {
			var leftType = inferType(((LogicalOrExpression) exp).getLeftOperand());
			var rightType = inferType(((LogicalOrExpression) exp).getRightOperand());
			if (BasicDatatype.BOOLEAN.equals(leftType) && BasicDatatype.BOOLEAN.equals(rightType)) {
				return BasicDatatype.BOOLEAN;
			}
			return null;
		}
		if (exp instanceof LogicalNotExpression) {
			var operandType = inferType(((LogicalNotExpression) exp).getOperand());
			if (BasicDatatype.BOOLEAN.equals(operandType)) {
				return BasicDatatype.BOOLEAN;
			}
			return null;
		}

		if (exp instanceof LogicalRelationExpressionImpl) {
			var leftType = inferType(((LogicalRelationExpression) exp).getLeftOperand());
			var rightType = inferType(((LogicalRelationExpression) exp).getRightOperand());
			if (rightType.equals(leftType)) {
				return BasicDatatype.BOOLEAN;
			}
			return null;
		}
		return null;
	}

	public static String getTypeReference(TypeReference type) {
		String typeName = type.getIdentifier();
		return typeName;
	}

	public static int getTypePriority(String type) {
		return priortyType.indexOf(type) + 1;
	}

	public static boolean isTypeCastingPossible(String from, String to) {
		int fromPriority = getTypePriority(from);
		int toPriority = getTypePriority(to);
		if (fromPriority == 0 || toPriority == 0) {
			return false;
		}
		return fromPriority - toPriority < 0;
	}
}
