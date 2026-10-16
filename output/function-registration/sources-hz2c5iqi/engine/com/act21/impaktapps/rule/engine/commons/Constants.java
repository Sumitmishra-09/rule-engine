package com.act21.impaktapps.rule.engine.commons;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Constants {

	public static final String DECIDE_HEADER_COLOR = "FFFFFF00"; // Yellow
	public static final String ASSIGN_HEADER_COLOR = "FF00B0F0"; // Blue
	public static String RULE_ENGINE_DEFAULT_DATE_PATTERN = "dd/MM/yyyy";
	public static DateTimeFormatter RULE_ENGINE_DEFAULT_DATE_FORMAT;

	public static final List<String> META_DATA_COLUMNS = Arrays.asList("rule_grid_id", "rule_eff_start_date",
			"rule_eff_end_date", "rule_active_status");
	public static final List<String> PASS_CONDITIONS = Arrays.asList("", "ALL", "PASS");
	public static final List<String> RULE_STATUS_POSSIBLE_VALUES = Arrays.asList("y", "n", "Y", "N", "\"Y\"", "\"N\"",
			"\"y\"", "\"n\"");

	public static final List<String> NUMBER_TYPE = Arrays.asList("java.lang.Integer", "java.lang.Long",
			"java.lang.Double", "java.lang.Float", "java.math.BigDecimal", "java.math.BigInteger");
	public static final Set<String> RESTRICTED_CHARS = new HashSet<String>(Arrays.asList("|"));

	static {
		RULE_ENGINE_DEFAULT_DATE_FORMAT = DateTimeFormatter.ofPattern(RULE_ENGINE_DEFAULT_DATE_PATTERN, Locale.ENGLISH);
	}

}
