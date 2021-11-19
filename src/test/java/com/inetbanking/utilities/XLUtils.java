package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path = null;

	public XLUtils(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}

	public int getCellCount(String sheetName, int rownum) throws IOException {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
	}

	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		// data formatter use to get all type of data in string form

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fis.close();
		return data;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		cell.setCellValue(data);
		fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		fis.close();

	}

	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fos = new FileOutputStream(path);
		wb.write(fos);

		wb.write(fos);
		wb.close();
		fis.close();

	}

	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fos = new FileOutputStream(path);
		wb.write(fos);

		wb.write(fos);
		wb.close();
		fis.close();

	}
}
