package com.pwc.workbench.util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.alibaba.druid.util.StringUtils;

@Repository
public class XMLReader2SAX extends DefaultHandler {

	private String tagName;
	List<String> oneContent = new ArrayList<>();
	private CSVPrinter printer;
	private String csvFileName;
	private String actualDate;
	private StringBuffer value = new StringBuffer();

	private static final Logger logger = LoggerFactory.getLogger(DefaultHandler.class);

	/**
	 * @param args
	 */
	@Override
	public void startDocument() throws SAXException {
		logger.info("---------begin---------");
		try {
			printer = new CSVPrinter(new FileWriter(csvFileName), CSVFormat.EXCEL.withIgnoreHeaderCase());
		} catch (IOException e) {
			logger.error("error in init CVSPrint");
			e.printStackTrace();
		}
	}

	@Override
	public void endDocument() throws SAXException {
		try {
			printer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("---------end---------");

	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes attr) throws SAXException {
		tagName = qName;

		// TODO
		if (tagName.equals("Cell")) {
			for (int i = 0; i < attr.getLength(); i++) {
				if (("ss:Index").equals(attr.getQName(i))) {
					String value = attr.getValue(i);
					Integer index = Integer.valueOf(value);
					while (oneContent.size() < index - 1) {
						oneContent.add("");
					}
					break;

				}

			}

		}
		if (tagName.equals("Cell")) {
			value = new StringBuffer();
		}
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		try {
			if (qName.equals("Cell")) {
				oneContent.add(new String(value.toString().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
				//oneContent.add(value.toString());
			}
			if (qName.equals("Row")) {
				oneContent.add(actualDate);
				if (oneContent.size() > 0 && !StringUtils.isEmpty(oneContent.get(0))) {
					printer.printRecord(oneContent);
				}
				oneContent = new ArrayList<>();
			}
			tagName = "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (tagName.equals("Data")) {
			value.append(ch, start, length);
			// String content =sb.toString();
			// //String value = String.copyValueOf(ch, start, length);
			// if (!StringUtils.isEmpty(content)) {
			// oneContent.add(content);
			// }
		}

	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<String> getOneContent() {
		return oneContent;
	}

	public void setOneContent(List<String> oneContent) {
		this.oneContent = oneContent;
	}

	public CSVPrinter getPrinter() {
		return printer;
	}

	public void setPrinter(CSVPrinter printer) {
		this.printer = printer;
	}

	public String getCsvFileName() {
		return csvFileName;
	}

	public void setCsvFileName(String csvFileName) {
		this.csvFileName = csvFileName;
	}

	public String getActualDate() {
		return actualDate;
	}

	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}
}
