package com.act21.rule.engine.dsl.expression.converter

import com.act21.rule.engine.dsl.datatype.BasicDatatype
import com.act21.rule.engine.dsl.datatype.TypeCastHandler
import com.act21.rule.engine.dsl.datatype.TypeSystem
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary
import com.act21.rule.engine.dsl.model.AllLiteral
import com.act21.rule.engine.dsl.model.Argument
import com.act21.rule.engine.dsl.model.ArrayExpression
import com.act21.rule.engine.dsl.model.BoolLiteral
import com.act21.rule.engine.dsl.model.ElementReferenceExpression
import com.act21.rule.engine.dsl.model.Expression
import com.act21.rule.engine.dsl.model.FeatureCall
import com.act21.rule.engine.dsl.model.LiteralExpression
import com.act21.rule.engine.dsl.model.LogicalAndExpression
import com.act21.rule.engine.dsl.model.LogicalOrExpression
import com.act21.rule.engine.dsl.model.LogicalRelationExpression
import com.act21.rule.engine.dsl.model.ModelFactory
import com.act21.rule.engine.dsl.model.NumericalUnaryExpression
import com.act21.rule.engine.dsl.model.ParenthesizedExpression
import com.act21.rule.engine.dsl.model.PassLiteral
import com.act21.rule.engine.dsl.model.RangeExpression
import com.act21.rule.engine.dsl.model.RelationalOperator
import com.act21.rule.engine.dsl.model.RelationalUnaryExpression
import com.act21.rule.engine.dsl.model.VariableDeclaration
import com.act21.rule.engine.dsl.model.impl.ArrayExpressionImpl
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl
import com.act21.rule.engine.dsl.model.impl.FeatureCallImpl
import com.act21.rule.engine.dsl.model.impl.LiteralExpressionImpl
import com.act21.rule.engine.dsl.model.impl.LogicalAndExpressionImpl
import com.act21.rule.engine.dsl.model.impl.LogicalOrExpressionImpl
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl
import com.act21.rule.engine.dsl.model.impl.NumericalUnaryExpressionImpl
import com.act21.rule.engine.dsl.model.impl.ParenthesizedExpressionImpl
import com.act21.rule.engine.dsl.model.impl.RangeExpressionImpl
import com.act21.rule.engine.dsl.model.impl.RelationalUnaryExpressionImpl
import com.google.inject.Inject
import javax.inject.Singleton
import org.eclipse.emf.common.util.EList
import com.act21.rule.engine.dsl.model.impl.LogicalNotExpressionImpl
import com.act21.rule.engine.dsl.model.LogicalNotExpression

@Singleton
class DecideExpressionConverter {

	@Inject
	InBuiltLibrary inBuiltLibrary;
	@Inject
	TypeCastHandler typeCastHandler;
	@Inject
	NumericalExpressionConveter numericalExpConverter

	def Expression convert(VariableDeclaration lhs, String lhsType, Expression exp) {
		if (exp === null) {
			var literalExp = ModelFactory.eINSTANCE.createLiteralExpression;
			literalExp.value = ModelFactory.eINSTANCE.createPassLiteral();
			return literalExp;
		}
		switch (exp.class) {
			case LogicalOrExpressionImpl: {
				(exp as LogicalOrExpression).leftOperand = convert(lhs, lhsType,
					(exp as LogicalOrExpression).leftOperand);
				(exp as LogicalOrExpression).rightOperand = convert(lhs, lhsType,
					(exp as LogicalOrExpression).rightOperand);
				return exp;
			}
			case LogicalNotExpressionImpl: {
				(exp as LogicalNotExpression).operand = convert(lhs, lhsType, (exp as LogicalNotExpression).operand);
				return exp;
			}
			case LogicalAndExpressionImpl: {
				(exp as LogicalAndExpression).leftOperand = convert(lhs, lhsType,
					(exp as LogicalAndExpression).leftOperand);
				(exp as LogicalAndExpression).rightOperand = convert(lhs, lhsType,
					(exp as LogicalAndExpression).rightOperand);
				return exp;
			}
			case ParenthesizedExpressionImpl: {
				(exp as ParenthesizedExpression).expression = convert(lhs, lhsType,
					(exp as ParenthesizedExpression).expression);
				return exp;
			}
			default: {
				return convertToLogicalExpression(lhs, lhsType, exp);
			}
		}
	}

