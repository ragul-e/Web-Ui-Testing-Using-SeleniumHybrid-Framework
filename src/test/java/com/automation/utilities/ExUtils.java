package com.automation.utilities;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	public static String[][] readValueAs2d(String filepath)  {
		File file =  new File(filepath);
		FileInputStream fin = null;
		String[][] data = null;
		try {
			 fin = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook xworkbook = new XSSFWorkbook();
		XSSFSheet sheet = xworkbook.getSheet("Regdata");
		int noofrows = sheet.getPhysicalNumberOfRows();
		int nofcol = sheet.getRow(0).getLastCellNum();
		data = new String[noofrows-1][nofcol];
		DataFormatter df = new DataFormatter();
		for (int i = 0; i < noofrows-1; i++) {
			Row row = sheet.getRow(i+1);
			for (int j = 0; j < nofcol; j++) {
				Cell cell = row.getCell(j);
				
//				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
				data[i][j] = df.formatCellValue(cell);
			}
			
		}
		try {
			xworkbook.close();
			fin.close();
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
