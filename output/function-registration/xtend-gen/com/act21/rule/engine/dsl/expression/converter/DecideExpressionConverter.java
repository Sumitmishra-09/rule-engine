package com.act21.rule.engine.dsl.expression.converter;

import com.act21.rule.engine.dsl.datatype.BasicDatatype;
import com.act21.rule.engine.dsl.datatype.TypeCastHandler;
import com.act21.rule.engine.dsl.datatype.TypeSystem;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary;
import com.act21.rule.engine.dsl.expression.util.Type;
import com.act21.rule.engine.dsl.expression.util.Utils;
import com.act21.rule.engine.dsl.model.AllLiteral;
import com.act21.rule.engine.dsl.model.Argument;
import com.act21.rule.engine.dsl.model.ArrayExpression;
import com.act21.rule.engine.dsl.model.BoolLiteral;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.Expression;
import com.act21.rule.engine.dsl.model.FeatureCall;
import com.act21.rule.engine.dsl.model.FunctionDeclaration;
import com.act21.rule.engine.dsl.model.LiteralExpression;
import com.act21.rule.engine.dsl.model.LogicalAndExpression;
import com.act21.rule.engine.dsl.model.LogicalNotExpression;
import com.act21.rule.engine.dsl.model.LogicalOrExpression;
import com.act21.rule.engine.dsl.model.LogicalRelationExpression;
import com.act21.rule.engine.dsl.model.ModelFactory;
import com.act21.rule.engine.dsl.model.NamedElement;
import com.act21.rule.engine.dsl.model.NumericalUnaryExpression;
import com.act21.rule.engine.dsl.model.Parameter;
import com.act21.rule.engine.dsl.model.ParenthesizedExpression;
import com.act21.rule.engine.dsl.model.PassLiteral;
import com.act21.rule.engine.dsl.model.RangeExpression;
import com.act21.rule.engine.dsl.model.RelationalOperator;
import com.act21.rule.engine.dsl.model.RelationalUnaryExpression;
import com.act21.rule.engine.dsl.model.VariableDeclaration;
import com.act21.rule.engine.dsl.model.impl.ArrayExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.FeatureCallImpl;
import com.act21.rule.engine.dsl.model.impl.LiteralExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalAndExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalNotExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalOrExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalUnaryExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.ParenthesizedExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.RangeExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.RelationalUnaryExpressionImpl;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class DecideExpressionConverter {
  @Inject
  private InBuiltLibrary inBuiltLibrary;

  @Inject
  private TypeCastHandler typeCastHandler;

  @Inject
  private NumericalExpressionConveter numericalExpConverter;

  public Expression convert(final VariableDeclaration lhs, final Type lhsType, final Expression exp) {
    if ((exp == null)) {
      LiteralExpression literalExp = ModelFactory.eINSTANCE.createLiteralExpression();
      literalExp.setValue(ModelFactory.eINSTANCE.createPassLiteral());
      return literalExp;
    }
    Class<? extends Expression> _class = exp.getClass();
    boolean _matched = false;
    if (Objects.equal(_class, LogicalOrExpressionImpl.class)) {
      _matched=true;
      ((LogicalOrExpression) exp).setLeftOperand(this.convert(lhs, lhsType, 
        ((LogicalOrExpression) exp).getLeftOperand()));
      ((LogicalOrExpression) exp).setRightOperand(this.convert(lhs, lhsType, 
        ((LogicalOrExpression) exp).getRightOperand()));
      return exp;
    }
    if (!_matched) {
      if (Objects.equal(_class, LogicalNotExpressionImpl.class)) {
        _matched=true;
        ((LogicalNotExpression) exp).setOperand(this.convert(lhs, lhsType, ((LogicalNotExpression) exp).getOperand()));
        return exp;
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, LogicalAndExpressionImpl.class)) {
        _matched=true;
        ((LogicalAndExpression) exp).setLeftOperand(this.convert(lhs, lhsType, 
          ((LogicalAndExpression) exp).getLeftOperand()));
        ((LogicalAndExpression) exp).setRightOperand(this.convert(lhs, lhsType, 
          ((LogicalAndExpression) exp).getRightOperand()));
        return exp;
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, ParenthesizedExpressionImpl.class)) {
        _matched=true;
        ((ParenthesizedExpression) exp).setExpression(this.convert(lhs, lhsType, 
          ((ParenthesizedExpression) exp).getExpression()));
        return exp;
      }
    }
    return this.convertToLogicalExpression(lhs, lhsType, exp);
  }

  public Expression convertToLogicalExpression(final VariableDeclaration lhs, final Type lhsType, final Expression exp) {
    Class<? extends Expression> _class = exp.getClass();
    boolean _matched = false;
    if (Objects.equal(_class, LiteralExpressionImpl.class)) {
      _matched=true;
      if (((((LiteralExpression) exp).getValue() instanceof PassLiteral) || 
        (((LiteralExpression) exp).getValue() instanceof AllLiteral))) {
        ((LiteralExpression) exp).setValue(this.createBoolLiteral(Boolean.valueOf(true)));
        return exp;
      }
      return this.createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS, exp);
    }
    if (!_matched) {
      if (Objects.equal(_class, RelationalUnaryExpressionImpl.class)) {
        _matched=true;
        return this.createLogicalRelationExpression(lhs, lhsType, 
          RelationalOperator.get(((RelationalUnaryExpression) exp).getOperator().getValue()), 
          ((RelationalUnaryExpression) exp).getOperand());
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, ElementReferenceExpressionImpl.class)) {
        _matched=true;
        Expression expression = exp;
        Type expType = TypeSystem.inferType(exp);
        boolean _and = false;
        FunctionRegistry.Definition _registeredFunction = this.inBuiltLibrary.getRegisteredFunction(((ElementReferenceExpression) exp).getReference());
        boolean _tripleNotEquals = (_registeredFunction != null);
        if (!_tripleNotEquals) {
          _and = false;
        } else {
          String _baseType = null;
          if (expType!=null) {
            _baseType=expType.getBaseType();
          }
          boolean _equals = BasicDatatype.BOOLEAN.equals(_baseType);
          _and = _equals;
        }
        if (_and) {
          return exp;
        }
        if ((((Boolean.valueOf(((ElementReferenceExpression) exp).isOperationCall()) == Boolean.valueOf(true)) && (expType != null)) && 
          BasicDatatype.BOOLEAN.equals(expType.getBaseType()))) {
          boolean _test = Utils.isParentLogicalExpression().test(exp);
          boolean _not = (!_test);
          if (_not) {
            ((ElementReferenceExpression) exp).getArguments().add(0, this.createArgument(lhs));
          }
          NamedElement _reference = ((ElementReferenceExpression) exp).getReference();
          if ((_reference instanceof FunctionDeclaration)) {
            NamedElement _reference_1 = ((ElementReferenceExpression) exp).getReference();
            EList<Parameter> parameters = ((FunctionDeclaration) _reference_1).getParameters();
            EList<Argument> arguments = ((ElementReferenceExpression) exp).getArguments();
            int idx = 0;
            while ((idx < arguments.size())) {
              {
                Type _xifexpression = null;
                int _size = parameters.size();
                boolean _lessThan = (idx < _size);
                if (_lessThan) {
                  _xifexpression = TypeSystem.inferType(parameters.get(idx));
                } else {
                  Type _xifexpression_1 = null;
                  if (((!parameters.isEmpty()) && (IterableExtensions.<Parameter>last(parameters).getVarArgs() != null))) {
                    _xifexpression_1 = TypeSystem.inferType(IterableExtensions.<Parameter>last(parameters));
                  } else {
                    _xifexpression_1 = null;
                  }
                  _xifexpression = _xifexpression_1;
                }
                final Type paramType = _xifexpression;
                Argument _get = arguments.get(idx);
                Expression _xifexpression_2 = null;
                if ((paramType != null)) {
                  _xifexpression_2 = this.typeCastHandler.typeCast(arguments.get(idx).getValue(), paramType);
                } else {
                  _xifexpression_2 = arguments.get(idx).getValue();
                }
                _get.setValue(_xifexpression_2);
                idx++;
              }
            }
          } else {
            this.typeCastHandler.typeCaseArgs(((ElementReferenceExpression) exp).getArguments(), lhsType);
          }
          return exp;
        }
        return this.createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS, expression);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, FeatureCallImpl.class)) {
        _matched=true;
        Type expType_1 = TypeSystem.inferType(exp);
        boolean _and_1 = false;
        FunctionRegistry.Definition _registeredFunction_1 = this.inBuiltLibrary.getRegisteredFunction(((FeatureCall) exp).getFeature());
        boolean _tripleNotEquals_1 = (_registeredFunction_1 != null);
        if (!_tripleNotEquals_1) {
          _and_1 = false;
        } else {
          String _baseType_1 = null;
          if (expType_1!=null) {
            _baseType_1=expType_1.getBaseType();
          }
          boolean _equals_1 = BasicDatatype.BOOLEAN.equals(_baseType_1);
          _and_1 = _equals_1;
        }
        if (_and_1) {
          return exp;
        }
        if ((((Boolean.valueOf(((FeatureCall) exp).isOperationCall()) == Boolean.valueOf(true)) && (expType_1 != null)) && 
          BasicDatatype.BOOLEAN.equals(expType_1.getBaseType()))) {
          ((FeatureCall) exp).getArguments().add(0, this.createArgument(lhs));
          this.typeCastHandler.typeCaseArgs(((FeatureCall) exp).getArguments(), lhsType);
          return exp;
        }
        return this.createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS, exp);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, NumericalExpressionImpl.class)) {
        _matched=true;
        Expression expression_1 = this.numericalExpConverter.convert(exp);
        return this.createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS, expression_1);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, ArrayExpressionImpl.class)) {
        _matched=true;
        EList<Expression> _elements = ((ArrayExpression) exp).getElements();
        return this.createInExpression(lhs, lhsType, ((EList<Expression>) _elements));
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, RangeExpressionImpl.class)) {
        _matched=true;
        return this.convertToLogicalExpression(lhs, lhsType, ((RangeExpression) exp));
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, NumericalUnaryExpressionImpl.class)) {
        _matched=true;
        return this.createLogicalRelationExpression(lhs, lhsType, RelationalOperator.EQUALS, 
          ((NumericalUnaryExpression) exp));
      }
    }
    return exp;
  }

  public LogicalRelationExpression createLogicalRelationExpression(final VariableDeclaration lhs, final Type lhsType, final RelationalOperator operator, final Expression right) {
    if ((((lhsType != null) && BasicDatatype.STRING.equals(lhsType.getBaseType())) && 
      (!(RelationalOperator.EQUALS.toString().equals(operator.toString()) || 
        RelationalOperator.NOT_EQUALS.toString().equals(operator.toString()))))) {
      return null;
    }
    ElementReferenceExpression classErd = ModelFactory.eINSTANCE.createElementReferenceExpression();
    classErd.setReference(lhs);
    LogicalRelationExpression logicalExpression = ModelFactory.eINSTANCE.createLogicalRelationExpression();
    logicalExpression.setLeftOperand(classErd);
    logicalExpression.setOperator(operator);
    logicalExpression.setRightOperand(this.typeCastHandler.typeCast(right, lhsType));
    return logicalExpression;
  }

  public Expression convertToLogicalExpression(final VariableDeclaration lhs, final Type lhsType, final RangeExpression exp) {
    final LogicalAndExpression logicalAndExpression = ModelFactory.eINSTANCE.createLogicalAndExpression();
    RelationalOperator _xifexpression = null;
    boolean _equals = ((RangeExpression) exp).getLeftBracket().equals("]");
    if (_equals) {
      _xifexpression = RelationalOperator.GREATER;
    } else {
      _xifexpression = RelationalOperator.GREATER_EQUAL;
    }
    RelationalOperator leftOperator = _xifexpression;
    Expression leftExpression = this.typeCastHandler.typeCast(exp.getLeftExpression(), lhsType);
    logicalAndExpression.setLeftOperand(this.createLogicalRelationExpression(lhs, lhsType, leftOperator, leftExpression));
    RelationalOperator _xifexpression_1 = null;
    boolean _equals_1 = exp.getRightBracket().equals("]");
    if (_equals_1) {
      _xifexpression_1 = RelationalOperator.SMALLER_EQUAL;
    } else {
      _xifexpression_1 = RelationalOperator.SMALLER;
    }
    RelationalOperator rightOperator = _xifexpression_1;
    Expression rightExpression = this.typeCastHandler.typeCast(exp.getRightExpression(), lhsType);
    logicalAndExpression.setRightOperand(this.createLogicalRelationExpression(lhs, lhsType, rightOperator, rightExpression));
    return logicalAndExpression;
  }

  public FeatureCall createInExpression(final VariableDeclaration lhs, final Type lhsType, final EList<Expression> expressions) {
    FeatureCall featureCall = ModelFactory.eINSTANCE.createFeatureCall();
    ElementReferenceExpression erd = ModelFactory.eINSTANCE.createElementReferenceExpression();
    erd.setReference(this.inBuiltLibrary.getClass("HelperFunctions", lhs));
    featureCall.setOwner(erd);
    featureCall.setOperationCall(true);
    ElementReferenceExpression erdExp = ModelFactory.eINSTANCE.createElementReferenceExpression();
    erdExp.setReference(lhs);
    Argument argument = ModelFactory.eINSTANCE.createArgument();
    argument.setValue(erdExp);
    featureCall.getArguments().add(argument);
    featureCall.setFeature(this.inBuiltLibrary.getFunction("HelperFunctions.in", lhs));
    for (int idx = 0; (idx < ((Object[])Conversions.unwrapArray(expressions, Object.class)).length); idx++) {
      {
        argument = ModelFactory.eINSTANCE.createArgument();
        argument.setValue(this.typeCastHandler.typeCast(expressions.get(idx), lhsType));
        featureCall.getArguments().add(argument);
      }
    }
    return featureCall;
  }

  public BoolLiteral createBoolLiteral(final Boolean value) {
    BoolLiteral boolLiteral = ModelFactory.eINSTANCE.createBoolLiteral();
    boolLiteral.setValue((value).booleanValue());
    return boolLiteral;
  }

  public Argument createArgument(final VariableDeclaration lhs) {
    ElementReferenceExpression lhsErd = ModelFactory.eINSTANCE.createElementReferenceExpression();
    Argument arg = ModelFactory.eINSTANCE.createArgument();
    lhsErd.setReference(lhs);
    arg.setValue(lhsErd);
    return arg;
  }
}
