package com.act21.rule.engine.dsl.expression.converter

import com.act21.rule.engine.dsl.datatype.TypeCastHandler
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary
import com.act21.rule.engine.dsl.model.ArrayExpression
import com.act21.rule.engine.dsl.model.Expression
import com.act21.rule.engine.dsl.model.ModelFactory
import com.act21.rule.engine.dsl.model.ParenthesizedExpression
import com.act21.rule.engine.dsl.model.VariableDeclaration
import com.act21.rule.engine.dsl.model.impl.ArrayExpressionImpl
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl
import com.act21.rule.engine.dsl.model.impl.FeatureCallImpl
import com.act21.rule.engine.dsl.model.impl.LiteralExpressionImpl
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl
import com.act21.rule.engine.dsl.model.impl.NumericalUnaryExpressionImpl
import com.act21.rule.engine.dsl.model.impl.ParenthesizedExpressionImpl
import com.google.inject.Inject
import java.util.List
import javax.inject.Singleton
import com.act21.rule.engine.dsl.expression.util.Utils
import com.act21.rule.engine.dsl.expression.util.Type

@Singleton
class AssignExpressionConverter {

	@Inject
	InBuiltLibrary inBuiltLibrary;

	@Inject
	TypeCastHandler typeCastHandler;

	@Inject
	NumericalExpressionConveter numericalExpConverter

	def Expression convert(VariableDeclaration lhs, Type lhsType, Expression exp) {
		if (exp === null) {
			return exp;
		}
		switch (exp.class) {
			case ArrayExpressionImpl: {
				return createAddAll(lhs, lhsType, (exp as ArrayExpression).elements);
			}
			case ParenthesizedExpressionImpl: {
				(exp as ParenthesizedExpression).expression = convert(lhs, lhsType,
					(exp as ParenthesizedExpression).expression);
				return (exp as ParenthesizedExpression).expression === null ? null : exp;
			}
			case NumericalExpressionImpl: {
				var expression = numericalExpConverter.convert(exp);
				return typeCastHandler.typeCast(expression, lhsType);
			}
			case ElementReferenceExpressionImpl: {
				if (Utils.isCollection(lhs.type)) {
					return createAddAll(lhs, lhsType, List.of(exp));
				}
				return typeCastHandler.typeCast(exp, lhsType);
			}
			case FeatureCallImpl: {
				if (Utils.isCollection(lhs.type)) {
					return createAddAll(lhs, lhsType, List.of(exp));
				}
				return typeCastHandler.typeCast(exp, lhsType);
			}
			case LiteralExpressionImpl: {
				if (Utils.isCollection(lhs.type)) {
					return createAddAll(lhs, lhsType, List.of(exp));
				}
				return typeCastHandler.typeCast(exp, lhsType);
			}
			case NumericalUnaryExpressionImpl: {
				if (Utils.isCollection(lhs.type)) {
					return createAddAll(lhs, lhsType, List.of(exp));
				}
				return typeCastHandler.typeCast(exp, lhsType);
			}
			default: {
				return typeCastHandler.typeCast(exp, lhsType);
			}
		}
	}

	def createAddAll(VariableDeclaration lhs, Type lhsType, List<Expression> expressions) {
		var featureCall = ModelFactory.eINSTANCE.createFeatureCall;

		var erd = ModelFactory.eINSTANCE.createElementReferenceExpression;
		erd.reference = inBuiltLibrary.getClass("HelperFunctions")
		featureCall.owner = erd;
		featureCall.operationCall = true;

		var lhsErd = ModelFactory.eINSTANCE.createElementReferenceExpression;
		lhsErd.reference = lhs as VariableDeclaration

		var argument = ModelFactory.eINSTANCE.createArgument;
		argument.value = lhsErd;
		featureCall.arguments.add(argument);

		featureCall.feature = inBuiltLibrary.getFunction('HelperFunctions.addAll');

		for (var idx = 0; idx < expressions.length; idx++) {
			argument = ModelFactory.eINSTANCE.createArgument;
			argument.value = typeCastHandler.typeCast(expressions.get(idx), lhsType)
			featureCall.arguments.add(argument);
		}
		return featureCall;
	}

}
