package com.act21.impaktapps.rule.engine.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.act21.impaktapps.rule.engine.api.PropertySchema;
import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.api.RuleStream;
import com.act21.impaktapps.rule.engine.api.Schema;
import com.act21.impaktapps.rule.engine.commons.Commons;
import com.act21.impaktapps.rule.engine.table.DecisionTable;
import com.act21.impaktapps.rule.engine.table.DecisionTableParser;
import com.act21.impaktapps.rule.engine.table.DtCell;
import com.act21.impaktapps.rule.engine.table.DtCellType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class RuleService {

	private static final TypeReference<List<DtCell>> CELL_INFO_TYPE_REF = new TypeReference<>() {
	};
	private static final TypeReference<List<List<String>>> STRING_LISTS_TYPE_REF = new TypeReference<>() {
	};

	public DecisionTable createDecisionTable(InputStream template, Iterator<Map<String, Object>> ruleIterator)
			throws Exception {
		DecisionTable decisionTable = createDecisionTable(template);
		int headerRowIndex = decisionTable.getHorizontalHeaders().size();
		int currentRowIndex = headerRowIndex + 1;

		List<String> headers = getTemplateHeaders(decisionTable);

		// Group assign headers by content for easier lookup
		Map<String, List<DtCell>> assignHeadersByContent = decisionTable.getAssignHeaders().stream()
				.collect(Collectors.groupingBy(h -> String.valueOf(h.getContent())));

		// Process each database row
		while (ruleIterator.hasNext()) {
			Map<String, Object> row = ruleIterator.next();

			// Merge data into template
			mergeRowIntoTemplate(decisionTable, headers, row, assignHeadersByContent, currentRowIndex, headerRowIndex);
//				// Update current row index for next iteration
			currentRowIndex += getVerticalDecisionRowSize(decisionTable);

		}
		return decisionTable;
	}

	public List<Map<String, Object>> getRules(InputStream gridInputStream) {
		DecisionTable decisionTable;
		try {
			decisionTable = createDecisionTable(gridInputStream);
			List<Map<String, Object>> dtRows = new ArrayList<>();
			int startRowIndex = 0;

			for (DtCell verticalCell : decisionTable.getVertical()) {
				int rowSpan = verticalCell.getRowEndIndex() - verticalCell.getRowStartIndex();
				Map<String, Object> dataRow = new HashMap<>();

				// Add the vertical cell data
				String headerContent = (String) verticalCell.getDecisionHeader().getContent();
				String content = (String) verticalCell.getContent();
				DtCell cell = new DtCell();
				cell.setRowspan(rowSpan + 1);
				cell.setContent(content);
				dataRow.put(headerContent, List.of(cell));

				// Add child cell data recursively
				populateDecisionData(dataRow, verticalCell.getChilds());

				// Build output data
				Map<String, List<List<String>>> outputData = buildOutputData(decisionTable.getAssignSpanGroup(),
						startRowIndex, startRowIndex + rowSpan + 1);

				dataRow.putAll(outputData);
				dtRows.add(dataRow);
				startRowIndex += rowSpan + 1;
			}
			return dtRows;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void writeAsExcel(DecisionTable decisionTable, OutputStream outputStream) throws IOException {
		ExcelWriter excelWriter = new ExcelWriter();
		excelWriter.write(decisionTable, outputStream);
	}

	private Map<String, List<List<String>>> buildOutputData(List<DtCell> assignSpanGroups, int startIndex,
			int endIndex) {
		return assignSpanGroups.stream()
				.map(spanGroup -> spanGroup.getChilds().subList(startIndex, endIndex).stream()
						.flatMap(spanCell -> spanCell.getChilds().stream())
						.collect(Collectors.groupingBy(cell -> (String) cell.getAssignHeader().getContent(),
								Collectors.mapping(cell -> (String) cell.getContent(), Collectors.toList()))))
				.flatMap(spanMap -> spanMap.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey,
						entry -> new ArrayList<>(List.of(entry.getValue())), (existing, replacement) -> {
							existing.addAll(replacement);
							return existing;
						}));
	}

	/**
	 * Populates decision data from vertical cells recursively
	 */
	private void populateDecisionData(Map<String, Object> rowData, List<DtCell> verticalCells) {
		if (!verticalCells.isEmpty()) {
			String header = (String) verticalCells.get(0).getDecisionHeader().getContent();

			List<DtCell> cellInfos = verticalCells.stream()
					.peek(cell -> populateDecisionData(rowData, cell.getChilds())).map(cell -> {
						DtCell newCell = new DtCell();
						newCell.setRowspan(cell.getRowEndIndex() - cell.getRowStartIndex() + 1);
						newCell.setContent((String) cell.getContent());
						return newCell;
					}).collect(Collectors.toList());

			rowData.merge(header, cellInfos, (existingList, newList) -> {
				List<DtCell> mergedList = new ArrayList<>((List<DtCell>) existingList);
				mergedList.addAll((List<DtCell>) newList);
				return mergedList;
			});
		}
	}

	// Create DecisionTable
	private DecisionTable createDecisionTable(InputStream inputStream) throws Exception {
		RuleCreationRequest request = createRuleCreationRequest("Template", 2L, "class", inputStream,
				new Schema(new HashMap<String, PropertySchema>(), true), false);

		return new DecisionTableParser().processExcel(request, inputStream , new ArrayList<>());
	}

	private RuleCreationRequest createRuleCreationRequest(String name, Long version, String className,
			InputStream inputStream, Schema schema, boolean doValidate) {
		RuleStream ruleStream = new RuleStream() {
			@Override
			public void close() throws IOException {
				inputStream.close();
			}

			@Override
			public InputStream getInputStream() {
				return inputStream;
			}
		};
		return new RuleCreationRequest.RuleCreateRequestBuilder().withName(name).withVersion(version)
				.withModelClassName(className).withRuleStream(ruleStream).withSchema(schema).withDoValidate(doValidate)
				.build();
	}

	/**
	 * Handles first column with null value
	 */
	private DtCell handleFirstNullColumn(Map<String, Object> rowData, List<String> headers, String headerName,
			int endRowIndex) throws JsonProcessingException {
		// Find a non-null column to get reference rowspan

		Object reference = headers.stream().filter(header -> rowData.get(header) != null).map(val -> val).findFirst()
				.orElseThrow(() -> new RuntimeException("No Decision Cell Given"));
		// Get total rowspan from reference
		List<DtCell> cellRef = Commons.OBJECT_MAPPER.convertValue(reference, CELL_INFO_TYPE_REF);
		int totalRowSpan = cellRef.stream().mapToInt(DtCell::getRowspan).sum();
		DtCell cell = createDecisionCell(headerName, 0, endRowIndex, "", totalRowSpan, DtCellType.DECISION_V);
		return cell;
	}

	/**
	 * Creates a vertical header cell
	 */
	private DtCell createVerticalHeader(String headerName, int colIndex) {
		DtCell header = new DtCell();
		header.setContent(headerName);
		header.setDtCellType(DtCellType.DECISION_HEADER_V);
		header.setColStartIndex(colIndex);
		header.setColEndIndex(colIndex);
		return header;
	}

	/**
	 * Creates an empty cell based on previous cell
	 */
	private DtCell createEmptyCell(String headerName, DtCell previousCell) {
		// Calculate new column index
		int newColIndex = previousCell.getColStartIndex() + 1;

		// Create header
		DtCell header = createVerticalHeader(headerName, newColIndex);

		// Create cell
		DtCell cell = new DtCell();
		cell.setContent("");
		cell.setChilds(new ArrayList<>());
		cell.setDtCellType(DtCellType.DECISION_V);
		cell.setColStartIndex(newColIndex);
		cell.setColEndIndex(newColIndex);
		cell.setRowStartIndex(previousCell.getRowStartIndex());
		cell.setRowEndIndex(previousCell.getRowEndIndex());
		cell.setDecisionHeader(header);

		return cell;
	}

	/**
	 * Creates a decision cell
	 */
	private DtCell createDecisionCell(String headerName, int colIndex, int rowIndex, String value, int rowSpan,
			DtCellType dtCellType) {
		// Create header
		DtCell header = createVerticalHeader(headerName, colIndex);

		// Create cell
		DtCell cell = new DtCell();
		cell.setContent(value);
		cell.setChilds(new ArrayList<>());
		cell.setDtCellType(dtCellType);
		cell.setColStartIndex(colIndex);
		cell.setColEndIndex(colIndex);
		cell.setRowStartIndex(rowIndex);
		cell.setRowEndIndex(rowIndex + rowSpan - 1);
		cell.setDecisionHeader(header);

		return cell;
	}

	/**
	 * Attaches a child cell to appropriate parent
	 */
	private void attachToParent(Queue<DtCell> parentCells, DtCell childCell) {

		if (parentCells.isEmpty()) {
			return;
		}

		DtCell parent = parentCells.peek();
		if (childCell.getRowStartIndex() >= parent.getRowStartIndex()
				// don't remove
				&& childCell.getRowStartIndex() <= parent.getRowEndIndex()) {
			parent.getChilds().add(childCell);
		} else {
			// remove
			parentCells.remove();
			if (parentCells.isEmpty())
				return;
			DtCell newParent = parentCells.peek();
			newParent.getChilds().add(childCell);
		}
	}

	/**
	 * Creates an assign header cell
	 */
	private DtCell createAssignHeader(String content, int colStart, int colEnd, int rowIndex) {
		DtCell header = new DtCell();
		header.setContent(content);
		header.setChilds(new ArrayList<>());
		header.setColStartIndex(colStart);
		header.setColEndIndex(colEnd);
		header.setDtCellType(DtCellType.ASSIGN_HEADER);
		header.setRowStartIndex(rowIndex);
		header.setRowEndIndex(rowIndex);
		return header;
	}

	/**
	 * Creates an assign cell
	 */
	private DtCell createAssignCell(String content, int colStart, int colEnd, int rowIndex, DtCell header) {
		DtCell cell = new DtCell();
		cell.setContent(content);
		cell.setChilds(new ArrayList<DtCell>());
		cell.setDtCellType(DtCellType.ASSIGN);
		cell.setColStartIndex(colStart);
		cell.setColEndIndex(colEnd);
		cell.setRowStartIndex(rowIndex);
		cell.setRowEndIndex(rowIndex);
		cell.setAssignHeader(header);
		return cell;
	}

	/**
	 * Creates empty assign data
	 */
	private List<List<String>> createEmptyAssignData(int rowspan, List<DtCell> assignSpanGroups) {
		// Create empty rows using streams
		return IntStream.range(0, assignSpanGroups.size()).mapToObj(i -> Collections.nCopies(rowspan, ""))
				.map(ArrayList::new).collect(Collectors.toList());
	}

	/**
	 * Adjusts size of assign data list
	 */
	private void adjustAssignDataSize(List<List<String>> assignData, int requiredSize) {
		if (assignData.size() > requiredSize) {
			// Remove extra rows
			assignData.subList(requiredSize, assignData.size()).clear();
		} else if (assignData.size() < requiredSize && !assignData.isEmpty()) {
			// Add empty rows if needed
			int rowSize = assignData.get(0).size();

			// Create and add the missing rows
			IntStream.range(0, requiredSize - assignData.size())
					.mapToObj(i -> new ArrayList<>(Collections.nCopies(rowSize, ""))).forEach(assignData::add);
		}
	}

	/**
	 * Ensures span group has enough rows
	 */
	private void ensureSpanGroupRowExists(DtCell spanGroup, int rowPosition, int rowIndex) {
		// Add rows if needed
		if (spanGroup.getChilds().size() <= rowIndex) {
			DtCell assignCell = new DtCell();
			assignCell.setContent(DtCellType.ASSIGN_SPAN);
			assignCell.setRowStartIndex(rowPosition);
			assignCell.setRowEndIndex(rowPosition);
			assignCell.setColStartIndex(spanGroup.getColStartIndex());
			assignCell.setColEndIndex(spanGroup.getColEndIndex());
			assignCell.setChilds(new ArrayList<>());
			spanGroup.getChilds().add(assignCell);
		}
	}

	/**
	 * Merges data into template
	 */
	private void mergeRowIntoTemplate(DecisionTable decisionTable, List<String> headers, Map<String, Object> row,
			Map<String, List<DtCell>> assignHeadersByContent, int currentRowIndex, int headerRowIndex) {

		try {
			Queue<DtCell> previousColumnCells = new LinkedList<DtCell>();
			List<DtCell> assignSpanGroups = decisionTable.getAssignSpanGroup();
			int decisionHeaderSize = decisionTable.getVerticalHeaders().size();
			List<List<String>> assignData = new ArrayList<List<String>>();
			int columnIndex = 0;

			for (String headerName : headers) {
				Object cellValue = row.get(headerName);
				if (columnIndex < decisionHeaderSize) {
					writeVerticalDecisions(decisionTable, previousColumnCells, row, headers, headerName, cellValue,
							columnIndex, currentRowIndex);
				} else {
					if (cellValue == null) {
						int rowspan = getVerticalDecisionRowSize(decisionTable);
						assignData = createEmptyAssignData(rowspan, assignSpanGroups);
					} else {
						assignData = Commons.OBJECT_MAPPER.convertValue(cellValue, STRING_LISTS_TYPE_REF);
						adjustAssignDataSize(assignData, assignSpanGroups.size());
					}
					addToAssignSpanGroup(headerName, cellValue, assignHeadersByContent, assignSpanGroups,
							currentRowIndex, headerRowIndex, assignData);
				}
				columnIndex++;
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to merge into template: " + e.getMessage(), e);
		}
	}

	private int getVerticalDecisionRowSize(DecisionTable decisionTable) {
		int size = decisionTable.getVertical().size();
		DtCell vertical = decisionTable.getVertical().get(size - 1);
		int rowspan = vertical.getRowEndIndex() - vertical.getRowStartIndex() + 1;
		return rowspan;
	}

	/**
	 * Creates vertical cells structure from row data
	 */
	private void writeVerticalDecisions(DecisionTable decisionTable, Queue<DtCell> previousColumnCells,
			Map<String, Object> row, List<String> headers, String headerName, Object cellValue, int columnIndex,
			int currentRowIndex) throws JsonProcessingException {
		try {
			List<DtCell> currentColumnCells = new ArrayList<>();

			processDecisionColumn(headerName, cellValue, columnIndex, currentRowIndex, previousColumnCells, row,
					headers, currentColumnCells);

			// Add root cell to decision table (only for first column)
			if (columnIndex == 0) {
				decisionTable.getVertical().add(currentColumnCells.get(0));
			}

			previousColumnCells.clear();
			previousColumnCells.addAll(currentColumnCells);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error processing JSON data for column: " + headerName, e);
		}
	}

	private void processDecisionColumn(String headerName, Object cellValue, int columnIndex, int currentRowIndex,
			Queue<DtCell> previousColumnCells, Map<String, Object> row, List<String> headers,
			List<DtCell> currentColumnCells) throws JsonProcessingException {

		// Case 1: Null value in first column
		if (cellValue == null && previousColumnCells.isEmpty()) {
			currentColumnCells.add(handleFirstNullColumn(row, headers, headerName, currentRowIndex));
			return;
		}

		// Case 2: Null value in subsequent column
		if (cellValue == null && !previousColumnCells.isEmpty()) {
			while (!previousColumnCells.isEmpty()) {
				DtCell prevCell = previousColumnCells.remove();
				DtCell cell = createEmptyCell(headerName, prevCell);
				prevCell.getChilds().add(cell);
				currentColumnCells.add(cell);
			}
			return;
		}

		// Case 3: Cell has Value
		List<DtCell> cellInfos = Commons.OBJECT_MAPPER.convertValue(cellValue, CELL_INFO_TYPE_REF);
		int lastProcessedRow = currentRowIndex;

		for (DtCell cellInfo : cellInfos) {
			// Create cell
			DtCell cell = createDecisionCell(headerName, columnIndex, lastProcessedRow, (String) cellInfo.getContent(),
					cellInfo.getRowspan(), DtCellType.DECISION_V);
			currentColumnCells.add(cell);

			// Link to parent if we have previous columns
			if (!previousColumnCells.isEmpty()) {
				attachToParent(previousColumnCells, cell);
			}

			// Update row position for next cell
			lastProcessedRow = cell.getRowEndIndex() + 1;
		}
	}

	/**
	 * Adds cells to assign span group
	 */
	private void addToAssignSpanGroup(String headerName, Object cellValue,
			Map<String, List<DtCell>> assignHeadersByContent, List<DtCell> assignSpanGroups, int currentRowIndex,
			int headerRowIndex, List<List<String>> assignData) throws JsonProcessingException {

		List<DtCell> headerCells = assignHeadersByContent.getOrDefault(headerName, Collections.emptyList());

		// Process each assign group
		IntStream.range(0, assignData.size()).forEach(groupIndex -> {
			DtCell spanGroup = assignSpanGroups.get(groupIndex);
			List<String> values = assignData.get(groupIndex);
			DtCell headerCell = headerCells.get(groupIndex);

			// Process each value
			IntStream.range(0, values.size()).forEach(valueIndex -> {
				String value = values.get(valueIndex);

				// Create assign header and cell
				DtCell assignHeader = createAssignHeader(headerName, headerCell.getColStartIndex(),
						headerCell.getColEndIndex(), headerRowIndex);

				DtCell assignCell = createAssignCell(value, headerCell.getColStartIndex(), headerCell.getColEndIndex(),
						currentRowIndex + valueIndex, assignHeader);

				// Add to span group
				int rowIndex = currentRowIndex - (headerRowIndex + 1) + valueIndex;
				ensureSpanGroupRowExists(spanGroup, currentRowIndex + valueIndex, rowIndex);
				spanGroup.getChilds().get(rowIndex).getChilds().add(assignCell);
			});
		});
	}

	private List<String> getTemplateHeaders(DecisionTable decisionTable) throws Exception {
		List<String> decisionHeaders = decisionTable.getVerticalHeaders().stream()
				.map(cell -> (String) cell.getContent()).collect(Collectors.toList());
		List<String> assignHeaders = decisionTable.getAssignHeaders().stream().map(cell -> (String) cell.getContent())
				.distinct().collect(Collectors.toList());
		// Set up column names for the iterator
		List<String> columnNames = new ArrayList<>();
		columnNames.addAll(decisionHeaders);
		columnNames.addAll(assignHeaders);
		return columnNames;
	}
}