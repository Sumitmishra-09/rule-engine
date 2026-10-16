package com.act21.rule.engine.dsl.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;

public class RuleEngineImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> temp = new ArrayList<>();
		temp.add(new ImportNormalizer(QualifiedName.create("HelperFunctions"), true, ignoreCase));
		temp.add(new ImportNormalizer(QualifiedName.create("RequestData"), true, ignoreCase));
		temp.add(new ImportNormalizer(QualifiedName.create(FunctionRegistry.MODEL_CLASS), true, ignoreCase));
		return temp;
	}
}
