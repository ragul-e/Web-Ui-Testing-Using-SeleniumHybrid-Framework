package com.automation.utilities;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.netty.handler.codec.DateFormatter;

/**
 * 
 * @author RagulRaj
 * Date: 15/05/2021
 *
 */
public class ExUtils {

	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	

	/**
	 * 
	 * @param filepath
	 * @return
	 */
public static void createFile(String filepath) {
		

		//
			workbook = new HSSFWorkbook();
			sheet = workbook.createSheet("TestData1");
			sheet.createRow(0);
		
			sheet.getRow(0).createCell(0).setCellValue("verifynewusertext");
		sheet.getRow(0).createCell(1).setCellValue("signupname");
		sheet.getRow(0).createCell(2).setCellValue("signupemail");
		sheet.getRow(0).createCell(3).setCellValue("accountinfotxt");
		sheet.getRow(0).createCell(4).setCellValue("password");
		sheet.getRow(0).createCell(5).setCellValue("date");
		sheet.getRow(0).createCell(6).setCellValue("month");
		sheet.getRow(0).createCell(7).setCellValue("year");
		sheet.getRow(0).createCell(8).setCellValue("Addrestinfotext");
		sheet.getRow(0).createCell(9).setCellValue("firstname");
		sheet.getRow(0).createCell(10).setCellValue("lastname");
		sheet.getRow(0).createCell(11).setCellValue("companyaddress");
		sheet.getRow(0).createCell(12).setCellValue("addressone");
		sheet.getRow(0).createCell(13).setCellValue("addresstwo");
		sheet.getRow(0).createCell(14).setCellValue("country");
		sheet.getRow(0).createCell(15).setCellValue("state");
	
		sheet.getRow(0).createCell(16).setCellValue("city");
		sheet.getRow(0).createCell(17).setCellValue("zipcode");
		sheet.getRow(0).createCell(18).setCellValue("mobnum");
		sheet.getRow(0).createCell(19).setCellValue("verfyaccntcreatedtext");
		sheet.getRow(0).createCell(20).setCellValue("accntcreatedtext");
		sheet.getRow(0).createCell(21).setCellValue("loginusername");
		
		sheet.createRow(1);
		
		
		sheet.getRow(1).createCell(0).setCellValue("New User Signup");
		sheet.getRow(1).createCell(1).setCellValue("boston1");
		sheet.getRow(1).createCell(2).setCellValue("boston18@gmail.com");
		sheet.getRow(1).createCell(3).setCellValue("ENTER ACCOUNT INFORMATION");
		sheet.getRow(1).createCell(4).setCellValue("Janet6@Automation7");
		sheet.getRow(1).createCell(5).setCellValue("12");
		sheet.getRow(1).createCell(6).setCellValue("December");
		sheet.getRow(1).createCell(7).setCellValue("2020");
		sheet.getRow(1).createCell(8).setCellValue("ADDRESS INFORMATION");
		sheet.getRow(1).createCell(9).setCellValue("janet5");
		sheet.getRow(1).createCell(10).setCellValue("a");
		sheet.getRow(1).createCell(11).setCellValue("wipro");
		sheet.getRow(1).createCell(12).setCellValue("gandhi street");
		sheet.getRow(1).createCell(13).setCellValue("bheema ra street");
		sheet.getRow(1).createCell(14).setCellValue("India");
		sheet.getRow(1).createCell(15).setCellValue("tn");

		sheet.getRow(1).createCell(16).setCellValue("chennai");
		sheet.getRow(1).createCell(17).setCellValue("607002");
		sheet.getRow(1).createCell(18).setCellValue("1010101010");
		sheet.getRow(1).createCell(19).setCellValue("ACCOUNT CREATED!");
		sheet.getRow(1).createCell(20).setCellValue("ACCOUNT CREATED");
		sheet.getRow(1).createCell(21).setCellValue("logged in as boston1");
		
			File file = new File(filepath);
			try {
				workbook.write(file);
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



	}
	
	
public static String[][] readData(String filepath) {

	HSSFWorkbook workbook = null;
	HSSFSheet sheet = null;
	FileInputStream finputstream;

	File file = new File(filepath);
	FileInputStream fin;
	String[][] data = null;
	try {
		fin = new FileInputStream(file);
		workbook = new HSSFWorkbook(fin);
		sheet = workbook.getSheet("TestData1");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	int rowcount = sheet.getPhysicalNumberOfRows();
	int colcount = sheet.getRow(1).getLastCellNum();

	data = new String[rowcount - 1][colcount];

	DataFormatter df = new DataFormatter();
	for (int i = 0; i < rowcount - 1; i++) {
		HSSFRow row = sheet.getRow(i + 1);

		int cellcount = row.getPhysicalNumberOfCells();
		for (int j = 0; j < cellcount; j++) {
			HSSFCell cell = row.getCell(j);
			data[i][j] = df.formatCellValue(cell);
//			System.out.println(cell);
		}
	}

	try {
		workbook.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return data;

}



	/**
	 * 
	 * @param cell
	 * @return
	 */
	private static String getCellStringValue(Cell cell) {
		String cellValue = "";
		if (cell != null) {
			CellType cellType = cell.getCellType();
			if (cellType == CellType.STRING) {
				cellValue = cell.getStringCellValue();
			} else if (cellType == CellType.NUMERIC) {
				cellValue = String.valueOf(cell.getNumericCellValue());
			} else if (cellType == CellType.BOOLEAN) {
				cellValue = String.valueOf(cell.getBooleanCellValue());
			} else if (cellType == CellType.FORMULA) {
				cellValue = cell.getCellFormula();
			}
		}
		return cellValue;
	}
	
	/**
	 * 
	 * @param filepath
	 * @param productdetails
	 */
	public static void putValueIntoExcel(String filepath ,List<String> productdetails) {
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Products");
		
		int rowcount = 0;
		int colcount = 0;
		
		for (String data : productdetails) {
			Row row = sheet.getRow(rowcount);
			if(row == null) {
				row = sheet.createRow(rowcount);
			}
			
			Cell cell = row.createCell(colcount);
			cell.setCellValue(data);			
			colcount++;
			
			if(colcount == 4) {
				rowcount++;
				colcount=0;
			}
		}
		
		
		File file = new File(filepath);
		try {
			workbook.write(file);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
