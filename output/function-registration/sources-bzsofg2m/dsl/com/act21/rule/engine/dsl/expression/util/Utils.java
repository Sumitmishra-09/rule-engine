package com.act21.rule.engine.dsl.expression.util;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;

import com.act21.rule.engine.dsl.datatype.BasicDatatype;
import com.act21.rule.engine.dsl.model.BoolLiteral;
import com.act21.rule.engine.dsl.model.DecimalLiteral;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.IntLiteral;
import com.act21.rule.engine.dsl.model.Literal;
import com.act21.rule.engine.dsl.model.LiteralExpression;
import com.act21.rule.engine.dsl.model.LogicalAndExpression;
import com.act21.rule.engine.dsl.model.LogicalOrExpression;
import com.act21.rule.engine.dsl.model.ModelFactory;
import com.act21.rule.engine.dsl.model.NullLiteral;
import com.act21.rule.engine.dsl.model.StringLiteral;
import com.act21.rule.engine.dsl.model.TypeReference;
import com.act21.rule.engine.dsl.validation.ExpressionLoadOptions;

public class Utils {

	public static Object getLiteralValue(Literal literal) {
		if (literal instanceof IntLiteral) {
			return ((IntLiteral) literal).getValue();
		}
		if (literal instanceof StringLiteral) {
			return ((StringLiteral) literal).getValue();
		}
		if (literal instanceof DecimalLiteral) {
			return ((DecimalLiteral) literal).getValue();
		}
		if (literal instanceof BoolLiteral) {
			return ((BoolLiteral) literal).isValue();
		}
		if (literal instanceof NullLiteral) {
			return null;
		}
		return null;
	}

	public static boolean isCompatible(Type lhsType, Type rhsType) {
		if (lhsType == null || rhsType == null) {
			return false;
		}
		if (lhsType.equals(rhsType)) {
			return true;
		}
		return false;
	}

	public static Predicate<EObject> isParentLogicalExpression() {
		return ctx -> !Objects.isNull(EcoreUtil2.getContainerOfType(ctx, LogicalAndExpression.class))
				|| !Objects.isNull(EcoreUtil2.getContainerOfType(ctx, LogicalOrExpression.class));
	}

	public static LiteralExpression convertERDtoLiteralExpression(ElementReferenceExpression erd) {
		var literalExp = ModelFactory.eINSTANCE.createLiteralExpression();
		var stringLiteral = ModelFactory.eINSTANCE.createStringLiteral();
		stringLiteral.setValue(erd.getUnresolvedText());
		literalExp.setValue(stringLiteral);
		return literalExp;
	}

	public static boolean isCollection(TypeReference type) {
		if (type.getIdentifier().equals("java.util.List") || type.getIdentifier().equals("java.util.Map")) {
			return true;
		}
		return false;
	}

	public static String getUserFirendlyTypeName(String lhsType) {

		if (BasicDatatype.INT.equals(lhsType) || BasicDatatype.LONG.equals(lhsType)
				|| BasicDatatype.DECIMAL.equals(lhsType)) {
			return "Number";
		}
		if (BasicDatatype.STRING.equals(lhsType) || BasicDatatype.BOOLEAN.equals(lhsType)
				|| BasicDatatype.DATE.equals(lhsType)) {
			return lhsType.substring(lhsType.lastIndexOf(".") + 1, lhsType.length());
		}

		return "";
	}

	public static Set<String> getRestrictedText(Resource res) {
		if (res instanceof XtextResource) {
			Map<?, ?> opts = ((XtextResource) res).getResourceSet().getLoadOptions();
			Object v = opts.get(ExpressionLoadOptions.RESTRICTED_CHARS);
			if (v instanceof Set<?>)
				return (Set<String>) v;
		}
		return Collections.emptySet();
	}
}
