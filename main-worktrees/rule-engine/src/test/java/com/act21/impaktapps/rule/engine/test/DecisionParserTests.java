package com.act21.impaktapps.rule.engine.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.act21.impaktapps.rule.engine.api.DecisionMatchType;
import com.act21.impaktapps.rule.engine.api.PropertySchema;
import com.act21.impaktapps.rule.engine.api.Rule;
import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.api.RuleStatistics;
import com.act21.impaktapps.rule.engine.api.RuleStream;
import com.act21.impaktapps.rule.engine.api.Schema;
import com.act21.impaktapps.rule.engine.cache.GridFactory;
import com.act21.impaktapps.rule.engine.cache.GridIdentifier;
import com.act21.impaktapps.rule.engine.commons.Commons;
import com.act21.impaktapps.rule.engine.exception.ParsingException;
import com.act21.impaktapps.rule.engine.table.DecisionTable;
import com.act21.impaktapps.rule.engine.table.DecisionTableParser;
import com.act21.impaktapps.rule.engine.validation.ValidationMessage;
import com.act21.impaktapps.rule.engine.validation.ValidationService;

class DecisionParserTests {

	private static final String VARIABLE_CLASS = "com.act21.impaktapps.rule.engine.test.Variable";
	private static final String DT_CLASS = "com.act21.impaktapps.rule.engine.test.Dt";
	private static final String USGI_CLASS = "com.act21.impaktapps.rule.engine.test.usgi";

	@org.junit.jupiter.api.Test
	void testcase1() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("matchAll.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("matchAllGrid", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setInput1("1");
		rule.execute(variable, ruleStatistics);

		assertIterableEquals(Arrays.asList("1", "2", "4"), variable.getOutput1(),
				"Output list should match expected values.");
	}

	@org.junit.jupiter.api.Test
	void testcase55() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("checkNull.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("checkNullGrid", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setInput1(null);
		rule.execute(variable, ruleStatistics);

		assertEquals(null, variable.getOutput2(), "Output list should match expected values.");
	}

	@org.junit.jupiter.api.Test
	void testcase56() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("min_Long.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("min_Long", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setMinLongVal1(10L);
		variable.setMinLongVal2(12L);
		variable.setMinLongVal3(15L);
		rule.execute(variable, ruleStatistics);

		assertEquals(10L, variable.getMinLongVal(), "Output list should match expected values.");
	}

	@org.junit.jupiter.api.Test
	void testcase57() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("min_BigDecimal.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("min_BigDecimal", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setMinBigDecimalVal1(new BigDecimal("10.123"));
		variable.setMinBigDecimalVal2(new BigDecimal("12.111"));
		variable.setMinBigDecimalVal3(new BigDecimal("15.160"));
		rule.execute(variable, ruleStatistics);

		assertEquals(new BigDecimal("10.123"), variable.getMinBigDecimalVal(),
				"Output list should match expected values.");
	}

	@org.junit.jupiter.api.Test
	void testcase63() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("notOperatorTest.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("notOperatorTest", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setNotOperandInput("aa");
		rule.execute(variable, ruleStatistics);

		assertEquals("valid", variable.getNotOperandOutput(), "Output list should match expected values.");
	}

	@org.junit.jupiter.api.Test
	void testcase58() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("max_Long.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("max_Long", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setMaxLongVal1(10L);
		variable.setMaxLongVal2(12L);
		variable.setMaxLongVal3(15L);
		rule.execute(variable, ruleStatistics);

		assertEquals(15L, variable.getMaxLongVal(), "Output list should match expected values.");
	}

	@org.junit.jupiter.api.Test
	void testcase59() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("max_BigDecimal.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("max_BigDecimal", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setMaxBigDecimalVal1(new BigDecimal("10.123"));
		variable.setMaxBigDecimalVal2(new BigDecimal("12.111"));
		variable.setMaxBigDecimalVal3(new BigDecimal("15.160"));
		rule.execute(variable, ruleStatistics);

		assertEquals(new BigDecimal("15.160"), variable.getMaxBigDecimalVal(),
				"Output list should match expected values.");
	}

