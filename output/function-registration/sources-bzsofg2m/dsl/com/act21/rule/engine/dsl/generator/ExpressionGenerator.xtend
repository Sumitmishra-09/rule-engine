package com.act21.rule.engine.dsl.generator

import com.act21.rule.engine.dsl.datatype.BasicDatatype
import com.act21.rule.engine.dsl.datatype.TypeSystem
import com.act21.rule.engine.dsl.expression.conventions.NamingConventions
import com.act21.rule.engine.dsl.expression.converter.AssignExpressionConverter
import com.act21.rule.engine.dsl.expression.converter.DecideExpressionConverter
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry.Definition
import com.act21.rule.engine.dsl.expression.functions.RegisteredFunctionTypes
import java.util.List
import com.act21.rule.engine.dsl.model.AllLiteral
import com.act21.rule.engine.dsl.model.Argument
import com.act21.rule.engine.dsl.model.Assign
import com.act21.rule.engine.dsl.model.BoolLiteral
import com.act21.rule.engine.dsl.model.DateLiteral
import com.act21.rule.engine.dsl.model.Decide
import com.act21.rule.engine.dsl.model.DecimalLiteral
import com.act21.rule.engine.dsl.model.ElementReferenceExpression
import com.act21.rule.engine.dsl.model.FeatureCall
import com.act21.rule.engine.dsl.model.FunctionDeclaration
import com.act21.rule.engine.dsl.model.IntLiteral
import com.act21.rule.engine.dsl.model.Literal
import com.act21.rule.engine.dsl.model.LiteralExpression
import com.act21.rule.engine.dsl.model.LogicalAndExpression
import com.act21.rule.engine.dsl.model.LogicalOrExpression
import com.act21.rule.engine.dsl.model.LogicalRelationExpression
import com.act21.rule.engine.dsl.model.Model
import com.act21.rule.engine.dsl.model.NamedElement
import com.act21.rule.engine.dsl.model.NullLiteral
import com.act21.rule.engine.dsl.model.NumericUnaryOperator
import com.act21.rule.engine.dsl.model.NumericalExpression
import com.act21.rule.engine.dsl.model.NumericalOperator
import com.act21.rule.engine.dsl.model.ParenthesizedExpression
import com.act21.rule.engine.dsl.model.PassLiteral
import com.act21.rule.engine.dsl.model.RelationalOperator
import com.act21.rule.engine.dsl.model.RelationalUnaryOperator
import com.act21.rule.engine.dsl.model.StringLiteral
import com.act21.rule.engine.dsl.model.VariableDeclaration
import com.act21.rule.engine.dsl.model.impl.AllLiteralImpl
import com.act21.rule.engine.dsl.model.impl.ArgumentImpl
import com.act21.rule.engine.dsl.model.impl.BoolLiteralImpl
import com.act21.rule.engine.dsl.model.impl.ClassImpl
import com.act21.rule.engine.dsl.model.impl.DateLiteralImpl
import com.act21.rule.engine.dsl.model.impl.DecimalLiteralImpl
import com.act21.rule.engine.dsl.model.impl.ElementReferenceExpressionImpl
import com.act21.rule.engine.dsl.model.impl.FeatureCallImpl
import com.act21.rule.engine.dsl.model.impl.IntLiteralImpl
import com.act21.rule.engine.dsl.model.impl.LiteralExpressionImpl
import com.act21.rule.engine.dsl.model.impl.LogicalAndExpressionImpl
import com.act21.rule.engine.dsl.model.impl.LogicalOrExpressionImpl
import com.act21.rule.engine.dsl.model.impl.LogicalRelationExpressionImpl
import com.act21.rule.engine.dsl.model.impl.NullLiteralImpl
import com.act21.rule.engine.dsl.model.impl.NumericalExpressionImpl
import com.act21.rule.engine.dsl.model.impl.NumericalUnaryExpressionImpl
import com.act21.rule.engine.dsl.model.impl.ParenthesizedExpressionImpl
import com.act21.rule.engine.dsl.model.impl.PassLiteralImpl
import com.act21.rule.engine.dsl.model.impl.StringLiteralImpl
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import com.act21.rule.engine.dsl.model.impl.LogicalNotExpressionImpl
import com.act21.rule.engine.dsl.model.LogicalNotExpression


class ExpressionGenerator extends AbstractGenerator {
	
