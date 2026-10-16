package com.act21.impaktapps.rule.engine.validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.model.StylesTable;
import org.eclipse.xtext.validation.Issue;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;

import com.act21.impaktapps.rule.engine.api.PropertySchema;
import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.commons.Commons;
import com.act21.impaktapps.rule.engine.commons.Constants;
import com.act21.impaktapps.rule.engine.table.DecisionTable;
import com.act21.impaktapps.rule.engine.table.DtCell;
import com.act21.impaktapps.rule.engine.table.DtCellType;

public class ValidationService {

	private static final String ERROR = "Error";
	private static final String SEVERITY_HIGH = "High";

	public void validateCell(DtCell cell, DtCell parentCell, DecisionTable dt, RuleCreationRequest request,
			List<ValidationMessage> messages) {

		validateCellFormat(cell, messages);
		if (isHeader(cell)) {
			validateHeader(cell, messages, request);
		} else if (!isHeader(cell)) {
			validateCellValue(cell, parentCell, request, dt.getRuleGridIds(), messages);
		}

		switch (cell.getDtCellType()) {
		case DECISION_HEADER_H -> validateHorizontalHeader(cell, dt, messages);
		case DECISION_H -> validateDecisionHorizontal(cell, messages);
		case DECISION_HEADER_V -> validateVerticalHeader(cell, dt, messages);
		case DECISION_V -> validateDecisionVertical(cell, parentCell, messages);
		case ASSIGN_HEADER -> validateAssignHeader(cell, dt, messages);
		case ASSIGN -> validateAssignCell(cell, messages);
		default -> throw new IllegalArgumentException("Unexpected value: " + cell.getDtCellType());
		}

	}

	private void validateHeader(DtCell cell, List<ValidationMessage> messages, RuleCreationRequest request) {

		if (isMetadataHeader(cell)) {
			return;
		}
		String headerName = cell.getContent().toString();
		PropertySchema propertyScehma = request.getSchema().getPropertySchemaMap().get(headerName);
		if (propertyScehma == null) {
			String description = cell.getContent() + " does not exist in variable class";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}

	}

	private boolean isMetadataHeader(DtCell cell) {
		return cell.isMetaDataColumn();
	}

	private boolean isMetadataValueCell(DtCell cell) {
		return (cell.getDtCellType().equals(DtCellType.DECISION_V) && cell.getDecisionHeader().isMetaDataColumn());
	}

	private void validateMetadataValueCell(DtCell cell, DtCell parentCell, Set<Long> ruleGridIds,
			List<ValidationMessage> messages) {
		if (cell.getDecisionHeader().getContent() != null) {
			switch (cell.getDecisionHeader().getContent().toString()) {
			case "rule_grid_id":
				validateRuleId(cell, ruleGridIds, messages);
				break;
			case "rule_eff_start_date":
				validateEffDate(cell, messages, parentCell, "rule_eff_start_date");
				break;
			case "rule_eff_end_date":
				validateEffDate(cell, messages, parentCell, "rule_eff_end_date");
				break;

			case "rule_active_status":
				validateRuleActiveStatus(cell, messages);
				break;
			}
		}

	}

