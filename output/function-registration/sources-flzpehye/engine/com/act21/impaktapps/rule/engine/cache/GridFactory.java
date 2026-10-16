package com.act21.impaktapps.rule.engine.cache;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.act21.impaktapps.rule.engine.api.Rule;
import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.compiler.Compiler;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GridFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(GridFactory.class.getName());
	private final FunctionRegistry functions;

	public GridFactory() {
		this(FunctionRegistry.empty());
	}

	/** One registry and one compiled-rule cache per application/factory. */
	public GridFactory(FunctionRegistry functions) {
		this.functions = Objects.requireNonNull(functions, "functions");
	}

	private LoadingCache<CacheIdentifier, Rule> ruleCache = CacheBuilder.newBuilder()
			.build(new CacheLoader<CacheIdentifier, Rule>() {

				@Override
				public Rule load(CacheIdentifier key) throws Exception {

					RuleCreationRequest ruleCreationRequest = key.ruleSessionRequestBuilder.apply(key.gridIdentifier);
					try {
						return Compiler.getRule(ruleCreationRequest, functions);
					} catch (Exception e) {
						LOGGER.error("Error while loading rule", e);
						throw e;
					}
				}

			});

	private static class CacheIdentifier {

		public GridIdentifier gridIdentifier;
		public Function<GridIdentifier, RuleCreationRequest> ruleSessionRequestBuilder;

		public CacheIdentifier(GridIdentifier gridIdentifier,
				Function<GridIdentifier, RuleCreationRequest> ruleSessionRequestBuilder) {
			this.gridIdentifier = gridIdentifier;
			this.ruleSessionRequestBuilder = ruleSessionRequestBuilder;
		}

		@Override
		public int hashCode() {
			return Objects.hash(gridIdentifier);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CacheIdentifier other = (CacheIdentifier) obj;
			return Objects.equals(gridIdentifier, other.gridIdentifier);
		}

	}

	public Rule get(GridIdentifier gridIdentifier,
			Function<GridIdentifier, RuleCreationRequest> ruleSessionRequestBuilder) throws ExecutionException {
		return ruleCache.get(new CacheIdentifier(gridIdentifier, ruleSessionRequestBuilder));
	}

}
