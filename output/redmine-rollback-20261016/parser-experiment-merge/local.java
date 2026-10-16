package com.act21.rule.engine.dsl.expression.runtime;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.act21.rule.engine.dsl.ExpressionStandaloneSetup;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary;
import com.act21.rule.engine.dsl.expression.util.Type;
import com.act21.rule.engine.dsl.generator.ExpressionGenerator;
import com.act21.rule.engine.dsl.generator.GeneratorContext;
import com.act21.rule.engine.dsl.validation.ExpressionLoadOptions;
import com.google.inject.Injector;

public class ExpressionParser {

	private static String OUTPUT_FILE_PATH = "DEFAULT_OUTPUT_generated_code";
	private Injector injector;
	private RequestDataResourceBuilder requestDataResourceBuiler;
	private XtextResource exprResource;
	private XtextResourceSet resourceSet;
	private ExpressionGenerator generator;
	private IResourceValidator validator;
	private ISerializer serializer;
	private InBuiltLibrary builtInLibrary;

	public ExpressionParser(Map<String, VariableSchema> schema, Set<String> restrictedChars) throws IOException {
		this(schema, restrictedChars, FunctionRegistry.empty());
	}

	public ExpressionParser(Map<String, VariableSchema> schema, Set<String> restrictedChars,
			FunctionRegistry functions) throws IOException {
		synchronized (ExpressionParser.class) {
			injector = new ExpressionStandaloneSetup().createInjectorAndDoEMFRegistration();
			this.initiate(schema, restrictedChars, functions);
		}
	}

	private void initiate(Map<String, VariableSchema> schema, Set<String> restrictedChars,
			FunctionRegistry functions) throws IOException {
		injector = new ExpressionStandaloneSetup().createInjectorAndDoEMFRegistration();
		resourceSet = injector.getInstance(XtextResourceSet.class);
		generator = injector.getInstance(ExpressionGenerator.class);
		validator = injector.getInstance(IResourceValidator.class);
		serializer = injector.getInstance(ISerializer.class);
		builtInLibrary = injector.getInstance(InBuiltLibrary.class);
		exprResource = (XtextResource) resourceSet
				.createResource(URI.createFileURI("expression" + UUID.randomUUID() + ".exp"));
		// Load RequestData class
		requestDataResourceBuiler = new RequestDataResourceBuilder(serializer, resourceSet);
		requestDataResourceBuiler.initialize(schema);
		builtInLibrary.initialize(resourceSet, functions);
		resourceSet.addLoadOption(ExpressionLoadOptions.RESTRICTED_CHARS, restrictedChars);
	}

	public static void main(String[] args) throws IOException {
		Map<String, VariableSchema> input = new HashMap<String, VariableSchema>();
		// input.put("a", new VariableSchema("java.lang.Long", null, false, null));
		input.put("d", new VariableSchema(new Type("java.util.List", Arrays.asList(new Type("java.lang.Long", null))),
				null, null));
		input.put("c", new VariableSchema(new Type("java.lang.String", null), null, null));
		input.put("d", new VariableSchema(new Type("java.lang.Long", null), null, null));
		input.put("b", new VariableSchema(new Type("java.math.BigDecimal", null), null, null));
		Set<String> rcs = new HashSet<String>();
		rcs.add(".");

		ExpressionParser parser = new ExpressionParser(input, rcs);
		// String b = "\"15.00& - 19.99&\"";
		// System.out.println(String.format(b ));
		parser.parse("if c : !in(d,\"efgh\",\"agaga\")&&contains(c,\"qw\")");
		System.out.println(parser.validate());
		System.out.println(parser.generateCode(null));
	}

	public void parse(String expression) {
		exprResource.unload();
		try {
			exprResource.load(new ByteArrayInputStream(expression.getBytes()), null);
			EcoreUtil.resolveAll(exprResource);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String generateCode(Map<String, Object> params) {
		GeneratorContext context = new GeneratorContext();
		if (params != null) {
			context.getAdditionalData().putAll(params);
		}
		InMemoryFileSystemAccess fileSyatemAccess = new InMemoryFileSystemAccess();
		generator.doGenerate(exprResource, fileSyatemAccess, context);
		return (String) fileSyatemAccess.getAllFiles().get(OUTPUT_FILE_PATH);
	}

	public List<Issue> validate() {
		return validator.validate(exprResource, CheckMode.ALL, CancelIndicator.NullImpl);
	}

}
