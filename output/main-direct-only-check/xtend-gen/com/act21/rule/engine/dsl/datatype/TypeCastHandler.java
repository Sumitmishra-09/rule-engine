package com.act21.rule.engine.dsl.datatype;

import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary;
import com.act21.rule.engine.dsl.expression.util.Utils;
import com.act21.rule.engine.dsl.model.Argument;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.Expression;
import com.act21.rule.engine.dsl.model.FeatureCall;
import com.act21.rule.engine.dsl.model.ModelFactory;
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.FeatureCallImpl;
import com.act21.rule.engine.dsl.model.impl.LiteralExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalUnaryExpressionImpl;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;

@Singleton
@SuppressWarnings("all")
public class TypeCastHandler {
  @Inject
  private InBuiltLibrary inBuiltLibrary;

  public Expression createTypeCastExpression(final Expression expression, final String targetType) {
    final InBuiltLibrary library = this.inBuiltLibrary.forContext(expression);
    FeatureCall featureCall = ModelFactory.eINSTANCE.createFeatureCall();
    ElementReferenceExpression erd = ModelFactory.eINSTANCE.createElementReferenceExpression();
    erd.setReference(library.getClass("HelperFunctions"));
    featureCall.setOwner(erd);
    featureCall.setOperationCall(true);
    Argument argument = ModelFactory.eINSTANCE.createArgument();
    argument.setValue(expression);
    featureCall.getArguments().add(argument);
    boolean _matched = false;
    if (Objects.equal(targetType, BasicDatatype.INT)) {
      _matched=true;
      featureCall.setFeature(library.getFunction("HelperFunctions.convertToInt"));
      return featureCall;
    }
    if (!_matched) {
      if (Objects.equal(targetType, BasicDatatype.STRING)) {
        _matched=true;
        featureCall.setFeature(library.getFunction("HelperFunctions.convertToString"));
        return featureCall;
      }
    }
    if (!_matched) {
      if (Objects.equal(targetType, BasicDatatype.DECIMAL)) {
        _matched=true;
        featureCall.setFeature(library.getFunction("HelperFunctions.convertToBigDecimal"));
        return featureCall;
      }
    }
    return expression;
  }

  public Expression typeCast(final Expression exp, final String targetType) {
    String expType = TypeSystem.inferType(exp);
    boolean _isCompatible = Utils.isCompatible(targetType, expType);
    if (_isCompatible) {
      return exp;
    }
    boolean _isTypeCastingPossible = TypeSystem.isTypeCastingPossible(expType, targetType);
    boolean _not = (!_isTypeCastingPossible);
    if (_not) {
      return exp;
    }
    Class<? extends Expression> _class = exp.getClass();
    boolean _matched = false;
    if (Objects.equal(_class, LiteralExpressionImpl.class)) {
      _matched=true;
      return this.createTypeCastExpression(exp, targetType);
    }
    if (!_matched) {
      if (Objects.equal(_class, NumericalExpressionImpl.class)) {
        _matched=true;
        return this.createTypeCastExpression(exp, targetType);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, ElementReferenceExpressionImpl.class)) {
        _matched=true;
        return this.createTypeCastExpression(exp, targetType);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, FeatureCallImpl.class)) {
        _matched=true;
        return this.createTypeCastExpression(exp, targetType);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, NumericalUnaryExpressionImpl.class)) {
        _matched=true;
        return this.createTypeCastExpression(exp, targetType);
      }
    }
    return exp;
  }

  public void typeCaseArgs(final EList<Argument> list, final String type) {
    final Consumer<Argument> _function = (Argument it) -> {
      it.setValue(this.typeCast(it.getValue(), type));
    };
    list.forEach(_function);
  }
}
