package com.act21.impaktapps.rule.engine.table;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.act21.impaktapps.rule.engine.api.RuleCreationRequest;
import com.act21.impaktapps.rule.engine.handler.SheetHandler;
import com.act21.impaktapps.rule.engine.validation.ValidationMessage;
import com.act21.impaktapps.rule.engine.validation.ValidationService;

public class DecisionTableParser {

	public DecisionTable processExcel(RuleCreationRequest request, InputStream inputStream, List<ValidationMessage> messages) throws Exception {
		ValidationService validationService = new ValidationService();

		try (OPCPackage opcPackage = OPCPackage.open(inputStream)) {
			XSSFReader xssfReader = new XSSFReader(opcPackage);

			XMLReader xmlReader = createXMLReader();

			SharedStringsTable sst = xssfReader.getSharedStringsTable();

			DecisionTable decisionTable = new DecisionTable(request.getName(), 1);

			XSSFReader.SheetIterator mergedSectionIterator = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
			try (InputStream mergedSectionStream = mergedSectionIterator.next()) {

				List<DtCell> mergedCell = getMergedRegions(xmlReader, mergedSectionStream);
				XSSFReader.SheetIterator dataSheetIterator = (XSSFReader.SheetIterator) xssfReader.getSheetsData();
				try (InputStream dataStream = dataSheetIterator.next()) {

					SheetHandler handler = new SheetHandler(xssfReader.getStylesTable(), sst, decisionTable, mergedCell,
							messages, request,validationService);

					xmlReader.setContentHandler(handler);
					xmlReader.parse(new InputSource(dataStream));
				}
			}

			if (request.getSchema().isIncludeMetaColumns()) {
				messages.addAll(validationService.verifyIfMetadataHeaderPresent(decisionTable.getVerticalHeaders()));
			}

			validationService.validateDecisionTable(decisionTable, messages);
			return decisionTable;
		}

	}

	public static XMLReader createXMLReader() throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		return saxParser.getXMLReader();
	}

	public static List<DtCell> getMergedRegions(XMLReader xmlReader, InputStream sheetInputStream) throws Exception {
		List<DtCell> mergedRegions = new ArrayList<>();
		xmlReader.setContentHandler(new DefaultHandler() {
			boolean inMergeCells = false;

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes) {
				if ("mergeCells".equals(qName)) {
					inMergeCells = true;
				} else if ("mergeCell".equals(qName) && inMergeCells) {
					String ref = attributes.getValue("ref");
					if (ref != null) {
						DtCell mergedCell = new DtCell(ref);
						mergedRegions.add(mergedCell);
					}
				}
			}

			@Override
			public void endElement(String uri, String localName, String qName) {
				if ("mergeCells".equals(qName)) {
					inMergeCells = false;
				}
			}
		});
		xmlReader.parse(new InputSource(sheetInputStream));
		return mergedRegions;
	}

}
