package com.act21.rule.engine.dsl.expression.converter;

import com.act21.rule.engine.dsl.datatype.TypeCastHandler;
import com.act21.rule.engine.dsl.datatype.TypeSystem;
import com.act21.rule.engine.dsl.expression.util.Utils;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.Expression;
import com.act21.rule.engine.dsl.model.NumericalExpression;
import com.act21.rule.engine.dsl.model.ParenthesizedExpression;
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.ParenthesizedExpressionImpl;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@SuppressWarnings("all")
public class NumericalExpressionConveter {
  @Inject
  private TypeCastHandler typeCastHandler;

  public Expression convert(final Expression exp) {
    Class<? extends Expression> _class = exp.getClass();
    boolean _matched = false;
    if (Objects.equal(_class, NumericalExpressionImpl.class)) {
      _matched=true;
      ((NumericalExpression) exp).setLeftOperand(this.convert(((NumericalExpression) exp).getLeftOperand()));
      String leftType = TypeSystem.inferType(((NumericalExpression) exp).getLeftOperand());
      ((NumericalExpression) exp).setRightOperand(this.convert(((NumericalExpression) exp).getRightOperand()));
      String rightType = TypeSystem.inferType(((NumericalExpression) exp).getRightOperand());
      boolean _equals = leftType.equals(rightType);
      if (_equals) {
        return exp;
      } else {
        boolean _isTypeCastingPossible = TypeSystem.isTypeCastingPossible(leftType, rightType);
        if (_isTypeCastingPossible) {
          ((NumericalExpression) exp).setLeftOperand(this.typeCastHandler.createTypeCastExpression(
            ((NumericalExpression) exp).getLeftOperand(), rightType));
        } else {
          ((NumericalExpression) exp).setRightOperand(this.typeCastHandler.createTypeCastExpression(
            ((NumericalExpression) exp).getRightOperand(), leftType));
        }
      }
      return exp;
    }
    if (!_matched) {
      if (Objects.equal(_class, ParenthesizedExpressionImpl.class)) {
        _matched=true;
        ((ParenthesizedExpression) exp).setExpression(this.convert(((ParenthesizedExpressionImpl) exp).getExpression()));
        return exp;
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, ElementReferenceExpressionImpl.class)) {
        _matched=true;
        String _unresolvedText = ((ElementReferenceExpression) exp).getUnresolvedText();
        boolean _tripleNotEquals = (_unresolvedText != null);
        if (_tripleNotEquals) {
          return Utils.convertERDtoLiteralExpression(((ElementReferenceExpression) exp));
        }
        return exp;
      }
    }
    return exp;
  }
}
