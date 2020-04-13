package com.pwc.workbench.util;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class CommonUtils {
	
	private CommonUtils() {
		super();
	}

	/**
	 * invalid
	 */
	public static final String STATUS_INVALID = "invalid";
	
	/**
	 * valid
	 */
	public static final String STATUS_VALID = "valid";
	
	/**
	 * 计算公式
	 */
	public static final String CALCULATION_FORMULA  = "计算公式";
	
	/**
	 * 合计公式
	 */
	public static final String AGGREGATE_FORMULA  = "合计公式";
	
	/**
	 * VAT
	 */
	public static final String VAT_FORMULA  = "VAT";
	
	/**
	 * Excel number format
	 */
	public static final String NUMBER_FORMAT="_(* #,##0.00_);_(* (#,##0.00);_(* \"-\"??_);_(@_)";

	/**
	 * Excel date format
	 */
	public static final String DATE_FORMAT="yyyy-mm-dd";

	/**
	 * Excel number format
	 */
	public static final String INTEGER_FORMAT="0";
	
	public static final String INTEGER_INT_FORMAT = "_(* #,##0_);_(* (#,##0);_(* \"-\"_);_(@_)";

	public static final String INTEGER_FORMAT_DASH_ZERO="_(* #_);_(* (#);_(* \"-\"??_);_(@_)";

	/**
	 * Excel number format
	 */
	public static final String PERCENT_FORMAT="(+0%);(\"▲\"0%);_(* \"-\"??_);";
	
	public static final String ACTION_UPLOAD_EXT="Upload Estimation Data";

	public static final String ACTION_UPLOAD_BUDGET="Upload Budget Data";
	
	/**
	 * filetype noitem
	 */
	public static final String FILE_TYPE_NONITEM="nonitem";
	
	/**
	 * filetype item
	 */
	public static final String FILE_TYPE_ITEM="item";
	
	/**
	 * filetype item
	 */
	public static final String FILE_TYPE_POSM="POSM";
	
	/**
	 * oprtator plus
	 */
	public static final String OPRTATOR_PLUS="+";
	
	/**
	 * oprtator minus
	 */
	public static final String OPRTATOR_MINUS="-";
	
	/**
	 * oprtator multiplication
	 */
	public static final String OPRTATOR_MULTIPLICATION="*";
	
	/**
	 * oprtator division
	 */
	public static final String OPRTATOR_DIVISION="/";
	
	/**
	 * AUTHORIZATION_TYPE_DOWNLOAD
	 */
	public static final String AUTHORIZATION_TYPE_DOWNLOAD="ExpD";
	/**
	 * AUTHORIZATION_TYPE_UPLOAD
	 */
	public static final String AUTHORIZATION_TYPE_UPLOAD="ExpU";
	/*
	*UPLOAD_STATUS_CONFIRMED
	 */
	public  static  final String UPLOAD_STATUS_CONFIRMED="Confirmed";
	/*
	*UPLOAD_STATUS_WAITFORREVIEW
	 */
	public  static  final String UPLOAD_STATUS_WAITFORREVIEW="Waiting for review";
	
	//successfully message
	public  static  final String UPLOAD_SUCCESSFULLY_MESSAGE="The user has uploaded data into the following dapartments successfully:";
	//confirmed message
	public  static  final String UPLOAD_CONFIRMED_MESSAGE="The data of following departments has been confirmed by the administrator which cannot be overwritten:";
	//no authorization message
	public  static  final String UPLOAD_NO_AUTHORIZATION_MESSAGE="The user does not have the authorization to upload data for the following departments:";
	//missing message
	public  static  final String UPLOAD_MISSING_MESSAGE="Data of following departments is missing:";
	//.
	public  static  final String FULL_STOP =".";
	
	public  static  final String HTML_BR ="<br>";
	//占位符
	public  static  final String STIRNG_PLACE_HOLDER ="%s";
	
	//successfully message
	public  static  final String UPLOAD_BRAND_SUCCESSFULLY_MESSAGE="The user has uploaded data into the following brands successfully:";
	//confirmed message
	public  static  final String UPLOAD_BRAND_CONFIRMED_MESSAGE="The data of following brands has been confirmed by the administrator which cannot be overwritten:";
	//no authorization message
	public  static  final String UPLOAD_BRAND_NO_AUTHORIZATION_MESSAGE="The user does not have the authorization to upload data for the following brands:";
	//missing message
	public  static  final String UPLOAD_BRAND_MISSING_MESSAGE="Data of following brands is missing:";
	
	//Sales Budget
	//successfully message
	public  static  final String UPLOAD_BUDGET_SUCCESSFULLY_MESSAGE="The following Report Name budget data are uploaded successfully:";
	//confirmed message
	public  static  final String UPLOAD_BUDGET_CONFIRMED_MESSAGE="The following Report Name budget data has NeverOpened or Locked by the administrator which cannot be overwritten:";
	//no authorization message
	public  static  final String UPLOAD_BUDGET_NO_AUTHORIZATION_MESSAGE="The user does not have the authorization to upload data for the following Report Name:";
	//missing message
	public  static  final String UPLOAD_BUDGET_MISSING_MESSAGE="The following Report Name budget data are missing:";
	//confirmed message
	public  static  final String UPLOAD_ESTIMATION_CONFIRMED_MESSAGE="The following Report Name estimation data has NeverOpened or Locked by the administrator which cannot be overwritten:";
	//session
	public static final String USER_ID_SESSION_NAME = "user_Id";
	
	private static final String[] reportHeaders = {"", "", "", "1月", "2月", "3月", "4月", "5月", "6月","%s_1H", "7月", "8月", "9月", "10月","11月", "12月", "%s_2H", "%s_TTL"};
	
	private static final String[] reportHeaderBudget = {"", "", "", "1月", "2月", "3月", "4月", "5月", "6月","%s_1H", "7月", "8月", "9月", "10月","11月", "12月", "%s_2H", "%s_TTL","", "1H(Budget)", "2H(Budget)", "TTL(Budget)"};
	
	
	public static String[] getReportMonthlyHeader() {
		return reportHeaders;
	}
	
	public static String[] getReportHeaderBudget() {
		return reportHeaderBudget;
	}
	

	/**
	 * 下载文件，获取数据库中保存的文件
	 * @param httpServletResponse
	 * @param inFileName
	 * @param outFileName
	 * @throws Exception
	 */
	public static void downloadFile(HttpServletResponse httpServletResponse, String inFileName, String outFileName) throws Exception {

		InputStream inputStream = null;
		OutputStream outputStream = null;
		try{
			inputStream = new FileInputStream(inFileName);
			httpServletResponse.setContentType("application/octet-stream");
			httpServletResponse.setHeader("content-type","application/octet-stream");
			httpServletResponse.setHeader("Content-Disposition","attachment;fileName="+new String(outFileName.getBytes("UTF-8"),"ISO-8859-1"));
			outputStream = httpServletResponse.getOutputStream();
			IOUtils.copy(inputStream,outputStream);
			outputStream.flush();
		}catch (Exception e){
			throw new Exception("file download fail");
		}finally {
			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(outputStream);
		}
	}
	
	public static String getLastDate(String actualDate) {
		if (StringUtils.isEmpty(actualDate)) {
			return null;
		}
		String year=actualDate.substring(0,4);
		Integer lastYear=Integer.valueOf(year)-1;
		return lastYear+actualDate.substring(4);
		
	}
	
	public static Integer getMonth(String actualDate) {
		if (StringUtils.isEmpty(actualDate)) {
			return null;
		}
		String monthStr="";
		if(actualDate.charAt(4)=='0') {
			monthStr=actualDate.substring(5,actualDate.length());
		}else {
			monthStr=actualDate.substring(4,actualDate.length());
		}
		return Integer.valueOf(monthStr);
	}
	
	public static String getStartDate(String actualDate) {
		if (StringUtils.isEmpty(actualDate)) {
			return null;
		}
		return actualDate.substring(0,4)+"00";
	}
	
	public static String dateToString(Date date) {
		if (date==null) {
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	public static String emptyToZero(String str) {
		if (str.isEmpty()) {
			return "0";
		}
		return str;
	}

	public static void setColumnWidthTo13(XSSFSheet sheet, int columnIndex) {
		sheet.setColumnWidth(columnIndex,13*256);
	}

	public static String getCellValue(Cell cell) {
		String value = "";
		if(cell != null){
			switch (cell.getCellType()) {
				case STRING:
					value = cell.getRichStringCellValue().getString();
					break;
				case NUMERIC:
					cell.setCellType(CellType.STRING);
					value=cell.getStringCellValue();
//					if (DateUtil.isCellDateFormatted(cell)) {
//						value = cell.getDateCellValue().toString();
//					} else {
//						value = String.valueOf(cell.getNumericCellValue());
//					}
					break;
				case BOOLEAN:
					value = String.valueOf(cell.getBooleanCellValue());
					break;
				case FORMULA:
					try {
						value = String.valueOf(cell.getNumericCellValue());
					} catch (IllegalStateException e) {
						value = String.valueOf(cell.getRichStringCellValue());
					}
					break;
			}
		}
		return value;
	}

	public static String getIntegerFormatValue(Cell cell) {
		String value = "";
		if(cell != null){
			switch (cell.getCellType()) {
				case STRING:
					value = cell.getRichStringCellValue().getString();
					break;
				case NUMERIC:
					DecimalFormat integerFormat = new DecimalFormat("#");
					value = integerFormat.format(cell.getNumericCellValue());
					break;
			}
		}
		return value;
	}

	public static Date getDateValue(Cell cell) throws ParseException {
		Date date = null;
		if(cell != null){
			switch (cell.getCellType()) {
				case STRING:
					DateFormat df = new SimpleDateFormat("yyyyMMdd");
					date = df.parse(cell.getRichStringCellValue().getString());
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						date = cell.getDateCellValue();
					}
					break;
			}
		}
		return date;
	}

	public static String monthToDoubleDigit(String month) {
		DecimalFormat df = new DecimalFormat("00");
		return df.format(Integer.valueOf(month));
	}

	public static String monthToSingleDigit(String month) {
		DecimalFormat df = new DecimalFormat("#");
		return df.format(Integer.valueOf(month));
	}

	public static String checkGroupCode(String groupCode, Set<String> groupCodeSet, int rowIndex) {
		String tip = "";
		boolean exist = groupCodeSet.contains(groupCode);
		if (!exist) {
			int rowNumber = rowIndex + 1;
			tip = String.format("Row %d: Group code '%s' haven't maintained, please maintain master data first.<br>", rowNumber, groupCode);
		}
		return tip;
	}

	public static String checkCostElementCode(String costElementCode, Set<String> costElementCodeSet, String sheetName, int rowIndex) {
		String tip = "";
		boolean exist = costElementCodeSet.contains(costElementCode);
		if (!exist) {
			int rowNumber = rowIndex + 1;
			tip = String.format("Cost element code '%s' haven't maintained at sheet '%s', row %d, please maintain " +
					"master data first.<br>", costElementCode, sheetName, rowNumber);
		}
		return tip;
	}

	/**
	 * 设置Excel单元格根据内容自动变换宽度
	 *
	 * @param sheet
	 * @param size
	 */
	public static void setSizeColumn(XSSFSheet sheet, int size) {
		for (int columnNum = 0; columnNum < size; columnNum++) {
			int columnWidth = sheet.getColumnWidth(columnNum) / 256;
			for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
				XSSFRow currentRow;
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}

				if (currentRow.getCell(columnNum) != null) {
					XSSFCell currentCell = currentRow.getCell(columnNum);
					if (currentCell.getCellType() == CellType.STRING) {
						String currentString = currentCell.getStringCellValue();
						int length = currentString.getBytes().length;
						length = (int) (Math.ceil(length / 3) * 2 + 5);

						if (columnWidth < length) {
							columnWidth = length;
						}
						if (columnWidth > 255) {
							columnWidth = 255;
						}
					}
				}
			}
			sheet.setColumnWidth(columnNum, columnWidth * 256);
		}
	}


}