	@org.junit.jupiter.api.Test
	void testcase60() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("avg_BigDecimal.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("avg_BigDecimal", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setAvgBigDecimalVal1(new BigDecimal("10.123"));
		variable.setAvgBigDecimalVal2(new BigDecimal("12.111"));
		variable.setAvgBigDecimalVal3(new BigDecimal("15.160"));
		rule.execute(variable, ruleStatistics);

		assertEquals(new BigDecimal("12.46"), variable.getAvgBigDecimalVal(),
				"Output list should match expected values.");
	}

	@org.junit.jupiter.api.Test
	void testcase61() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("avg_Long.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("avg_Long", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setAvgLongVal1(10L);
		variable.setAvgLongVal2(12L);
		variable.setAvgLongVal3(15L);
		rule.execute(variable, ruleStatistics);

		assertEquals(new BigDecimal("12.33"), variable.getAvgLongVal(), "Output list should match expected values.");
	}

	@org.junit.jupiter.api.Test
	void testcase62() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		GridFactory factory = new GridFactory();
		Variable variable = new Variable();
		try {
			RuleStream ruleStream = getRuleStream("restrictedChars.xlsx");
			Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
			Rule rule = factory.get(new GridIdentifier("restrictedChars", 2L),
					grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_ALL, "matchAll", VARIABLE_CLASS,
							new Schema(propertySchemaMap, false), 300));

