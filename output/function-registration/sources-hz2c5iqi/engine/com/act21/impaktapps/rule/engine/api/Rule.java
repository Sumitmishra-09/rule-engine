package com.act21.impaktapps.rule.engine.api;

public interface Rule {

	public void execute(Object fact,RuleStatistics ruleStats);
}
