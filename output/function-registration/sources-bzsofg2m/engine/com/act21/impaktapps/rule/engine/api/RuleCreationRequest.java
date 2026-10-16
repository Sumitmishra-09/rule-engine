package com.act21.impaktapps.rule.engine.api;

import java.nio.file.Path;
import java.util.Set;

import com.act21.impaktapps.rule.engine.commons.Constants;
import com.act21.impaktapps.rule.engine.table.StatefulExpressionParser;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;

public class RuleCreationRequest {

	private String name;
	private Long version;
	private RuleStream ruleStream;
	private int rulesPerFile;
	private boolean ignoreCase;
	private DecisionMatchType decisionMatchType;
	private Path sourceCodeDirectory;
	private String modelClassName;
	private boolean doValidate;
	private Schema schema;
	private StatefulExpressionParser expressionParser;
	private final Set<String> restrictedChars;

	private RuleCreationRequest(String name, Long version, RuleStream ruleStream, int rulesPerFile, boolean ignoreCase,
			DecisionMatchType decisionMatchType, Path sourceCodeDirectory, String modelClassName, boolean doValidate,
			Schema schema, StatefulExpressionParser expressionParser, Set<String> restrictedChars) {
		this.name = name;
		this.ruleStream = ruleStream;
		this.version = version;
		this.rulesPerFile = rulesPerFile;
		this.ignoreCase = ignoreCase;
		this.decisionMatchType = decisionMatchType;
		this.sourceCodeDirectory = sourceCodeDirectory;
		this.modelClassName = modelClassName;
		this.doValidate = doValidate;
		this.schema = schema;
		this.expressionParser = expressionParser;
		this.restrictedChars = Set.copyOf(restrictedChars);
	}

	public static RuleCreateRequestBuilder getRuleRequestBuilder() {
		return new RuleCreateRequestBuilder();
	}

	public static class RuleCreateRequestBuilder {

		private String name;
		private RuleStream ruleStream;
		private int rulesPerFile = 300;
		private boolean ignoreCase = false;
		private DecisionMatchType decisionMatchType = DecisionMatchType.MATCH_AND_EXIT;
		private Path sourceCodeDirectory;
		private String modelClassName;
		private Long version;
		private boolean doValidate = true;
		private Schema schema;
		private Set<String> restrictedChars = new java.util.HashSet<>(Constants.RESTRICTED_CHARS);

		public RuleCreateRequestBuilder withDoValidate(boolean doValidate) {
			this.doValidate = doValidate;
			return this;
		}

		public RuleCreateRequestBuilder withName(String name) {

			this.name = name;
			return this;
		}

		public RuleCreateRequestBuilder withRuleStream(RuleStream ruleStream) {
			this.ruleStream = ruleStream;
			return this;
		}

		public RuleCreateRequestBuilder withSchema(Schema schema) {
			this.schema = schema;
			return this;
		}

		public RuleCreateRequestBuilder withRulesPerFile(int rulesPerFile) {
			this.rulesPerFile = rulesPerFile;
			return this;
		}

		public RuleCreateRequestBuilder withIgnoreCase(boolean ignoreCase) {
			this.ignoreCase = ignoreCase;
			return this;
		}

		public RuleCreateRequestBuilder withDecisionMatchType(DecisionMatchType matchType) {
			this.decisionMatchType = matchType;
			return this;
		}

		public RuleCreateRequestBuilder withSourceCodeDirectory(Path sourceCodeDirectory) {
			this.sourceCodeDirectory = sourceCodeDirectory;
			return this;
		}

		public RuleCreateRequestBuilder withModelClassName(String modelClassName) {
			this.modelClassName = modelClassName;
			return this;
		}

		public RuleCreateRequestBuilder withVersion(Long version) {
			this.version = version;
			return this;
		}

		public RuleCreateRequestBuilder withRestrictedChars(Set<String> restrictedChars) {
			this.restrictedChars.addAll(restrictedChars);
			return this;
		}

		public RuleCreationRequest build() {
			validateInputs();
			return new RuleCreationRequest(name, version == null ? 1 : version, ruleStream, rulesPerFile, ignoreCase,
					decisionMatchType, sourceCodeDirectory, modelClassName, doValidate, schema, null, restrictedChars);

		}

		private void validateInputs() {
			if (name == null || name.isBlank()) {
				throw new IllegalArgumentException("Rule name cannot be empty");
			}
			if (ruleStream == null) {
				throw new IllegalArgumentException("Rule data stream cannot be empty");
			}
			if (version == null) {
				throw new IllegalArgumentException("Rule version cannot be empty");
			}
		}

	}

	public String getName() {
		return name;
	}

	public RuleStream getRuleStream() {
		return ruleStream;
	}

	public int getRulesPerFile() {
		return rulesPerFile;
	}

	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	public Path getSourceCodeDirectory() {
		return sourceCodeDirectory;
	}

	public String getModelClassName() {
		return modelClassName;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public DecisionMatchType getDecisionMatchType() {
		return decisionMatchType;
	}

	public boolean isDoValidate() {
		return doValidate;
	}

	public Schema getSchema() {
		return schema;
	}

	/** The compiler supplies its factory's registry before any cell is validated. */
	public RuleCreationRequest forCompilation(FunctionRegistry functions) {
		StatefulExpressionParser parser = schema == null ? null
				: new StatefulExpressionParser(schema.getPropertySchemaMap(), restrictedChars, functions);
		return new RuleCreationRequest(name, version, ruleStream, rulesPerFile, ignoreCase, decisionMatchType,
				sourceCodeDirectory, modelClassName, doValidate, schema, parser, restrictedChars);
	}

	/** Preserve direct request/parser use with the built-in function set. */
	public synchronized StatefulExpressionParser getExpressionParser() {
		if (expressionParser == null && schema != null) {
			expressionParser = new StatefulExpressionParser(schema.getPropertySchemaMap(), restrictedChars);
		}
		return expressionParser;
	}

}
