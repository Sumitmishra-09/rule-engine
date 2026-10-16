package com.act21.rule.engine.dsl.generator;

import com.act21.rule.engine.dsl.datatype.BasicDatatype;
import com.act21.rule.engine.dsl.datatype.TypeSystem;
import com.act21.rule.engine.dsl.expression.conventions.NamingConventions;
import com.act21.rule.engine.dsl.expression.converter.AssignExpressionConverter;
import com.act21.rule.engine.dsl.expression.converter.DecideExpressionConverter;
import com.act21.rule.engine.dsl.expression.functions.FunctionCallBindings;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.act21.rule.engine.dsl.expression.functions.RegisteredFunctionTypes;
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary;
import com.act21.rule.engine.dsl.expression.util.Type;
import com.act21.rule.engine.dsl.model.AllLiteral;
import com.act21.rule.engine.dsl.model.Argument;
import com.act21.rule.engine.dsl.model.Assign;
import com.act21.rule.engine.dsl.model.BoolLiteral;
import com.act21.rule.engine.dsl.model.DateLiteral;
import com.act21.rule.engine.dsl.model.Decide;
import com.act21.rule.engine.dsl.model.DecimalLiteral;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.Expression;
import com.act21.rule.engine.dsl.model.FeatureCall;
import com.act21.rule.engine.dsl.model.FunctionDeclaration;
import com.act21.rule.engine.dsl.model.IntLiteral;
import com.act21.rule.engine.dsl.model.Literal;
import com.act21.rule.engine.dsl.model.LiteralExpression;
import com.act21.rule.engine.dsl.model.LogicalAndExpression;
import com.act21.rule.engine.dsl.model.LogicalNotExpression;
import com.act21.rule.engine.dsl.model.LogicalOrExpression;
import com.act21.rule.engine.dsl.model.LogicalRelationExpression;
import com.act21.rule.engine.dsl.model.Model;
import com.act21.rule.engine.dsl.model.ModelFactory;
import com.act21.rule.engine.dsl.model.NamedElement;
import com.act21.rule.engine.dsl.model.NullLiteral;
import com.act21.rule.engine.dsl.model.NumericUnaryOperator;
import com.act21.rule.engine.dsl.model.NumericalExpression;
import com.act21.rule.engine.dsl.model.NumericalOperator;
import com.act21.rule.engine.dsl.model.ParenthesizedExpression;
import com.act21.rule.engine.dsl.model.PassLiteral;
import com.act21.rule.engine.dsl.model.RelationalOperator;
import com.act21.rule.engine.dsl.model.RelationalUnaryOperator;
import com.act21.rule.engine.dsl.model.Statement;
import com.act21.rule.engine.dsl.model.StringLiteral;
import com.act21.rule.engine.dsl.model.VariableDeclaration;
import com.act21.rule.engine.dsl.model.impl.AllLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.ArgumentImpl;
import com.act21.rule.engine.dsl.model.impl.BoolLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.ClassImpl;
import com.act21.rule.engine.dsl.model.impl.DateLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.DecimalLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.FeatureCallImpl;
import com.act21.rule.engine.dsl.model.impl.IntLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.LiteralExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalAndExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalNotExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalOrExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.LogicalRelationExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NullLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.NumericalUnaryExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.ParenthesizedExpressionImpl;
import com.act21.rule.engine.dsl.model.impl.PassLiteralImpl;
import com.act21.rule.engine.dsl.model.impl.StringLiteralImpl;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ExpressionGenerator extends AbstractGenerator {
  private static final Set<String> IGNORE_CASE_SUPPORTED_FUNCTIONS = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("contains", "in"));

  @Inject
  private AssignExpressionConverter assignExpressionConverter;

  @Inject
  private DecideExpressionConverter decideExpressionConverter;

  @Inject
  private InBuiltLibrary inBuiltLibrary;

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    EObject _get = resource.getContents().get(0);
    final Function1<Statement, Boolean> _function = (Statement it) -> {
      return Boolean.valueOf(((it instanceof Assign) || (it instanceof Decide)));
    };
    final Statement statement = IterableExtensions.<Statement>findFirst(((Model) _get).getStatements(), _function);
    String result = "";
    if ((statement instanceof Decide)) {
      result = this.compileDecide(((Decide)statement), context);
    } else {
      if ((statement instanceof Assign)) {
        result = this.compileAssign(((Assign)statement), context);
      }
    }
    ((InMemoryFileSystemAccess) fsa).generateFile("_generated_code", result);
  }

  public String compileDecide(final Decide decideExp, final IGeneratorContext context) {
    Type lhsType = TypeSystem.inferType(decideExp.getName());
    Expression exp = this.decideExpressionConverter.convert(decideExp.getName(), lhsType, decideExp.getCondition());
    Object prefix = ((GeneratorContext) context).getAdditionalData().get("ifConditionPrefix");
    String _xifexpression = null;
    if ((prefix != null)) {
      _xifexpression = (prefix + " ");
    } else {
      _xifexpression = "";
    }
    prefix = _xifexpression;
    String _compile = this.compile(exp, context);
    return (prefix + _compile);
  }

  public String compileAssign(final Assign assignExp, final IGeneratorContext context) {
    if ((((assignExp == null) || (assignExp.getName() == null)) || (assignExp.getValue() == null))) {
      return "";
    }
    Type lhsType = TypeSystem.inferType(assignExp.getName());
    Expression exp = this.assignExpressionConverter.convert(assignExp.getName(), lhsType, assignExp.getValue());
    Type expType = TypeSystem.inferType(exp);
    if (((expType != null) && BasicDatatype.LIST.equals(expType.getBaseType()))) {
      boolean _equals = expType.equals(lhsType);
      boolean _not = (!_equals);
      if (_not) {
        String _name = assignExp.getName().getName();
        String _plus = ("List result type does not match output " + _name);
        throw new IllegalArgumentException(_plus);
      }
      final ElementReferenceExpression currentValue = ModelFactory.eINSTANCE.createElementReferenceExpression();
      currentValue.setReference(assignExp.getName());
      String _compileSetter = this.compileSetter(assignExp.getName());
      String _plus_1 = (_compileSetter + "(HelperFunctions.appendList(");
      String _compile = this.compile(currentValue, context);
      String _plus_2 = (_plus_1 + _compile);
      String _plus_3 = (_plus_2 + ",");
      String _compile_1 = this.compile(exp, context);
      String _plus_4 = (_plus_3 + _compile_1);
      return (_plus_4 + "))");
    }
    if ((((exp instanceof FeatureCall) && ((FeatureCall) exp).isOperationCall()) && expType.equals(BasicDatatype.VOID))) {
      return this.compile(exp, context);
    }
    if ((((exp instanceof ElementReferenceExpression) && ((ElementReferenceExpression) exp).isOperationCall()) && 
      expType.equals(BasicDatatype.VOID))) {
      return this.compile(exp, context);
    }
    VariableDeclaration _name_1 = assignExp.getName();
    String setter = this.compileSetter(((VariableDeclaration) _name_1));
    String _compile_2 = this.compile(exp, context);
    String _plus_5 = ((setter + "(") + _compile_2);
    return (_plus_5 + ")");
  }

  public String compile(final EObject exp, final IGeneratorContext context) {
    if ((exp == null)) {
      return "";
    }
    Class<? extends EObject> _class = exp.getClass();
    boolean _matched = false;
    if (Objects.equal(_class, LiteralExpressionImpl.class)) {
      _matched=true;
      return this.compileLiteralExpression(((LiteralExpression) exp), context);
    }
    if (!_matched) {
      if (Objects.equal(_class, NumericalExpressionImpl.class)) {
        _matched=true;
        return this.compileNumericalExpression(((NumericalExpression) exp), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, NumericalUnaryExpressionImpl.class)) {
        _matched=true;
        return this.compileNumericalUnaryExpression(((NumericalUnaryExpressionImpl) exp), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, ParenthesizedExpressionImpl.class)) {
        _matched=true;
        return this.compileParenthesizedExpression(((ParenthesizedExpression) exp), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, LogicalRelationExpressionImpl.class)) {
        _matched=true;
        return this.compileLogicalRelationExpression(((LogicalRelationExpression) exp), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, ElementReferenceExpressionImpl.class)) {
        _matched=true;
        return this.compileElementReferenceExpression(((ElementReferenceExpression) exp), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, LogicalAndExpressionImpl.class)) {
        _matched=true;
        return this.compileLogicalAndExpression(((LogicalAndExpression) exp), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, LogicalOrExpressionImpl.class)) {
        _matched=true;
        return this.compileLogicalOrExpression(((LogicalOrExpression) exp), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, LogicalNotExpressionImpl.class)) {
        _matched=true;
        return this.compileLogicalNotExpression(((LogicalNotExpression) exp), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, ArgumentImpl.class)) {
        _matched=true;
        return this.compileArgument(((Argument) exp), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, FeatureCallImpl.class)) {
        _matched=true;
        return this.compileFeatureCall(((FeatureCall) exp), context);
      }
    }
    return "";
  }

  public String compileNumericalUnaryExpression(final NumericalUnaryExpressionImpl numericalUnaryExp, final IGeneratorContext context) {
    String expVal = this.compile(numericalUnaryExp.getOperand(), context);
    NumericUnaryOperator operator = numericalUnaryExp.getOperator();
    if (operator != null) {
      switch (operator) {
        case NEGATIVE:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("HelperFunctions.negate(");
          _builder.append(expVal);
          _builder.append(")");
          return _builder.toString();
        default:
          return expVal;
      }
    } else {
      return expVal;
    }
  }

  public String compileLiteralExpression(final LiteralExpression exp, final IGeneratorContext context) {
    return this.compileLiteral(exp.getValue(), context);
  }

  public String compileLiteral(final Literal literal, final IGeneratorContext context) {
    Class<? extends Literal> _class = literal.getClass();
    boolean _matched = false;
    if (Objects.equal(_class, IntLiteralImpl.class)) {
      _matched=true;
      return this.compileInt(((IntLiteral) literal), context);
    }
    if (!_matched) {
      if (Objects.equal(_class, StringLiteralImpl.class)) {
        _matched=true;
        return this.compileString(((StringLiteral) literal), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, DateLiteralImpl.class)) {
        _matched=true;
        return this.compileDate(((DateLiteral) literal), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, BoolLiteralImpl.class)) {
        _matched=true;
        return this.compileBool(((BoolLiteral) literal), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, DecimalLiteralImpl.class)) {
        _matched=true;
        return this.compiledecimal(((DecimalLiteral) literal), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, NullLiteralImpl.class)) {
        _matched=true;
        return this.compileNull(((NullLiteral) literal), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, PassLiteralImpl.class)) {
        _matched=true;
        return this.compilePassLiteral(((PassLiteral) literal), context);
      }
    }
    if (!_matched) {
      if (Objects.equal(_class, AllLiteralImpl.class)) {
        _matched=true;
        return this.compileAllLiteral(((AllLiteral) literal), context);
      }
    }
    return "";
  }

  public String compileParenthesizedExpression(final ParenthesizedExpression exp, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    String _compile = this.compile(exp.getExpression(), context);
    _builder.append(_compile);
    _builder.append(")");
    return _builder.toString();
  }

  public String compileInt(final IntLiteral intLiteral, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    BigInteger _value = intLiteral.getValue();
    _builder.append(_value);
    _builder.append("L");
    return _builder.toString();
  }

  public String compileDate(final DateLiteral dateLiteral, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("HelperFunctions.convertToDate(\"");
    String _value = dateLiteral.getValue();
    _builder.append(_value);
    _builder.append("\")");
    return _builder.toString();
  }

  public String compileString(final StringLiteral stringLiteral, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    String _value = stringLiteral.getValue();
    _builder.append(_value);
    _builder.append("\"");
    return _builder.toString();
  }

  public String compiledecimal(final DecimalLiteral decimalLiteral, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new BigDecimal(\"");
    BigDecimal _value = decimalLiteral.getValue();
    _builder.append(_value);
    _builder.append("\")");
    return _builder.toString();
  }

  public String compileBool(final BoolLiteral boolLiteral, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    boolean _isValue = boolLiteral.isValue();
    _builder.append(_isValue);
    return _builder.toString();
  }

  public String compileNull(final NullLiteral nullLiteral, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("null");
    return _builder.toString();
  }

  public String compilePassLiteral(final PassLiteral passLiteral, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("true");
    return _builder.toString();
  }

  public String compileAllLiteral(final AllLiteral allLiteral, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("true");
    return _builder.toString();
  }

  public String compileNumericalExpression(final NumericalExpression exp, final IGeneratorContext context) {
    final String leftCode = this.compile(exp.getLeftOperand(), context);
    final String rightCode = this.compile(exp.getRightOperand(), context);
    NumericalOperator _operator = exp.getOperator();
    if (_operator != null) {
      switch (_operator) {
        case PLUS:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("HelperFunctions.add(");
          _builder.append(leftCode);
          _builder.append(", ");
          _builder.append(rightCode);
          _builder.append(")");
          return _builder.toString();
        case DIV:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("HelperFunctions.divide(");
          _builder_1.append(leftCode);
          _builder_1.append(", ");
          _builder_1.append(rightCode);
          _builder_1.append(")");
          return _builder_1.toString();
        case MINUS:
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("HelperFunctions.subtract(");
          _builder_2.append(leftCode);
          _builder_2.append(", ");
          _builder_2.append(rightCode);
          _builder_2.append(")");
          return _builder_2.toString();
        case MOD:
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("HelperFunctions.modulo(");
          _builder_3.append(leftCode);
          _builder_3.append(", ");
          _builder_3.append(rightCode);
          _builder_3.append(")");
          return _builder_3.toString();
        case MUL:
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("HelperFunctions.multiply(");
          _builder_4.append(leftCode);
          _builder_4.append(", ");
          _builder_4.append(rightCode);
          _builder_4.append(")");
          return _builder_4.toString();
        default:
          break;
      }
    }
    return null;
  }

  public String compileLogicalOrExpression(final LogicalOrExpression exp, final IGeneratorContext context) {
    final String leftCode = this.compile(exp.getLeftOperand(), context);
    final String rightCode = this.compile(exp.getRightOperand(), context);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(leftCode);
    _builder.append(" || ");
    _builder.append(rightCode);
    return _builder.toString();
  }

  public String compileLogicalNotExpression(final LogicalNotExpression exp, final IGeneratorContext context) {
    final String operandCode = this.compile(exp.getOperand(), context);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("!");
    _builder.append(operandCode);
    return _builder.toString();
  }

  public String compileLogicalAndExpression(final LogicalAndExpression exp, final IGeneratorContext context) {
    final String leftCode = this.compile(exp.getLeftOperand(), context);
    final String rightCode = this.compile(exp.getRightOperand(), context);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(leftCode);
    _builder.append(" && ");
    _builder.append(rightCode);
    return _builder.toString();
  }

  public String compileLogicalRelationExpression(final LogicalRelationExpression exp, final IGeneratorContext context) {
    final String leftCode = this.compile(exp.getLeftOperand(), context);
    final String rightCode = this.compile(exp.getRightOperand(), context);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.append(leftCode);
    _builder.append(", ");
    _builder.append(rightCode);
    _builder.append(")");
    final String functionCall = _builder.toString();
    final Type rightOperandType = TypeSystem.inferType(exp.getRightOperand());
    final boolean isIgnoreCase = (((rightOperandType != null) && BasicDatatype.STRING.equals(rightOperandType.getBaseType())) && 
      (((GeneratorContext) context).getAdditionalData().get("isIgnoreCase") == Boolean.valueOf(true)));
    RelationalOperator _operator = exp.getOperator();
    if (_operator != null) {
      switch (_operator) {
        case GREATER:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("HelperFunctions.greater");
          _builder_1.append(functionCall);
          return _builder_1.toString();
        case GREATER_EQUAL:
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("HelperFunctions.greaterEqual");
          _builder_2.append(functionCall);
          return _builder_2.toString();
        case SMALLER:
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("HelperFunctions.smaller");
          _builder_3.append(functionCall);
          return _builder_3.toString();
        case SMALLER_EQUAL:
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("HelperFunctions.smallerEqual");
          _builder_4.append(functionCall);
          return _builder_4.toString();
        case EQUALS:
          String _xifexpression = null;
          if (isIgnoreCase) {
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("HelperFunctions.equalsIgnoreCase");
            _builder_5.append(functionCall);
            _xifexpression = _builder_5.toString();
          } else {
            StringConcatenation _builder_6 = new StringConcatenation();
            _builder_6.append("HelperFunctions.equals");
            _builder_6.append(functionCall);
            _xifexpression = _builder_6.toString();
          }
          return _xifexpression;
        case NOT_EQUALS:
          String _xifexpression_1 = null;
          if (isIgnoreCase) {
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append("!HelperFunctions.equalsIgnoreCase");
            _builder_7.append(functionCall);
            _xifexpression_1 = _builder_7.toString();
          } else {
            StringConcatenation _builder_8 = new StringConcatenation();
            _builder_8.append("HelperFunctions.notEquals");
            _builder_8.append(functionCall);
            _xifexpression_1 = _builder_8.toString();
          }
          return _xifexpression_1;
        case UPTO:
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append("HelperFunctions.smaller");
          _builder_9.append(functionCall);
          return _builder_9.toString();
        default:
          break;
      }
    }
    return "";
  }

  public String compileElementReferenceExpression(final ElementReferenceExpression elem, final IGeneratorContext context) {
    final FunctionRegistry.Definition registered = this.inBuiltLibrary.getRegisteredFunction(elem.getReference());
    if ((registered != null)) {
      boolean _isOperationCall = elem.isOperationCall();
      boolean _not = (!_isOperationCall);
      if (_not) {
        String _name = registered.getName();
        String _plus = ("Use " + _name);
        String _plus_1 = (_plus + "(...) to call a function");
        throw new IllegalArgumentException(_plus_1);
      }
      return this.compileRegisteredFunction(registered, elem.getArguments(), context);
    }
    String result = "";
    NamedElement _reference = elem.getReference();
    if ((_reference instanceof ClassImpl)) {
      return elem.getReference().getName();
    }
    NamedElement _reference_1 = elem.getReference();
    if ((_reference_1 instanceof FunctionDeclaration)) {
      final boolean isIgnoreCase = (ExpressionGenerator.IGNORE_CASE_SUPPORTED_FUNCTIONS.contains(elem.getReference().getName()) && 
        (((GeneratorContext) context).getAdditionalData().get("isIgnoreCase") == Boolean.valueOf(true)));
      String _result = result;
      EObject _eContainer = elem.getReference().eContainer();
      String _name_1 = ((ClassImpl) _eContainer).getName();
      String _plus_2 = (_name_1 + ".");
      StringConcatenation _builder = new StringConcatenation();
      String _name_2 = elem.getReference().getName();
      _builder.append(_name_2);
      String _xifexpression = null;
      if (isIgnoreCase) {
        _xifexpression = "IgnoreCase";
      } else {
        _xifexpression = "";
      }
      _builder.append(_xifexpression);
      String _plus_3 = (_plus_2 + _builder);
      result = (_result + _plus_3);
    } else {
      NamedElement _reference_2 = elem.getReference();
      if ((_reference_2 instanceof VariableDeclaration)) {
        String _result_1 = result;
        EObject _eContainer_1 = elem.getReference().eContainer();
        String _canonicalName = NamingConventions.toCanonicalName(((ClassImpl) _eContainer_1).getName());
        String _plus_4 = (_canonicalName + ".");
        NamedElement _reference_3 = elem.getReference();
        String _compileGetter = this.compileGetter(((VariableDeclaration) _reference_3), context);
        String _plus_5 = (_plus_4 + _compileGetter);
        result = (_result_1 + _plus_5);
      }
    }
    boolean _isOperationCall_1 = elem.isOperationCall();
    boolean _tripleEquals = (Boolean.valueOf(_isOperationCall_1) == Boolean.valueOf(true));
    if (_tripleEquals) {
      String _result_2 = result;
      result = (_result_2 + "(");
      for (int idx = 0; (idx < elem.getArguments().size()); idx++) {
        {
          if ((idx > 0)) {
            String _result_3 = result;
            result = (_result_3 + ",");
          }
          String _result_4 = result;
          String _compile = this.compile(elem.getArguments().get(idx), context);
          result = (_result_4 + _compile);
        }
      }
      String _result_3 = result;
      result = (_result_3 + ")");
    }
    return result;
  }

  public String compileFeatureCall(final FeatureCall expression, final IGeneratorContext context) {
    final FunctionRegistry.Definition registered = this.inBuiltLibrary.getRegisteredFunction(expression.getFeature());
    if ((registered != null)) {
      boolean _isOperationCall = expression.isOperationCall();
      boolean _not = (!_isOperationCall);
      if (_not) {
        String _name = registered.getName();
        String _plus = ("Use " + _name);
        String _plus_1 = (_plus + "(...) to call a function");
        throw new IllegalArgumentException(_plus_1);
      }
      return this.compileRegisteredFunction(registered, expression.getArguments(), context);
    }
    String result = "";
    NamedElement _feature = expression.getFeature();
    if ((_feature instanceof VariableDeclaration)) {
      String _result = result;
      String _canonicalName = NamingConventions.toCanonicalName(this.compile(expression.getOwner(), context));
      result = (_result + _canonicalName);
      String _result_1 = result;
      result = (_result_1 + ".");
      String _result_2 = result;
      NamedElement _feature_1 = expression.getFeature();
      String _compileGetter = this.compileGetter(((VariableDeclaration) _feature_1), context);
      result = (_result_2 + _compileGetter);
    } else {
      String _result_3 = result;
      String _compile = this.compile(expression.getOwner(), context);
      result = (_result_3 + _compile);
      String _result_4 = result;
      result = (_result_4 + ".");
      String _result_5 = result;
      String _name_1 = expression.getFeature().getName();
      result = (_result_5 + _name_1);
    }
    boolean _isOperationCall_1 = expression.isOperationCall();
    boolean _tripleEquals = (Boolean.valueOf(_isOperationCall_1) == Boolean.valueOf(true));
    if (_tripleEquals) {
      String _result_6 = result;
      result = (_result_6 + "(");
      for (int idx = 0; (idx < ((Object[])Conversions.unwrapArray(expression.getArguments(), Object.class)).length); idx++) {
        {
          if ((idx > 0)) {
            String _result_7 = result;
            result = (_result_7 + ",");
          }
          String _result_8 = result;
          String _compile_1 = this.compile(expression.getArguments().get(idx), context);
          result = (_result_8 + _compile_1);
        }
      }
      String _result_7 = result;
      result = (_result_7 + ")");
    }
    return result;
  }

  public String compileRegisteredFunction(final FunctionRegistry.Definition function, final List<Argument> arguments, final IGeneratorContext context) {
    RegisteredFunctionTypes.validate(function, arguments);
    final Object bindings = ((GeneratorContext) context).getAdditionalData().get(FunctionCallBindings.CONTEXT_KEY);
    if ((bindings instanceof FunctionCallBindings)) {
      final Function1<Argument, String> _function = (Argument it) -> {
        return this.compile(it, context);
      };
      return ((FunctionCallBindings)bindings).compileCall(function, RegisteredFunctionTypes.argumentTypes(arguments), 
        IterableExtensions.<String>toList(ListExtensions.<Argument, String>map(arguments, _function)));
    }
    final Function1<Argument, String> _function_1 = (Argument it) -> {
      return this.compile(it, context);
    };
    final String values = IterableExtensions.join(ListExtensions.<Argument, String>map(arguments, _function_1), ",");
    String _returnType = function.getReturnType();
    String _plus = ("((" + _returnType);
    String _plus_1 = (_plus + ") registeredFunctions.invoke(\"");
    String _name = function.getName();
    String _plus_2 = (_plus_1 + _name);
    String _plus_3 = (_plus_2 + 
      "\", new Object[]{");
    String _plus_4 = (_plus_3 + values);
    return (_plus_4 + "}))");
  }

  public String compileArgument(final Argument arg, final IGeneratorContext context) {
    return this.compile(arg.getValue(), context);
  }

  public String compileGetter(final VariableDeclaration variable, final IGeneratorContext context) {
    StringBuilder result = new StringBuilder();
    result.append(NamingConventions.suggestGetterName(variable.getName().toCharArray()));
    result.append("()");
    StringConcatenation _builder = new StringConcatenation();
    String _string = result.toString();
    _builder.append(_string);
    return _builder.toString();
  }

  public String compileSetter(final NamedElement namedElement) {
    StringBuilder result = new StringBuilder();
    EObject _eContainer = namedElement.eContainer();
    if ((_eContainer instanceof ClassImpl)) {
      EObject _eContainer_1 = namedElement.eContainer();
      result.append(NamingConventions.toCanonicalName(((ClassImpl) _eContainer_1).getName()));
      result.append(".");
      result.append(NamingConventions.suggestSetterName(namedElement.getName().toCharArray()));
    }
    StringConcatenation _builder = new StringConcatenation();
    String _string = result.toString();
    _builder.append(_string);
    return _builder.toString();
  }

  public String compileRelationUnaryOperatorCondition(final RelationalUnaryOperator operator) {
    if (operator != null) {
      switch (operator) {
        case GREATER:
          return ">0";
        case GREATER_EQUAL:
          return ">=0";
        case SMALLER:
          return "<0";
        case UPTO:
          return "<0";
        case SMALLER_EQUAL:
          return "<=0";
        case EQUALS:
          return "==true";
        case NOT_EQUALS:
          return "==false";
        default:
          break;
      }
    }
    return null;
  }
}
