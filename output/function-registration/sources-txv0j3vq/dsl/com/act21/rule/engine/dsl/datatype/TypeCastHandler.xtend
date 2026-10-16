package com.act21.rule.engine.dsl.datatype

import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary
import com.act21.rule.engine.dsl.expression.util.Type
import com.act21.rule.engine.dsl.expression.util.Utils
import com.act21.rule.engine.dsl.model.Argument
import com.act21.rule.engine.dsl.model.Expression
import com.act21.rule.engine.dsl.model.ModelFactory
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl
import com.act21.rule.engine.dsl.model.impl.FeatureCallImpl
import com.act21.rule.engine.dsl.model.impl.LiteralExpressionImpl
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl
import com.act21.rule.engine.dsl.model.impl.NumericalUnaryExpressionImpl
import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.common.util.EList

@Singleton
class TypeCastHandler {

	@Inject
	InBuiltLibrary inBuiltLibrary

	def Expression createTypeCastExpression(Expression expression, Type targetType) {
		if (targetType === null) {
			return expression;
		}
		var featureCall = ModelFactory.eINSTANCE.createFeatureCall;

		var erd = ModelFactory.eINSTANCE.createElementReferenceExpression;
		erd.reference = inBuiltLibrary.getClass("HelperFunctions")
		featureCall.owner = erd;
		featureCall.operationCall = true;
		var argument = ModelFactory.eINSTANCE.createArgument;
		argument.value = expression;
		featureCall.arguments.add(argument);

		switch (targetType.baseType) {
			case BasicDatatype.INT: {
				featureCall.feature = inBuiltLibrary.getFunction("HelperFunctions.convertToInt");
				return featureCall;
			}
			case BasicDatatype.STRING: {
				featureCall.feature = inBuiltLibrary.getFunction("HelperFunctions.convertToString");
				return featureCall;
			}
			case BasicDatatype.DECIMAL: {
				featureCall.feature = inBuiltLibrary.getFunction("HelperFunctions.convertToBigDecimal");
				return featureCall;
			}
			default:
				return expression
		}
	}

	def Expression typeCast(Expression exp, Type targetType) {
		var expType = TypeSystem.inferType(exp);
		if (Utils.isCompatible(targetType, expType)) {
			return exp;
		}
		if (!TypeSystem.isTypeCastingPossible(expType, targetType)) {
			return exp;
		}
		switch (exp.class) {
			case LiteralExpressionImpl: {
				return createTypeCastExpression(exp, targetType);
			}
			case NumericalExpressionImpl: {
				return createTypeCastExpression(exp, targetType)
			}
			case ElementReferenceExpressionImpl: {
				return createTypeCastExpression(exp, targetType)
			}
			case FeatureCallImpl: {
				return createTypeCastExpression(exp, targetType)
			}
			case NumericalUnaryExpressionImpl: {
				return createTypeCastExpression(exp, targetType)
			}
			default: {
				return exp;
			}
		}
	}

	def typeCaseArgs(EList<Argument> list, Type type) {
		list.forEach[(it.value = typeCast(it.value, type))]
	}

}
