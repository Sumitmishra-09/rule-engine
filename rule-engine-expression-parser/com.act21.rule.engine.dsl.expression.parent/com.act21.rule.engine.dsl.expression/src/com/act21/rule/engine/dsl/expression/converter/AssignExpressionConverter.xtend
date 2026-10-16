package com.act21.rule.engine.dsl.expression.converter

import com.act21.rule.engine.dsl.datatype.TypeCastHandler
import com.act21.rule.engine.dsl.datatype.BasicDatatype
import com.act21.rule.engine.dsl.datatype.TypeSystem
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary
import com.act21.rule.engine.dsl.expression.functions.RegisteredFunctionTypes
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

@Singleton
class AssignExpressionConverter {

	@Inject
	InBuiltLibrary inBuiltLibrary;

	@Inject
	TypeCastHandler typeCastHandler;

	@Inject
	NumericalExpressionConveter numericalExpConverter

	def Expression convert(VariableDeclaration lhs, String lhsType, Expression exp) {
		if (exp === null) {
			return exp;
		}
		// Keep list results typed: validation checks the destination and generation appends their elements.
		if (RegisteredFunctionTypes.isListType(RegisteredFunctionTypes.typeOf(exp))) {
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

	def createAddAll(VariableDeclaration lhs, String lhsType, List<Expression> expressions) {
		var featureCall = ModelFactory.eINSTANCE.createFeatureCall;

		var erd = ModelFactory.eINSTANCE.createElementReferenceExpression;
		erd.reference = inBuiltLibrary.getClass("HelperFunctions", lhs)
		featureCall.owner = erd;
		featureCall.operationCall = true;

		var lhsErd = ModelFactory.eINSTANCE.createElementReferenceExpression;
		lhsErd.reference = lhs as VariableDeclaration

		var argument = ModelFactory.eINSTANCE.createArgument;
		argument.value = lhsErd;
		featureCall.arguments.add(argument);

		featureCall.feature = inBuiltLibrary.getFunction('HelperFunctions.addAll', lhs);

		for (var idx = 0; idx < expressions.length; idx++) {
			argument = ModelFactory.eINSTANCE.createArgument;
			argument.value = typeCastHandler.typeCast(expressions.get(idx), lhsType)
			featureCall.arguments.add(argument);
		}
		return featureCall;
	}

}