	def Expression convertToLogicalExpression(VariableDeclaration lhs, String lhsType, Expression exp) {
		switch (exp.class) {
			case LiteralExpressionImpl: {
				if ((exp as LiteralExpression).value instanceof PassLiteral ||
					(exp as LiteralExpression).value instanceof AllLiteral) {
					(exp as LiteralExpression).value = createBoolLiteral(true);
					return exp
				}
				return createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS, exp);
			}
			case RelationalUnaryExpressionImpl: {
				return createLogicalRelationExpression(lhs, lhsType,
					RelationalOperator.get((exp as RelationalUnaryExpression).operator.value),
					(exp as RelationalUnaryExpression).operand);
			}
			case ElementReferenceExpressionImpl: {
				var expression = exp;
				// Registered functions always receive exactly the arguments written in the cell.
				if (inBuiltLibrary.getRegisteredFunction((exp as ElementReferenceExpression).reference) !== null &&
					BasicDatatype.BOOLEAN.equals(TypeSystem.inferType(exp))) {
					return exp;
				}
				if ((exp as ElementReferenceExpression).operationCall === true &&
					BasicDatatype.BOOLEAN.equals(TypeSystem.inferType(exp))) {
					(exp as ElementReferenceExpression).arguments.add(0, createArgument(lhs));
					typeCastHandler.typeCaseArgs((exp as ElementReferenceExpression).arguments, lhsType);
					return exp;
				}
				return createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS, expression);
			}
			case FeatureCallImpl: {
				// Registered functions always receive exactly the arguments written in the cell.
				if (inBuiltLibrary.getRegisteredFunction((exp as FeatureCall).feature) !== null &&
					BasicDatatype.BOOLEAN.equals(TypeSystem.inferType(exp))) {
					return exp;
				}
				if ((exp as FeatureCall).operationCall === true &&
					BasicDatatype.BOOLEAN.equals(TypeSystem.inferType(exp))) {
					(exp as FeatureCall).arguments.add(0, createArgument(lhs));
					typeCastHandler.typeCaseArgs((exp as FeatureCall).arguments, lhsType);
					return exp;
				}
				return createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS, exp);
			}
			case NumericalExpressionImpl: {
				var expression = numericalExpConverter.convert(exp);
				return createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS, expression);
			}
			case ArrayExpressionImpl: {
				return createInExpression(lhs, lhsType, (exp as ArrayExpression).elements as EList<Expression>);
			}
			case RangeExpressionImpl: {
				return convertToLogicalExpression(lhs, lhsType, exp as RangeExpression);
			}
			case NumericalUnaryExpressionImpl: {
				return createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS,
					exp as NumericalUnaryExpression)
			}
			default: {
				return exp
			}
		}
	}

	def LogicalRelationExpression createLogicalRelationExpression(VariableDeclaration lhs, String lhsType,
		RelationalOperator operator, Expression right) {

		if (BasicDatatype.STRING.equals(lhsType) &&
			!(RelationalOperator.EQUALS.toString().equals(operator.toString()) ||
				RelationalOperator.NOT_EQUALS.toString().equals(operator.toString()))) {
			return null;
		}
		var classErd = ModelFactory.eINSTANCE.createElementReferenceExpression;
		classErd.reference = lhs;
		var logicalExpression = ModelFactory.eINSTANCE.createLogicalRelationExpression;
		logicalExpression.leftOperand = classErd;
		logicalExpression.operator = operator;
		logicalExpression.rightOperand = typeCastHandler.typeCast(right, lhsType);
		return logicalExpression;

	}

	def Expression convertToLogicalExpression(VariableDeclaration lhs, String lhsType, RangeExpression exp) {
		// Create Logical And Expression
		val logicalAndExpression = ModelFactory.eINSTANCE.createLogicalAndExpression;

		// create left operand for logical and expression
		var leftOperator = (exp as RangeExpression).leftBracket.equals(']') ? RelationalOperator.
				GREATER : RelationalOperator.GREATER_EQUAL;
		var leftExpression = typeCastHandler.typeCast(exp.leftExpression, lhsType)
		logicalAndExpression.leftOperand = createLogicalRelationExpression(lhs, lhsType, leftOperator, leftExpression)

		// create right operand for logical and expression
		var rightOperator = exp.rightBracket.equals(']')
				? RelationalOperator.SMALLER_EQUAL
				: RelationalOperator.SMALLER;
		var rightExpression = typeCastHandler.typeCast(exp.rightExpression, lhsType)

		logicalAndExpression.rightOperand = createLogicalRelationExpression(lhs, lhsType, rightOperator,
			rightExpression)

		return logicalAndExpression;
	}

	def createInExpression(VariableDeclaration lhs, String lhsType, EList<Expression> expressions) {

		var featureCall = ModelFactory.eINSTANCE.createFeatureCall;

		var erd = ModelFactory.eINSTANCE.createElementReferenceExpression;
		erd.reference = inBuiltLibrary.getClass("HelperFunctions", lhs)
		featureCall.owner = erd;
		featureCall.operationCall = true;

		var erdExp = ModelFactory.eINSTANCE.createElementReferenceExpression
		erdExp.reference = lhs

		var argument = ModelFactory.eINSTANCE.createArgument;
		argument.value = erdExp;
		featureCall.arguments.add(argument);

		featureCall.feature = inBuiltLibrary.getFunction("HelperFunctions.in", lhs);
		for (var idx = 0; idx < expressions.length; idx++) {
			argument = ModelFactory.eINSTANCE.createArgument;
			argument.value = typeCastHandler.typeCast(expressions.get(idx), lhsType)
			featureCall.arguments.add(argument);
		}
		return featureCall;
	}

	def BoolLiteral createBoolLiteral(Boolean value) {
		var boolLiteral = ModelFactory.eINSTANCE.createBoolLiteral;
		boolLiteral.value = value;
		return boolLiteral;
	}

	def Argument createArgument(VariableDeclaration lhs) {
		var lhsErd = ModelFactory.eINSTANCE.createElementReferenceExpression();
		var arg = ModelFactory.eINSTANCE.createArgument();
		lhsErd.reference = lhs;
		arg.value = lhsErd;
		return arg;
	}

}