	private void validateEffDate(DtCell cell, List<ValidationMessage> messages, DtCell parentCell, String header) {
		String description = "";
		try {
			if (cell.getContent().toString().isEmpty()) {
				description = String.format("Date cell cannot be empty with header: %s",
						cell.getDecisionHeader().getContent().toString());

				messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
				return;
			} else if (!Commons.isDate(cell.getContent().toString())) {
				description = String.format("%s is not a valid date", cell.getContent().toString());
				messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
				return;
			}
			validateEffectiveDateOrder(cell, messages, parentCell, header);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private void validateEffectiveDateOrder(DtCell cell, List<ValidationMessage> messages, DtCell parentCell,
			String header) throws IllegalStateException {
		String description;
		Date startDate = null;
		Date endDate = null;
		if (parentCell != null && "rule_eff_end_date".equals(header)) {
			endDate = Commons.parse(cell.getContent().toString());
			startDate = Commons.parse(parentCell.getContent().toString());
		}
		if (startDate != null && endDate != null && startDate.compareTo(endDate) >= 0) {
			description = "Effective end date should be greater than effective start date";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
	}

	private boolean isHeader(DtCell cell2) {
		return DtCellType.ASSIGN_HEADER.equals(cell2.getDtCellType())
				|| DtCellType.DECISION_HEADER_H.equals(cell2.getDtCellType())
				|| DtCellType.DECISION_HEADER_V.equals(cell2.getDtCellType());
	}

	private void validateCellValue(DtCell cell, DtCell parentCell, RuleCreationRequest request, Set<Long> ruleGridIds,
			List<ValidationMessage> messages) {
		if (!isCellValid(cell)) {
			messages.add(prepareValidationMessage(cell,
					String.format("Cell with [R: %d , C: %d] is not a part of data table", cell.getRowStartIndex(),
							cell.getColStartIndex()),
					SEVERITY_HIGH, ERROR));
			return;
		}
		if (isMetadataValueCell(cell)) {
			validateMetadataValueCell(cell, parentCell, ruleGridIds, messages);
			return;
		}
		if (Commons.isDecideCell(cell) && (cell.getContent().toString().isEmpty()
				|| Constants.PASS_CONDITIONS.contains(cell.getContent().toString()))) {
			return;
		}
		try {
			messages.addAll(getValidationMessages(cell, request.getExpressionParser().validateCell(cell)));
		} catch (Exception e) {
			messages.add(prepareValidationMessage(cell, "ERROR", "High", "Unable to parse the expression"));
			throw new RuntimeException(e);
		}
	}

	private List<ValidationMessage> getValidationMessages(DtCell cell, List<Issue> issues) {
		return issues.stream().map(issue -> prepareValidationMessage(cell, issue.getMessage(), SEVERITY_HIGH, ERROR))
				.toList();

	}

	public void firstCellValidation(DtCell cell, String fillColor, List<ValidationMessage> messages) {
		if (!Constants.DECIDE_HEADER_COLOR.equalsIgnoreCase(fillColor)) {
			messages.add(prepareValidationMessage(cell, "First cell should be yellow", SEVERITY_HIGH, ERROR));
		}
	}

	private boolean isCellValid(DtCell cell) {
		return cell.getDecisionHeader() != null || cell.getAssignHeader() != null;
	}

	private void validateAssignCell(DtCell cell, List<ValidationMessage> messages) {
		if (isMergedCell(cell)) {
			String description = "Output cell cannot be merged";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
	}

	private void validateDecisionVertical(DtCell cell, DtCell parentCell, List<ValidationMessage> messages) {
		if (cell.getColStartIndex() != cell.getColEndIndex()) {
			String description = "Vertical input cell cannot be merged horizontally";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
		if (cell.isLeaf() && isMergedCell(cell)) {
			String description = "Last vertical input cell cannot be merged";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}

		if (isParentCellInvalid(cell, parentCell)) {
			String description = String.format("Cell %s cannot have larger span than parent cell", cell.getCellRef());
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
	}

	private void validateDecisionHorizontal(DtCell cell, List<ValidationMessage> messages) {
		if (cell.getRowStartIndex() != cell.getRowEndIndex()) {
			String description = "Horizontal input cell cannot be merged vertically";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
	}

	private void validateVerticalHeader(DtCell cell, DecisionTable dt, List<ValidationMessage> messages) {

		if (isEmpty(cell)) {
			String description = "Vertical input Header cannot be empty";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
		if (isMergedCell(cell)) {
			String description = "Vertical input Header cannot be merged";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
		if (!dt.getAssignHeaders().isEmpty()) {
			String description = "Vertical input Header cannot come after assign headers";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}

	}

	private void validateAssignHeader(DtCell cell, DecisionTable dt, List<ValidationMessage> messages) {

		if (isEmpty(cell)) {
			String description = "Output Header cannot be empty";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
		if (isMergedCell(cell)) {
			String description = "Output Header cannot be merged";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
	}

	private void validateHorizontalHeader(DtCell cell, DecisionTable dt, List<ValidationMessage> messages) {
		if (isEmpty(cell)) {
			String description = "Horizontal input Header cannot be empty";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
		if (cell.getRowStartIndex() != cell.getRowEndIndex()) {
			String description = "Horizontal input Header cannot be merged vertically";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}
		if (Commons.isDecideCell(cell) && !dt.getAssignHeaders().isEmpty()) {
			String description = "Horizontal input Header cannot come after assign headers";
			messages.add(prepareValidationMessage(cell, description, SEVERITY_HIGH, ERROR));
		}

	}

	public void validateDecisionTable(DecisionTable dt, List<ValidationMessage> messages) {
		if (dt.getAssignHeaders().isEmpty()) {
			messages.add(prepareValidationMessage(null,
					String.format("%s : There should be atleast 1 assign header present", dt.getName()), SEVERITY_HIGH,
					ERROR));
		}
		if (dt.getVerticalHeaders().isEmpty()) {
			messages.add(prepareValidationMessage(null,
					String.format("%s : There should be atleast 1 vertical header present", dt.getName()),
					SEVERITY_HIGH, ERROR));
		} else if (!isHorizontalHeaderSizeValid(dt.getHorizontalHeaders(),
				dt.getVerticalHeaders().get(dt.getVerticalHeaders().size() - 1).getColEndIndex())) {
			messages.add(prepareValidationMessage(null,
					String.format("%s : Horizontal input header size is not valid", dt.getName()), SEVERITY_HIGH,
					ERROR));
		}
	}

	private boolean isHorizontalHeaderSizeValid(List<DtCell> horizontalHeaders, int headerValidEndIdx) {

		for (DtCell header : horizontalHeaders) {
			if (header.getColEndIndex() != headerValidEndIdx) {
				return false;
			}
		}

		return true;
	}

	private boolean isMergedCell(DtCell cell) {
		return cell.getRowStartIndex() != cell.getRowEndIndex() || cell.getColStartIndex() != cell.getColEndIndex();
	}

	private boolean isEmpty(DtCell cell) {
		return cell.getContent().toString().trim().isEmpty();
	}

	public ValidationMessage prepareValidationMessage(DtCell cell, String description, String severity,
			String messageType) {

		ValidationMessage message = new ValidationMessage();

		message.setMessageType(messageType);
		message.setSeverity(severity);
		message.setDescription(description);
		if (cell != null) {
			message.setCellNum(cell.getCellRef());
		}
		return message;
	}

	private void validateRuleActiveStatus(DtCell cell, List<ValidationMessage> messages) {

		if (cell.getContent() != null && !cell.getContent().toString().isEmpty()
				&& !Constants.RULE_STATUS_POSSIBLE_VALUES.contains(cell.getContent())) {
			messages.add(prepareValidationMessage(cell, "rule_active_status should be Y/N ", SEVERITY_HIGH, ERROR));
		}

	}

	private void validateRuleId(DtCell cell, Set<Long> ruleGridIds, List<ValidationMessage> messages) {

		if (!cell.getContent().toString().isEmpty()) {

			if (cell.getContent() != null && !Commons.isNumber(cell.getContent().toString())) {
				messages.add(prepareValidationMessage(cell, "rule_grid_id should be a number", SEVERITY_HIGH, ERROR));
			}
			Long ruleGridId = Long.valueOf(cell.getContent().toString());
			if (ruleGridIds.contains(ruleGridId)) {
				messages.add(prepareValidationMessage(cell, String.format("rule_grid_id %d already exist.", ruleGridId),
						SEVERITY_HIGH, ERROR));
			} else {
				ruleGridIds.add(ruleGridId);
			}
		}

	}

	public List<ValidationMessage> validateDecisionTableStructure(DecisionTable structure, DecisionTable table) {
		List<ValidationMessage> validationMessages = new ArrayList<>();

		validateHeaderSize(validationMessages, structure.getHorizontalHeaders(), table.getHorizontalHeaders(),
				"Horizontal input");
		validateHeaderSize(validationMessages, structure.getVerticalHeaders(), table.getVerticalHeaders(),
				"Vertical input");
		validateHeaderSize(validationMessages, structure.getAssignHeaders(), table.getAssignHeaders(), "Output");
		validateHorizontal(validationMessages, structure.getHorizontal(), table.getHorizontal());

		if (!validationMessages.isEmpty()) {
			return validationMessages;
		}

		compareHeaders(validationMessages, structure.getHorizontalHeaders(), table.getHorizontalHeaders());
		compareHeaders(validationMessages, structure.getVerticalHeaders(), table.getVerticalHeaders());
		compareHeaders(validationMessages, structure.getAssignHeaders(), table.getAssignHeaders());

		return validationMessages;
	}

	private void validateHorizontal(List<ValidationMessage> messages, List<DtCell> horizontal1,
			List<DtCell> horizontal2) {
		if (horizontal1.isEmpty() && horizontal2.isEmpty()) {
			return;
		}
		if (horizontal1.size() != horizontal2.size()) {
			messages.add(prepareValidationMessage(null,
					String.format("Template mismatched :Horizontal input Expected column %d, Found column %d at row %d",
							horizontal1.size(), horizontal2.size(), horizontal1.get(0).getRowStartIndex()),
					SEVERITY_HIGH, ERROR));
			return;
		}
		for (int i = 0; i < horizontal1.size(); i++) {
			DtCell cell1 = horizontal1.get(i);
			DtCell cell2 = horizontal2.get(i);
			if (!Commons.compare(cell1, cell2)) {
				messages.add(prepareValidationMessage(horizontal1.get(i),
						String.format("Template mismatched:Horizontal input value '%s' not found in the uploaded grid",
								horizontal1.get(i).getContent()),
						SEVERITY_HIGH, ERROR));
			}

			validateHorizontal(messages, cell1.getChilds(), cell2.getChilds());

		}

	}

	private void validateHeaderSize(List<ValidationMessage> messages, List<DtCell> headers1, List<DtCell> headers2,
			String headerType) {
		if (headers1.size() != headers2.size()) {
			messages.add(prepareValidationMessage(null,
					String.format("Template mismatched :%s header Expected column %d, Found column %d", headerType,
							headers1.size(), headers2.size()),
					SEVERITY_HIGH, ERROR));
		}
	}

	private void compareHeaders(List<ValidationMessage> messages, List<DtCell> headers1, List<DtCell> headers2) {
		int i = 0;
		for (DtCell header : headers1) {
			if (!Commons.compare(header, headers2.get(i))) {
				messages.add(prepareValidationMessage(header, String
						.format("Template mismatched: '%s' header not found in the uploaded grid", header.getContent()),
						SEVERITY_HIGH, ERROR));
			}
			i++;
		}
	}

	public List<ValidationMessage> verifyIfMetadataHeaderPresent(List<DtCell> verticalHeaders) {
		List<ValidationMessage> messages = new ArrayList<>();
		try {
			for (int i = 0; i < Constants.META_DATA_COLUMNS.size(); i++) {
				String column = Constants.META_DATA_COLUMNS.get(i);
				DtCell cell = verticalHeaders.get(i);
				if (!column.equals(cell.getContent().toString())) {
					messages.add(prepareValidationMessage(verticalHeaders.get(i),
							String.format("%s is not present or not in the correct order", column), SEVERITY_HIGH,
							ERROR));
				}
			}
		} catch (Exception e) {
			messages.add(prepareValidationMessage(null, "MetaData Headers Mismatch", SEVERITY_HIGH, ERROR));
		}

		return messages;
	}

	public void validateCellDateType(DtCell cell, StylesTable stylesTable, String styleIndex,
			List<ValidationMessage> messages) {
		if (styleIndex != null) {
			CTXf cellXf = stylesTable.getCellXfAt(Integer.parseInt(styleIndex));
			short numFmtId = (short) cellXf.getNumFmtId();

			String formatString = stylesTable.getNumberFormatAt(numFmtId);

			if (DateUtil.isADateFormat(numFmtId, formatString)) {
				messages.add(prepareValidationMessage(cell,
						"Cell type in excel cannot be date, Change the type to Text", SEVERITY_HIGH, ERROR));
			}
		}

	}

	public void validateCellFormat(DtCell cell, List<ValidationMessage> messages) {

		if (DateUtil.isADateFormat(cell.getCellFormatId(), cell.getCellFormat())) {
			messages.add(prepareValidationMessage(cell, "Cell type in excel should not be date", SEVERITY_HIGH, ERROR));
		}

	}

	public boolean isParentCellInvalid(DtCell cell, DtCell parentCell) {
		return parentCell != null && (parentCell.getRowStartIndex() > cell.getRowStartIndex()
				|| parentCell.getRowEndIndex() < cell.getRowEndIndex());
	}

}
