package com.act21.rule.engine.dsl.expression.converter

import com.act21.rule.engine.dsl.datatype.TypeCastHandler
import com.act21.rule.engine.dsl.datatype.TypeSystem
import com.act21.rule.engine.dsl.expression.util.Utils
import com.act21.rule.engine.dsl.model.ElementReferenceExpression
import com.act21.rule.engine.dsl.model.Expression
import com.act21.rule.engine.dsl.model.NumericalExpression
import com.act21.rule.engine.dsl.model.ParenthesizedExpression
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl
import com.act21.rule.engine.dsl.model.impl.ParenthesizedExpressionImpl
import com.google.inject.Inject
import com.google.inject.Singleton

@Singleton
class NumericalExpressionConveter {

	@Inject
	TypeCastHandler typeCastHandler;

	def Expression convert(Expression exp) {
		switch (exp.class) {
			case NumericalExpressionImpl: {
				(exp as NumericalExpression).leftOperand = convert((exp as NumericalExpression).leftOperand);
				var leftType = TypeSystem.inferType((exp as NumericalExpression).leftOperand);
				(exp as NumericalExpression).rightOperand = convert((exp as NumericalExpression).rightOperand);
				var rightType = TypeSystem.inferType((exp as NumericalExpression).rightOperand);
				if (leftType.equals(rightType)) {
					return exp;
				} else if (TypeSystem.isTypeCastingPossible(leftType, rightType)) {
					(exp as NumericalExpression).leftOperand = typeCastHandler.createTypeCastExpression(
						(exp as NumericalExpression).leftOperand, rightType)
				} else {
					(exp as NumericalExpression).rightOperand = typeCastHandler.createTypeCastExpression(
						(exp as NumericalExpression).rightOperand, leftType)
				}

				return exp;
			}
			case ParenthesizedExpressionImpl: {
				(exp as ParenthesizedExpression).expression = convert((exp as ParenthesizedExpressionImpl).expression)
				return exp;
			}
			case ElementReferenceExpressionImpl: {
				if ((exp as ElementReferenceExpression).unresolvedText !== null) {
					return Utils.convertERDtoLiteralExpression(exp as ElementReferenceExpression)
				}
				return exp;
			}
			default: {
				return exp;
			}
		}
	}

}
