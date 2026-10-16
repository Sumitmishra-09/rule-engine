package com.act21.rule.engine.dsl.expression.converter;

import com.act21.rule.engine.dsl.datatype.BasicDatatype;
import com.act21.rule.engine.dsl.datatype.TypeCastHandler;
import com.act21.rule.engine.dsl.datatype.TypeSystem;
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary;
import com.act21.rule.engine.dsl.expression.util.Type;
import com.act21.rule.engine.dsl.expression.util.Utils;
import com.act21.rule.engine.dsl.model.Argument;
import com.act21.rule.engine.dsl.model.ArrayExpression;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.Expression;
import com.act21.rule.engine.dsl.model.FeatureCall;
import com.act21.rule.engine.dsl.model.ModelFactory;
import com.act21.rule.engine.dsl.model.ParenthesizedExpression;
import com.act21.rule.engine.dsl.model.VariableDeclaration;
import com.act21.rule.engine.dsl.model.impl.ArrayExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.FeatureCallImpl;
import com.act21.rule.engine.dsl.model.impl.LiteralExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalUnaryExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.ParenthesizedExpressionImpl;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import javax.inject.Singleton;
import org.eclipse.xtext.xbase.lib.Conversions;

@Singleton
@SuppressWarnings("all")
public class AssignExpressionConverter {
  @Inject
  private InBuiltLibrary inBuiltLibrary;

  @Inject
  private TypeCastHandler typeCastHandler;

  @Inject
  private NumericalExpressionConveter numericalExpConverter;

  public Expression convert(final VariableDeclaration lhs, final Type lhsType, final Expression exp) {
    if ((exp == null)) {
      return exp;
    }
    final Type valueType = TypeSystem.inferType(exp);
    if (((valueType != null) && BasicDatatype.LIST.equals(valueType.getBaseType()))) {
      return exp;
    }
    Class<? extends Expression> _class = exp.getClass();
    boolean _matched = false;
    if (Objects.equal(_class, ArrayExpressionImpl.class)) {
      _matched=true;
      return this.createAddAll(lhs, lhsType, ((ArrayExpression) exp).getElements());
    }
    if (!_matched) {
      if (Objects.equal(_class, ParenthesizedExpressionImpl.class)) {
        _matched=true;
        ((ParenthesizedExpression) exp).setExpression(this.convert(lhs, lhsType, 
          ((ParenthesizedExpression) exp).getExpression()));
        Expression _xifexpression = null;
        Expression _expression = ((ParenthesizedExpression) exp).getExpression();
        boolean _tripleEquals = (_expression == null);
        if (_tripleEquals) {
          _xifexpression = null;
        } else {
          _xifexpression = exp;
        }
        return _xifexpression;
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, NumericalExpressionImpl.class)) {
        _matched=true;
        Expression expression = this.numericalExpConverter.convert(exp);
        return this.typeCastHandler.typeCast(expression, lhsType);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, ElementReferenceExpressionImpl.class)) {
        _matched=true;
        boolean _isCollection = Utils.isCollection(lhs.getType());
        if (_isCollection) {
          return this.createAddAll(lhs, lhsType, List.<Expression>of(exp));
        }
        return this.typeCastHandler.typeCast(exp, lhsType);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, FeatureCallImpl.class)) {
        _matched=true;
        boolean _isCollection_1 = Utils.isCollection(lhs.getType());
        if (_isCollection_1) {
          return this.createAddAll(lhs, lhsType, List.<Expression>of(exp));
        }
        return this.typeCastHandler.typeCast(exp, lhsType);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, LiteralExpressionImpl.class)) {
        _matched=true;
        boolean _isCollection_2 = Utils.isCollection(lhs.getType());
        if (_isCollection_2) {
          return this.createAddAll(lhs, lhsType, List.<Expression>of(exp));
        }
        return this.typeCastHandler.typeCast(exp, lhsType);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, NumericalUnaryExpressionImpl.class)) {
        _matched=true;
        boolean _isCollection_3 = Utils.isCollection(lhs.getType());
        if (_isCollection_3) {
          return this.createAddAll(lhs, lhsType, List.<Expression>of(exp));
        }
        return this.typeCastHandler.typeCast(exp, lhsType);
      }
    }
    return this.typeCastHandler.typeCast(exp, lhsType);
  }

  public FeatureCall createAddAll(final VariableDeclaration lhs, final Type lhsType, final List<Expression> expressions) {
    FeatureCall featureCall = ModelFactory.eINSTANCE.createFeatureCall();
    ElementReferenceExpression erd = ModelFactory.eINSTANCE.createElementReferenceExpression();
    erd.setReference(this.inBuiltLibrary.getClass("HelperFunctions", lhs));
    featureCall.setOwner(erd);
    featureCall.setOperationCall(true);
    ElementReferenceExpression lhsErd = ModelFactory.eINSTANCE.createElementReferenceExpression();
    lhsErd.setReference(((VariableDeclaration) lhs));
    Argument argument = ModelFactory.eINSTANCE.createArgument();
    argument.setValue(lhsErd);
    featureCall.getArguments().add(argument);
    featureCall.setFeature(this.inBuiltLibrary.getFunction("HelperFunctions.addAll", lhs));
    for (int idx = 0; (idx < ((Object[])Conversions.unwrapArray(expressions, Object.class)).length); idx++) {
      {
        argument = ModelFactory.eINSTANCE.createArgument();
        argument.setValue(this.typeCastHandler.typeCast(expressions.get(idx), lhsType));
        featureCall.getArguments().add(argument);
      }
    }
    return featureCall;
  }
}