			variable.setRestrictedCharactersInput("A|B|C|D");
			rule.execute(variable, ruleStatistics);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			assertEquals(null, variable.getRestrictedCharactersOutput(), "Output list should match expected values.");
		}

	}

	@org.junit.jupiter.api.Test
	void testcase2() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("loanPointsPerKRule.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);

		Rule rule = factory.get(new GridIdentifier("loanPointsPerKRuleGrid", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT, "loanPointsPerKRule",
						VARIABLE_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setProduct("PL EXPAT");
		variable.setLoan_class("NEW");
		rule.execute(variable, ruleStatistics);

		assertEquals("60", variable.getLoan_points_per_1k(), "Loan points for 'NEW' should be 60");

		variable.setLoan_class("TOP UP");
		rule.execute(variable, ruleStatistics);

		assertEquals("40", variable.getLoan_points_per_1k(), "Loan points for 'TOP UP' should be 40");
	}

	// For template compare and validation data
	@org.junit.jupiter.api.Test
	void testcase3() throws Exception {

		RuleStream templateRuleStream = getRuleStream("Book1.xlsx");
		RuleStream gridRuleStream = getRuleStream("merged1.xlsx");

		List<ValidationMessage> messages = new ArrayList<>();

		DecisionTableParser parser = new DecisionTableParser();
		Field[] fields = Class.forName("com.act21.impaktapps.rule.engine.test.Dt").getDeclaredFields();
		Map<String, Type> propertyType = new HashMap<>();
		for (Field field : fields) {
			propertyType.put(field.getName(), field.getGenericType());
		}

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		ValidationService validationService = new ValidationService();
		propertySchemaMap.get("input2").setPossibleValues(Arrays.asList("1", "2", "33", "4"));
		RuleCreationRequest request = createRuleRequest(gridRuleStream, DecisionMatchType.MATCH_ALL, "merged1",
				DT_CLASS, new Schema(propertySchemaMap, true), 300);

		DecisionTable gridDt = parser.processExcel(request, gridRuleStream.getInputStream(), messages);
		boolean isValidGrid = messages.isEmpty();

		assertEquals("true", String.valueOf(isValidGrid), "Merged1 Grid is not valid, Please Check");

		RuleCreationRequest templateRequest = createRuleRequest(templateRuleStream, DecisionMatchType.MATCH_ALL,
				"Book1", DT_CLASS, new Schema(propertySchemaMap, true), 300);

		DecisionTable templateDt = parser.processExcel(templateRequest, templateRuleStream.getInputStream(), messages);

		messages = validationService.validateDecisionTableStructure(templateDt, gridDt);

		isValidGrid = messages.isEmpty();

		assertEquals("true", String.valueOf(isValidGrid), "Template mismatched, Please Check");

	}

	// For single AND operator eg. &&1 or 1&&
	@org.junit.jupiter.api.Test
	void testcase4() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Dt variable = new Dt();
		RuleStream ruleStream = getRuleStream("finalCalc.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		Rule rule = factory.get(new GridIdentifier("finalCalc", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_AND_EXIT, "finalCalc", DT_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setPayable_amount(new BigDecimal(500000));
		rule.execute(variable, ruleStatistics);

		assertEquals(new BigDecimal("0.10"), variable.getTempperc(),
				"Temp percentage for payable amount 500,000 should be 0.1");
	}

//	 For Ranged and Contains expression and other data type checks
	@org.junit.jupiter.api.Test
	void testcase5() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Dt variable = new Dt();
		RuleStream ruleStream = getRuleStream("merged1.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		Rule rule = factory.get(new GridIdentifier("merged1", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_UNTIL, "merged1", DT_CLASS, new Schema(propertySchemaMap, true), 300));

		variable.setRuleId("aaaaCbbbb");
		variable.setRuleId2("A");
		variable.setInput2("1");
		variable.setInput1(116L);
		rule.execute(variable, ruleStatistics);

		assertEquals("165", variable.getOutput1(), "Output1 should be 165");
		assertEquals("1", variable.getOutput2(), "Output2 should be 1");
	}

	// For Schema column ignore validation
	@org.junit.jupiter.api.Test
	void testcase6() throws Exception {
		RuleStream gridRuleStream = getRuleStream("merged1.xlsx");

		List<ValidationMessage> messages = new ArrayList<>();

		DecisionTableParser parser = new DecisionTableParser();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		propertySchemaMap.get("input2").setPossibleValues(Arrays.asList("1", "2", "3", "4"));
		RuleCreationRequest request = createRuleRequest(gridRuleStream, DecisionMatchType.MATCH_ALL, "merged1",
				DT_CLASS, new Schema(propertySchemaMap, false), 300);

		parser.processExcel(request, gridRuleStream.getInputStream(), messages);
		boolean isValidGrid = !messages.isEmpty();

		assertEquals("true", String.valueOf(isValidGrid), "DoValidateSchemaCol working correctly");

	}

	// for date range and date type
	@org.junit.jupiter.api.Test
	void testcase7() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Dt variable = new Dt();
		RuleStream ruleStream = getRuleStream("date_range.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		Rule rule = factory.get(new GridIdentifier("date_range", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_AND_EXIT, "date_range", DT_CLASS, new Schema(propertySchemaMap, false), 300));

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		variable.setDisb_date(simpleDateFormat.parse("20/04/2025"));
		rule.execute(variable, ruleStatistics);

		assertEquals("april", variable.getOutput1(), "Month should be april");
		variable.setDisb_date(simpleDateFormat.parse("15/03/2025"));
		rule.execute(variable, ruleStatistics);

		assertEquals("march", variable.getOutput1(), "Month should be march");
	}

	// For RuleStatistics

	@org.junit.jupiter.api.Test
	void testcase8() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Dt variable = new Dt();
		RuleStream ruleStream = getRuleStream("finalCalc.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		Rule rule = factory.get(new GridIdentifier("finalCalc", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_AND_EXIT, "finalCalc", DT_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setPayable_amount(new BigDecimal(500000));
		rule.execute(variable, ruleStatistics);

		assertEquals(2, ruleStatistics.getCurrentRowIndex(), "Second row is matched");
	}

	// for batch
	@org.junit.jupiter.api.Test
	void testcase9() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();
		Dt variable = new Dt();
		RuleStream ruleStream = getRuleStream("for_batch_20.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		Rule rule = factory.get(new GridIdentifier("for_batch_20", 2L), grid -> createRuleRequest(ruleStream,
				DecisionMatchType.MATCH_AND_EXIT, "for_batch_20", DT_CLASS, new Schema(propertySchemaMap, false), 20));

		variable.setCg6_segment("Applicable for all States GJ,DD,DN,MH,GA 7.5-20T");
		variable.setCg6_discount("70-85%");
		variable.setState_rank("State5");
		variable.setCg6_slab("5.01-10L");
		variable.setFinal_vertical_desc("Agency");
		rule.execute(variable, ruleStatistics);

		assertEquals(new BigDecimal("0.21"), variable.getSf_comm_perc(), "Second row is matched");
	}

	@org.junit.jupiter.api.Test
	void testcase10() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		usgi variable = new usgi();
		RuleStream ruleStream = getRuleStream("tw_agency_test2.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(USGI_CLASS);
		Rule rule = factory.get(new GridIdentifier("tw_agency_test2", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT, "tw_agency_test2", USGI_CLASS,
						new Schema(propertySchemaMap, false), 300));
		variable.setState_Group_Name("CG");
		variable.setEom_cluster("BIKE");
		variable.setMake("ROYAL ENFIELD");
		variable.setCubic_Capacity_Amp(new BigDecimal("250"));
		variable.setBusinessType("NEW VEHICLE");

		rule.execute(variable, ruleStatistics);

		assertEquals(new BigDecimal("40"), variable.getGrid_percentage(), "Second row is matched");
	}

	@org.junit.jupiter.api.Test
	void testcase11() throws Exception {

		RuleStream ruleStream = getRuleStream("assignTest.xlsx");

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		RuleCreationRequest request = createRuleRequest(ruleStream, DecisionMatchType.MATCH_ALL, "assignTest", DT_CLASS,
				new Schema(propertySchemaMap, false), 300);

		DecisionTableParser parser = new DecisionTableParser();
		List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
		DecisionTable gridDt = parser.processExcel(request, ruleStream.getInputStream(), messages);

		assertEquals("assignTest : There should be atleast 1 assign header present", messages.get(2).getDescription(),
				"No assign header");
		assertEquals("assignTest : There should be atleast 1 vertical header present", messages.get(3).getDescription(),
				"No vertical decision header");
	}

	@org.junit.jupiter.api.Test
	void testcase12() throws Exception {
		RuleStream ruleStream = getRuleStream("childMerge.xlsx");
		GridFactory factory = new GridFactory();

		Exception exception = assertThrows(Exception.class, () -> {
			Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(USGI_CLASS);
			Rule rule = factory.get(new GridIdentifier("childMerge", 2L),
					grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT, "childMerge", USGI_CLASS,
							new Schema(propertySchemaMap, false), 300));
		});

		List<ValidationMessage> messages = ((ParsingException) exception.getCause()).getValidationMessage();

		assertEquals("Cell B2:B3 cannot have larger span than parent cell", messages.get(0).getDescription(),
				"Got correct exception");

	}

	@org.junit.jupiter.api.Test
	void testcase13() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		usgi variable = new usgi();

		RuleStream ruleStream = getRuleStream("exception_master_health_missing_header.xlsx");
		GridFactory factory = new GridFactory();

		Exception exception = assertThrows(Exception.class, () -> {
			Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(USGI_CLASS);
			Rule rule = factory.get(new GridIdentifier("exception_master_health_missing_header", 2L),
					grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT,
							"exception_master_health_missing_header", USGI_CLASS, new Schema(propertySchemaMap, false),
							300));
		});

		List<ValidationMessage> messages = ((ParsingException) exception.getCause()).getValidationMessage();

		assertEquals("intermediary_Code213 does not exist in variable class", messages.get(0).getDescription(),
				"Got correct exception");

	}

	@org.junit.jupiter.api.Test
	void testcase14() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		RuleStream ruleStream = getRuleStream("finalCalc_conditional_assign.xlsx");
		GridFactory factory = new GridFactory();

		Exception exception = assertThrows(Exception.class, () -> {
			Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
			Rule rule = factory.get(new GridIdentifier("finalCalc_conditional_assign", 2L),
					grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT,
							"finalCalc_conditional_assign", DT_CLASS, new Schema(propertySchemaMap, false), 300));
		});

		List<ValidationMessage> messages = ((ParsingException) exception.getCause()).getValidationMessage();

		assertEquals("Error: Cannot convert { <=0.1 } to { Number } in output cell", messages.get(0).getDescription(),
				"Got correct exception");

	}

	@org.junit.jupiter.api.Test
	void testcase15() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		usgi variable = new usgi();

		RuleStream ruleStream = getRuleStream("dateCheck.xlsx");
		GridFactory factory = new GridFactory();

		Exception exception = assertThrows(Exception.class, () -> {
			Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(USGI_CLASS);
			Rule rule = factory.get(new GridIdentifier("dateCheck", 2L),
					grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT, "dateCheck", USGI_CLASS,
							new Schema(propertySchemaMap, false), 300));
		});

		List<ValidationMessage> messages = ((ParsingException) exception.getCause()).getValidationMessage();

		assertEquals("Cell type in excel should not be date", messages.get(0).getDescription(),
				"Got correct exception");

	}

	@org.junit.jupiter.api.Test
	void testcase16() throws Exception {

		RuleStream ruleStream = getRuleStream("merged1_duplicate_ids.xlsx");
		GridFactory factory = new GridFactory();

		Exception exception = assertThrows(Exception.class, () -> {
			Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
			Rule rule = factory.get(new GridIdentifier("merged1_duplicate_ids", 2L),
					grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT, "merged1_duplicate_ids",
							DT_CLASS, new Schema(propertySchemaMap, true), 300));

		});

		List<ValidationMessage> messages = ((ParsingException) exception.getCause()).getValidationMessage();

		assertEquals("rule_grid_id 1 already exist.", messages.get(0).getDescription(), "Got correct exception");

	}

	@org.junit.jupiter.api.Test
	void testcase17() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Dt variable = new Dt();
		RuleStream ruleStream = getRuleStream("merged1_with_expression.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		Rule rule = factory.get(new GridIdentifier("merged1_with_expression", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT, "merged1_with_expression",
						DT_CLASS, new Schema(propertySchemaMap, true), 300));

		variable.setInput2("1");
		variable.setRuleId("CCC");
		variable.setRuleId2("A");

		variable.setInput1(116L);

		rule.execute(variable, ruleStatistics);

		assertEquals(new BigDecimal("117.33"), variable.getVol_payout_perc(), "Output2 should be 1");
		assertEquals(new BigDecimal("282.55"), variable.getPayable_amount(), "Output2 should be 1");
	}

	@org.junit.jupiter.api.Test
	void testcase18() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		usgi variable = new usgi();
		RuleStream ruleStream = getRuleStream("exception_master_broker.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(USGI_CLASS);
		Rule rule = factory.get(new GridIdentifier("exception_master_broker", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT, "exception_master_broker",
						USGI_CLASS, new Schema(propertySchemaMap, false), 300));

		variable.setPolicy_Issue_Month_Year("MAR_2025");
		variable.setIntermediary_Code("201830210459");
		variable.setLine_Of_Business("FIRE");
		variable.setGwp(new BigDecimal("5000"));
		variable.setBusinessType("");
		rule.execute(variable, ruleStatistics);

		assertEquals("1", variable.getException_id(), "Output2 should be 1");
	}

	@org.junit.jupiter.api.Test
	void testcase19() throws Exception {

		RuleStream ruleStream = getRuleStream("merged1_wrong_horizontal.xlsx");
		GridFactory factory = new GridFactory();

		Exception exception = assertThrows(Exception.class, () -> {
			Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);

			Rule rule = factory.get(new GridIdentifier("merged1_wrong_horizontal", 2L),
					grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT, "merged1_wrong_horizontal",
							DT_CLASS, new Schema(propertySchemaMap, true), 300));
		});

		List<ValidationMessage> messages = ((ParsingException) exception.getCause()).getValidationMessage();

		assertEquals("merged1_wrong_horizontal : Horizontal input header size is not valid",
				messages.get(0).getDescription(), "Got correct exception");

	}

	@org.junit.jupiter.api.Test
	void testcase20() throws Exception {

		RuleStream ruleStream = getRuleStream("empty_test.xlsx");
		GridFactory factory = new GridFactory();

		Exception exception = assertThrows(Exception.class, () -> {
			Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(USGI_CLASS);

			Rule rule = factory.get(new GridIdentifier("empty_test", 2L),
					grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_AND_EXIT, "empty_test", USGI_CLASS,
							new Schema(propertySchemaMap, false), 300));
		});

		List<ValidationMessage> messages = ((ParsingException) exception.getCause()).getValidationMessage();

		assertEquals("empty_test : There should be atleast 1 vertical header present", messages.get(5).getDescription(),
				"Got correct exception");
	}

	@org.junit.jupiter.api.Test
	void testcase21() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Dt variable = new Dt();
		RuleStream ruleStream = getRuleStream("ulip_payout_slab.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
		Rule rule = factory.get(new GridIdentifier("ulip_payout_slab", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_UNTIL, "ulip_payout_slab", DT_CLASS,
						new Schema(propertySchemaMap, false), 300));

		variable.setSpecialChannelFlag(true);
		variable.setTotal_ulip_premium(new BigDecimal(1000008.0));

		rule.execute(variable, ruleStatistics);

		assertEquals(new BigDecimal("0.042345"), variable.getUlip_payout_slab(), "Output2 should be 1");
	}

	@org.junit.jupiter.api.Test
	void testcase22() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		usgi variable = new usgi();
		RuleStream ruleStream = getRuleStream("Performance_grid_v2.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(USGI_CLASS);
		Rule rule = factory.get(new GridIdentifier("Performance_grid_v2", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_UNTIL, "Performance_grid_v2", USGI_CLASS,
						new Schema(propertySchemaMap, false), 300));

		variable.setTotal_marks(new BigDecimal("45"));

		rule.execute(variable, ruleStatistics);

		assertEquals(">=40%-<75%", variable.getMarks_on_range(), "Output2 should be 1");
	}
	
	@org.junit.jupiter.api.Test
	void testcase23() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("diffDays_date.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("diffDays_date", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_UNTIL, "diffDays_date", VARIABLE_CLASS,
						new Schema(propertySchemaMap, false), 300));

		variable.setPayoutComponentId(Long.valueOf(312));

		rule.execute(variable, ruleStatistics);

		assertEquals("april", variable.getOutput2(), "Output2 should be april");
	}
	
	@org.junit.jupiter.api.Test
	void testcase24() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("diffDays_date.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("diffDays_date", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_UNTIL, "diffDays_date", VARIABLE_CLASS,
						new Schema(propertySchemaMap, false), 300));

		variable.setPayoutComponentId(Long.valueOf(50));

		rule.execute(variable, ruleStatistics);

		assertEquals("march", variable.getOutput2(), "Output2 should be march");
	}
	
	@org.junit.jupiter.api.Test
	void testcase25() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("diffDays_date2.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("diffDays_date2", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_UNTIL, "diffDays_date2", VARIABLE_CLASS,
						new Schema(propertySchemaMap, false), 300));
		
		variable.setDate1(new java.util.Date(2025, 11, 15));
		variable.setDate2(new java.util.Date(2025, 1, 15));

		variable.setPayoutComponentId(Long.valueOf(50));

		rule.execute(variable, ruleStatistics);

		assertEquals("march", variable.getOutput2(), "Output2 should be march");
	}
	
	@org.junit.jupiter.api.Test
	void testcase26() throws Exception {
		RuleStatistics ruleStatistics = new RuleStatistics();

		Variable variable = new Variable();
		RuleStream ruleStream = getRuleStream("diffDays_date2.xlsx");
		GridFactory factory = new GridFactory();

		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(VARIABLE_CLASS);
		Rule rule = factory.get(new GridIdentifier("diffDays_date2", 2L),
				grid -> createRuleRequest(ruleStream, DecisionMatchType.MATCH_UNTIL, "diffDays_date2", VARIABLE_CLASS,
						new Schema(propertySchemaMap, false), 300));
		
		variable.setDate1(new java.util.Date(2025, 11, 15));
		variable.setDate2(new java.util.Date(2025, 1, 15));

		variable.setPayoutComponentId(Long.valueOf(313));

		rule.execute(variable, ruleStatistics);

		assertEquals("april", variable.getOutput2(), "Output2 should be april");
	}