	static val IGNORE_CASE_SUPPORTED_FUNCTIONS = #{"contains", "in"};

	@Inject
	AssignExpressionConverter assignExpressionConverter
	@Inject
	DecideExpressionConverter decideExpressionConverter
	@Inject
	InBuiltLibrary inBuiltLibrary

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val statement = (resource.contents.get(0) as Model).statements.findFirst [
			(it instanceof Assign || it instanceof Decide)
		];
		var result = "";
		if (statement instanceof Decide) {
			result = compileDecide(statement, context);
		} else if (statement instanceof Assign) {
			result = compileAssign(statement, context);
		}
		(fsa as InMemoryFileSystemAccess).generateFile("_generated_code", result)
	}

	def String compileDecide(Decide decideExp, IGeneratorContext context) {
		var lhsType = TypeSystem.inferType(decideExp.name);
		var exp = decideExpressionConverter.convert(decideExp.name, lhsType, decideExp.condition);
		var prefix = (context as GeneratorContext).additionalData.get('ifConditionPrefix');
		prefix = prefix !== null ? prefix + " " : "";
		return prefix + compile(exp, context)
	}

	def String compileAssign(Assign assignExp, IGeneratorContext context) {
		if (assignExp === null || assignExp.name === null || assignExp.value === null) {
			return "";
		}
		var lhsType = TypeSystem.inferType(assignExp.name);
		var exp = assignExpressionConverter.convert(assignExp.name, lhsType, assignExp.value);
		var expType = TypeSystem.inferType(exp);
		if (exp instanceof FeatureCall && (exp as FeatureCall).isOperationCall && expType.equals(BasicDatatype.VOID)) {
			return compile(exp, context);
		}
		if (exp instanceof ElementReferenceExpression && (exp as ElementReferenceExpression).isOperationCall &&
			expType.equals(BasicDatatype.VOID)) {
			return compile(exp, context);
		}
		var setter = compileSetter(assignExp.name as VariableDeclaration);
		return setter + "(" + compile(exp, context) + ")";
	}

	def String compile(EObject exp, IGeneratorContext context) {
		if (exp === null) {
			return "";
		}
		switch (exp.class) {
			case LiteralExpressionImpl:
				return compileLiteralExpression(exp as LiteralExpression, context)
			case NumericalExpressionImpl:
				return compileNumericalExpression(exp as NumericalExpression, context)
			case NumericalUnaryExpressionImpl:
				return compileNumericalUnaryExpression(exp as NumericalUnaryExpressionImpl, context)
			case ParenthesizedExpressionImpl:
				return compileParenthesizedExpression(exp as ParenthesizedExpression, context)
			case LogicalRelationExpressionImpl:
				return compileLogicalRelationExpression(exp as LogicalRelationExpression, context)
			case ElementReferenceExpressionImpl:
				return compileElementReferenceExpression(exp as ElementReferenceExpression, context)
			case LogicalAndExpressionImpl:
				return compileLogicalAndExpression(exp as LogicalAndExpression, context)
			case LogicalOrExpressionImpl:
				return compileLogicalOrExpression(exp as LogicalOrExpression, context)
			case LogicalNotExpressionImpl:
				return compileLogicalNotExpression(exp as LogicalNotExpression, context)
			case ArgumentImpl:
				return compileArgument(exp as Argument, context)
			case FeatureCallImpl:
				return compileFeatureCall(exp as FeatureCall, context)
			default:
				return ""
		}
	}

	def compileNumericalUnaryExpression(NumericalUnaryExpressionImpl numericalUnaryExp, IGeneratorContext context) {
		var expVal = compile(numericalUnaryExp.operand, context);
		var operator = numericalUnaryExp.operator
		switch (operator) {
			case NumericUnaryOperator.NEGATIVE:
				return '''HelperFunctions.negate(«expVal»)'''
			default:
				return expVal
		}
	}

	def String compileLiteralExpression(LiteralExpression exp, IGeneratorContext context) {
		return compileLiteral(exp.value, context);
	}

	def String compileLiteral(Literal literal, IGeneratorContext context) {
		switch (literal.class) {
			case IntLiteralImpl: return compileInt(literal as IntLiteral, context)
			case StringLiteralImpl: return compileString(literal as StringLiteral, context)
			case DateLiteralImpl: return compileDate(literal as DateLiteral, context)
			case BoolLiteralImpl: return compileBool(literal as BoolLiteral, context)
			case DecimalLiteralImpl: return compiledecimal(literal as DecimalLiteral, context)
			case NullLiteralImpl: return compileNull(literal as NullLiteral, context)
			case PassLiteralImpl: return compilePassLiteral(literal as PassLiteral, context)
			case AllLiteralImpl: return compileAllLiteral(literal as AllLiteral, context)
			default: return ""
		}

	}

	def String compileParenthesizedExpression(ParenthesizedExpression exp, IGeneratorContext context) {
		return '''(«compile(exp.expression, context)»)''';
	}

	def String compileInt(IntLiteral intLiteral, IGeneratorContext context) {
		'''«intLiteral.value»L'''
	}

	def String compileDate(DateLiteral dateLiteral, IGeneratorContext context) {
		'''HelperFunctions.convertToDate("«dateLiteral.value»")'''
	}

	def String compileString(StringLiteral stringLiteral, IGeneratorContext context) {
		'''"«stringLiteral.value»"'''
	}

	def String compiledecimal(DecimalLiteral decimalLiteral, IGeneratorContext context) {
		'''new BigDecimal("«decimalLiteral.value»")'''
	}

	def String compileBool(BoolLiteral boolLiteral, IGeneratorContext context) {
		'''«boolLiteral.value»'''
	}

	def String compileNull(NullLiteral nullLiteral, IGeneratorContext context) {
		'''null'''
	}

	def String compilePassLiteral(PassLiteral passLiteral, IGeneratorContext context) {
		'''true'''
	}

	def String compileAllLiteral(AllLiteral allLiteral, IGeneratorContext context) {
		'''true'''
	}

	def String compileNumericalExpression(NumericalExpression exp, IGeneratorContext context) {
		val leftCode = compile(exp.leftOperand, context);
		val rightCode = compile(exp.rightOperand, context);
		switch (exp.operator) {
			case NumericalOperator.PLUS:
				return '''HelperFunctions.add(«leftCode», «rightCode»)'''
			case NumericalOperator.DIV:
				return '''HelperFunctions.divide(«leftCode», «rightCode»)'''
			case NumericalOperator.MINUS:
				return '''HelperFunctions.subtract(«leftCode», «rightCode»)'''
			case NumericalOperator.MOD:
				return '''HelperFunctions.modulo(«leftCode», «rightCode»)'''
			case NumericalOperator.MUL:
				return '''HelperFunctions.multiply(«leftCode», «rightCode»)'''
		}
	}

	def String compileLogicalOrExpression(LogicalOrExpression exp, IGeneratorContext context) {
		val leftCode = compile(exp.leftOperand, context);
		val rightCode = compile(exp.rightOperand, context);
		return '''«leftCode» || «rightCode»''';

	}

	def String compileLogicalNotExpression(LogicalNotExpression exp, IGeneratorContext context) {
		val operandCode = compile(exp.operand, context);
		return '''!«operandCode»''';

	}

	def String compileLogicalAndExpression(LogicalAndExpression exp, IGeneratorContext context) {
		val leftCode = compile(exp.leftOperand, context);
		val rightCode = compile(exp.rightOperand, context);
		return '''«leftCode» && «rightCode»''';

	}

	def String compileLogicalRelationExpression(LogicalRelationExpression exp, IGeneratorContext context) {
		val leftCode = compile(exp.leftOperand, context);
		val rightCode = compile(exp.rightOperand, context);
		val functionCall = '''(«leftCode», «rightCode»)'''
		val rightOperandType = TypeSystem.inferType(exp.rightOperand);

		val isIgnoreCase = rightOperandType !== null && BasicDatatype.STRING.equals(rightOperandType.baseType) &&
			(context as GeneratorContext).additionalData.get("isIgnoreCase") === true;

		switch (exp.operator) {
			case RelationalOperator.GREATER:
				return '''HelperFunctions.greater«functionCall»'''
			case RelationalOperator.GREATER_EQUAL:
				return '''HelperFunctions.greaterEqual«functionCall»'''
			case RelationalOperator.SMALLER:
				return '''HelperFunctions.smaller«functionCall»'''
			case RelationalOperator.SMALLER_EQUAL:
				return '''HelperFunctions.smallerEqual«functionCall»'''
			case RelationalOperator.EQUALS:
				return isIgnoreCase
					? '''HelperFunctions.equalsIgnoreCase«functionCall»''' : '''HelperFunctions.equals«functionCall»'''
			case RelationalOperator.NOT_EQUALS:
				return isIgnoreCase
					? '''!HelperFunctions.equalsIgnoreCase«functionCall»''' : '''HelperFunctions.notEquals«functionCall»'''
			case RelationalOperator.UPTO:
				return '''HelperFunctions.smaller«functionCall»'''
		}
		return "";

	}

	def compileElementReferenceExpression(ElementReferenceExpression elem, IGeneratorContext context) {
		val registered = inBuiltLibrary.getRegisteredFunction(elem.reference);
		if (registered !== null) {
			return compileRegisteredFunction(registered, elem.arguments, context);
		}
		var result = '';
		if (elem.reference instanceof ClassImpl) {
			return elem.reference.name;
		}
		if (elem.reference instanceof FunctionDeclaration) {
			val isIgnoreCase = IGNORE_CASE_SUPPORTED_FUNCTIONS.contains(elem.reference.name) &&
				(context as GeneratorContext).additionalData.get("isIgnoreCase") === true;
			result += ((elem.reference.eContainer as ClassImpl).name + '.' +
				'''«elem.reference.name»«isIgnoreCase?"IgnoreCase":""»''');
		} else if (elem.reference instanceof VariableDeclaration) {
			result += (NamingConventions.toCanonicalName((elem.reference.eContainer as ClassImpl).name) + '.' +
				compileGetter(elem.reference as VariableDeclaration, context))
		}
		if (elem.isOperationCall === true) {
			result += '(';
			for (var idx = 0; idx < elem.arguments.size(); idx++) {
				if (idx > 0) {
					result += ','
				}
				result += compile(elem.arguments.get(idx), context);
			}
			result += ')';
		}
		return result;
	}

	def compileFeatureCall(FeatureCall expression, IGeneratorContext context) {
		val registered = inBuiltLibrary.getRegisteredFunction(expression.feature);
		if (registered !== null) {
			return compileRegisteredFunction(registered, expression.arguments, context);
		}
		var result = "";
		if (expression.feature instanceof VariableDeclaration) {
			result += NamingConventions.toCanonicalName(compile(expression.owner, context));
			result += '.';
			result += compileGetter(expression.feature as VariableDeclaration, context);
		} else {
			result += compile(expression.owner, context);
			result += '.';
			result += expression.feature.name;
		}
		if (expression.isOperationCall === true) {
			result += '('
			for (var idx = 0; idx < expression.arguments.length; idx++) {
				if (idx > 0) {
					result += ',';
				}
				result += compile(expression.arguments.get(idx), context);
			}
			result += ')'
		}
		return result;
	}

	def String compileRegisteredFunction(Definition function, List<Argument> arguments, IGeneratorContext context) {
		RegisteredFunctionTypes.validate(function, arguments);
		val values = arguments.map[compile(it, context)].join(',');
		return '((' + function.returnType + ') registeredFunctions.invoke("' + function.name +
			'", new Object[]{' + values + '}))';
	}

	def compileArgument(Argument arg, IGeneratorContext context) {
		return compile(arg.value, context);
	}

	def compileGetter(VariableDeclaration variable, IGeneratorContext context) {
		var result = new StringBuilder;
		result.append(NamingConventions.suggestGetterName(variable.name.toCharArray));
		result.append('()');
		return '''«result.toString»''';

	}

	def compileSetter(NamedElement namedElement) {
		var result = new StringBuilder;
		if (namedElement.eContainer instanceof ClassImpl) {
			result.append(NamingConventions.toCanonicalName((namedElement.eContainer as ClassImpl).name));
			result.append('.');
			result.append(NamingConventions.suggestSetterName(namedElement.name.toCharArray));
		}
		return '''«result.toString»''';
	}

	def compileRelationUnaryOperatorCondition(RelationalUnaryOperator operator) {
		switch (operator) {
			case RelationalUnaryOperator.GREATER:
				return '>0'
			case RelationalUnaryOperator.GREATER_EQUAL:
				return '>=0'
			case RelationalUnaryOperator.SMALLER:
				return '<0'
			case RelationalUnaryOperator.UPTO:
				return '<0'
			case RelationalUnaryOperator.SMALLER_EQUAL:
				return '<=0'
			case RelationalUnaryOperator.EQUALS:
				return '==true'
			case RelationalUnaryOperator.NOT_EQUALS:
				return '==false'
		}
	}

}
