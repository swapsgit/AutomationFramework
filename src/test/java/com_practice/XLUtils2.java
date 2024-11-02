package com_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class XLUtils2 {

	private static FileInputStream fi;
	private static FileOutputStream fo;
	private static XSSFWorkbook wb;
	private static XSSFSheet ws;
	private static XSSFRow row;
	private static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) {

		try {
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ws = wb.getSheet(xlsheet);
		int row = ws.getLastRowNum();
		try {
			wb.close();
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return row;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rowNum) {

		try {
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		int cell = row.getLastCellNum();
		try {
			wb.close();
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cell;
	}

	public static String getCellData(String xlfile, String xlsheet, int rowNum, int cellNum) {

		try {
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(xlsheet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rowNum, int cellNum, String data) {
		try {
			fi = new FileInputStream(xlfile);

			wb = new XSSFWorkbook(xlsheet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);
		cell.setCellValue(data);
		try {
			fo = new FileOutputStream(xlfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