//	@org.junit.jupiter.api.Test
//	void testcase110() throws Exception {
//		RuleStatistics ruleStatistics = new RuleStatistics();
//		Dt variable = new Dt();
//		RuleStream ruleStream = getRuleStream("commission_grid_6_4_with_100k_rows.xlsx");
//		GridFactory factory = new GridFactory();
//		Map<String, PropertySchema> propertySchemaMap = Commons.getPropertySchemaMap(DT_CLASS);
//		Rule rule = factory.get(new GridIdentifier("commission_grid_6_4_with_100k_rows", 2L),
//				grid -> createRuleRequest(ruleStream,
//						DecisionMatchType.MATCH_AND_EXIT, "commission_grid_6_4_with_100k_rows", DT_CLASS,
//						new Schema(propertySchemaMap, false), 300));
//		variable.setCg6_segment("Applicable for all States GJ,DD,DN,MH,GA 7.5-20T");
//		variable.setCg6_discount("Up to 70%");
//		variable.setState_rank("State4");
//		variable.setCg6_slab("10.01-15L");
//		variable.setFinal_vertical_desc("Agency");
//		rule.execute(variable, ruleStatistics);
//		System.out.println(variable.getSf_comm_perc()); 
//		assertEquals(new BigDecimal("0.2"), variable.getSf_comm_perc(),
//				"Temp percentage for payable amount 500,000 should be 0.1");
//	}

	private RuleStream getRuleStream(String fileName) throws IOException {
		URL resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
		if (resource == null) {
			throw new FileNotFoundException("File not found: " + fileName);
		}

		FileInputStream fis = new FileInputStream(new File(resource.getFile()));

		return new RuleStream() {
			@Override
			public void close() throws IOException {
				fis.close();
			}

			@Override
			public InputStream getInputStream() {
				return fis;
			}
		};
	}

	private RuleCreationRequest createRuleRequest(RuleStream ruleStream, DecisionMatchType matchType, String fileName,
			String className, Schema schema, int rulesPerfile) {
		Path projectRoot = Paths.get("").toAbsolutePath();
		Path path = projectRoot.resolve("src-gen");

		return new RuleCreationRequest.RuleCreateRequestBuilder().withName(fileName).withVersion(2L)
				.withModelClassName(className).withRuleStream(ruleStream).withSourceCodeDirectory(path)
				.withDecisionMatchType(matchType).withSchema(schema).withRulesPerFile(rulesPerfile).withDoValidate(true)
				.build();
	}

}
