package com.act21.impaktapps.rule.engine.migrator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.service.RuleService;
import com.act21.impaktapps.rule.engine.table.DecisionTable;
import com.act21.impaktapps.rule.engine.table.DecisionTableParser;
import com.act21.impaktapps.rule.engine.table.DtCell;
import com.act21.impaktapps.rule.engine.validation.ValidationMessage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Migrator {


	private MigratorService migratorService = new MigratorService();

	private ObjectMapper mapper = new ObjectMapper();

	public InputStream migrateGrid(RuleCreationRequest request, InputStream inputStream, List<String> stringHeaders)
			throws Exception {
		RuleService rs = new RuleService();
		DecisionTableParser parser = new DecisionTableParser();
		List<ValidationMessage> messages = new ArrayList<>();
		DecisionTable dt = parser.processExcel(request, inputStream, messages);
		if (!messages.isEmpty()) {
			return null;
		}
		Set<String> headers = new HashSet<>(stringHeaders);
		parseDecisionTable(dt, headers);

		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			rs.writeAsExcel(dt, out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw e;
		}

	}

	public Map<String, Object> migrateRule(Map<String, Object> rule, List<String> stringHeaders) {

		Set<String> headers = new HashSet<>(stringHeaders);
		for (Map.Entry<String, Object> ruleEntry : rule.entrySet()) {

			if (headers.contains(ruleEntry.getKey())) {
				rule.put(ruleEntry.getKey(), processRule(ruleEntry));
			}
		}

		return rule;
	}

	private Object processRule(Map.Entry<String, Object> ruleEntry) {
		try {
			List<Object> ruleList = mapper.convertValue(ruleEntry.getValue(), new TypeReference<List<Object>>() {
			});
			int i = 0;
			for (Object ruleObj : ruleList) {
				if (ruleObj.toString().startsWith("{")) {
					Map<String, String> decisionMap = (Map<String, String>) ruleObj;
					ruleList.set(i, modifyDecisionContent(decisionMap));
				} else if (ruleObj.toString().startsWith("[")) {
					List<String> outputList = (List<String>) ruleObj;
					ruleList.set(i, modifyOutputList(outputList));
				}
				i++;
			}
			return ruleList;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Map<String, String> modifyDecisionContent(Map<String, String> ruleMap) {
		String content = ruleMap.get("content");
		ruleMap.put("content", migratorService.parse(content));
		return ruleMap;
	}

	private List<String> modifyOutputList(List<String> ruleList) {
		for (int i = 0; i < ruleList.size(); i++) {
			String val = ruleList.get(i);
			ruleList.set(i, migratorService.parse(val));
		}

		return ruleList;
	}

	private void parseDecisionTable(DecisionTable dt, Set<String> stringHeaders) {
		iterateHorizontals(dt.getHorizontal(), stringHeaders);
		iterateVerticals(dt.getVertical(), stringHeaders);
		iterateAssignSpans(dt.getAssignSpanGroup(), stringHeaders);
	}

	private void iterateHorizontals(List<DtCell> horizontals, Set<String> stringHeaders) {
		if (horizontals.isEmpty()) {
			return;
		}
		for (DtCell cell : horizontals) {
			if (stringHeaders.contains(cell.getDecisionHeader().getContent())) {
				String value = cell.getContent().toString().trim();
				cell.setContent(migratorService.parse(value));
			}
			iterateHorizontals(cell.getChilds(), stringHeaders);
		}
	}

	private void iterateVerticals(List<DtCell> verticals, Set<String> stringHeaders) {
		if (verticals.isEmpty()) {
			return;
		}
		for (DtCell cell : verticals) {
			if (stringHeaders.contains(cell.getDecisionHeader().getContent())) {
				String value = cell.getContent().toString().trim();
				cell.setContent(migratorService.parse(value));
			}
			iterateVerticals(cell.getChilds(), stringHeaders);
		}

	}

	private void iterateAssignSpans(List<DtCell> assignSpans, Set<String> stringHeaders) {
		if (assignSpans.isEmpty()) {
			return;
		}

		for (DtCell cell : assignSpans) {
			for (DtCell c : cell.getChilds()) {
				iterateAssign(c.getChilds(), stringHeaders);
			}
		}
	}

	private void iterateAssign(List<DtCell> assignSpans, Set<String> stringHeaders) {
		if (assignSpans.isEmpty()) {
			return;
		}

		for (DtCell cell : assignSpans) {
			if (stringHeaders.contains(cell.getAssignHeader().getContent())) {
				String value = cell.getContent().toString().trim();
				cell.setContent(migratorService.parseLiteral(value));
			}
		}
	}

}
