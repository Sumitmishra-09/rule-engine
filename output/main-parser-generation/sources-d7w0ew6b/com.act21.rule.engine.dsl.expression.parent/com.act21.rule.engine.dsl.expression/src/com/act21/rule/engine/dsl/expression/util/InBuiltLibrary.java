package com.act21.rule.engine.dsl.expression.util;

import java.io.BufferedReader;
import org.eclipse.emf.common.util.URI;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.act21.rule.engine.dsl.model.Class;
import com.act21.rule.engine.dsl.model.FunctionDeclaration;
import com.act21.rule.engine.dsl.model.Model;
import com.act21.rule.engine.dsl.model.NamedElement;
import com.act21.rule.engine.dsl.model.Assign;
import com.act21.rule.engine.dsl.model.Decide;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.FeatureCall;
import org.eclipse.emf.ecore.EObject;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry.Definition;
import com.google.inject.Singleton;

@Singleton
public class InBuiltLibrary {

	private XtextResourceSet resourceSet;
	private final Map<String, FunctionDeclaration> functionMap = new HashMap<>();
	private final Map<String, Class> classMap = new HashMap<String, Class>();
	private FunctionRegistry functions = FunctionRegistry.empty();

	public void initialize(XtextResourceSet resourceSet) throws IOException {
		initialize(resourceSet, FunctionRegistry.empty());
	}

	public void initialize(XtextResourceSet resourceSet, FunctionRegistry functions) throws IOException {
		this.resourceSet = (XtextResourceSet) resourceSet;
		this.functions = java.util.Objects.requireNonNull(functions, "functions");
		resourceSet.getLoadOptions().put(InBuiltLibrary.class.getName(), this);
		functionMap.clear();
		classMap.clear();
		loadHelperFunction();
		loadRegisteredFunctions();
		loadClassMap();
		loadFunctionMap();
	}

	private void loadRegisteredFunctions() throws IOException {
		StringBuilder model = new StringBuilder("class " + FunctionRegistry.MODEL_CLASS + " {\n");
		for (Definition function : functions.getDefinitions()) {
			model.append("function ").append(function.getName()).append('(');
			for (int i = 0; i < function.getParameterTypes().size(); i++) {
				if (i > 0) model.append(',');
				if (function.isVarArgs() && i == function.getParameterTypes().size() - 1) model.append("... ");
				model.append(function.getParameterTypes().get(i)).append(" arg").append(i);
			}
			// Main's grammar stores a raw return name. Generic result metadata stays in the registry.
			String result = function.getReturnType();
			int genericStart = result.indexOf('<');
			model.append(") : ").append(genericStart < 0 ? result : result.substring(0, genericStart)).append(" {}\n");
		}
		model.append('}');
		XtextResource resource = (XtextResource) resourceSet.createResource(
				URI.createFileURI(FunctionRegistry.MODEL_CLASS + UUID.randomUUID() + ".exp"));
		resource.load(new ByteArrayInputStream(model.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8)), null);
	}

	public Definition getRegisteredFunction(NamedElement declaration) {
		if (declaration instanceof FunctionDeclaration && declaration.eContainer() instanceof Class
				&& FunctionRegistry.MODEL_CLASS.equals(((Class) declaration.eContainer()).getName())) {
			return forContext(declaration).functions.getDefinition(declaration.getName());
		}
		return null;
	}

	/** EMF validators can outlive an injector; declarations belong to the expression's resource set. */
	public InBuiltLibrary forContext(EObject context) {
		for (EObject node = context; node != null; node = node.eContainer()) {
			if (node.eResource() != null && node.eResource().getResourceSet() != null) {
				Object library = node.eResource().getResourceSet().getLoadOptions().get(InBuiltLibrary.class.getName());
				if (library instanceof InBuiltLibrary) return (InBuiltLibrary) library;
			}
			// Validation copies have no resource, but retain references to their schema/declarations.
			if (node instanceof Decide) return forContext(((Decide) node).getName());
			if (node instanceof Assign) return forContext(((Assign) node).getName());
			if (node instanceof ElementReferenceExpression
					&& ((ElementReferenceExpression) node).getReference() != null) {
				return forContext(((ElementReferenceExpression) node).getReference());
			}
			if (node instanceof FeatureCall && ((FeatureCall) node).getFeature() != null) {
				return forContext(((FeatureCall) node).getFeature());
			}
		}
		return this;
	}

	public Class getClass(String name, EObject context) {
		return forContext(context).getClass(name);
	}

	public FunctionDeclaration getFunction(String name, EObject context) {
		return forContext(context).getFunction(name);
	}

	private void loadClassMap() {
		this.resourceSet.getResources().forEach(resource -> {
			if (!resource.getContents().isEmpty()) {
				((Model) resource.getContents().get(0)).getStatements().forEach(statement -> {
					if (statement instanceof Class) {
						classMap.put(((Class) statement).getName(), (Class) statement);
					}
				});
			}
		});
	}

	private void loadFunctionMap() {
		Class helperFunctionClass = classMap.get("HelperFunctions");
		helperFunctionClass.getMembers().stream().forEach(member -> {
			if (member instanceof FunctionDeclaration) {
				functionMap.put("HelperFunctions." + member.getName(), (FunctionDeclaration) member);
			}
		});

	}

	private void loadHelperFunction() throws IOException {
		XtextResource helperFunctionResource = (XtextResource) resourceSet
				.createResource(URI.createFileURI("HelperFunctions" + UUID.randomUUID() + ".exp"));
		Map<Object, Object> loadOptions = new HashMap<>();
		loadOptions.put(XtextResource.OPTION_RESOLVE_ALL, true);
		String content = readHelperFunctionFile();
		helperFunctionResource.load(new ByteArrayInputStream(content.getBytes()), loadOptions);
	}

	private String readHelperFunctionFile() {
		try (InputStream inputStream = InBuiltLibrary.class.getResourceAsStream("HelperFunctionModel.txt");
				InputStreamReader streamReader = new InputStreamReader(inputStream);
				BufferedReader reader = new BufferedReader(streamReader)) {

			String line;
			StringBuilder content = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
			return content.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Class getClass(String name) {
		if (classMap.containsKey(name)) {
			return classMap.get(name);
		}
		return null;
	}

	public FunctionDeclaration getFunction(String name) {
		if (functionMap.containsKey(name)) {
			return functionMap.get(name);
		}
		return null;
	}

}
