package com.javatpoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.swing.text.StyleConstants.ColorConstants;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFColorScaleFormatting;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportReport {
	XSSFWorkbook workbook = new XSSFWorkbook();

	public ExportReport() {
	}

	public void exportDatabasesReport(List<Employee> emp) {
		try {
			XSSFSheet reportSheet = workbook.createSheet("Report");

			XSSFRow row = reportSheet.createRow(0);
			XSSFCell cell;
			
			cell = row.createCell(1);
			cell.setCellValue("EMP ID");
			cell = row.createCell(2);
			cell.setCellValue("Designation");
			cell = row.createCell(3);
			cell.setCellValue("FirstName");
			cell = row.createCell(4);
			cell.setCellValue("LastName");
			
			row = reportSheet.createRow(4);
			cell = row.createCell(1);
			cell.setCellValue("EMP ID");
			cell = row.createCell(2);
			cell.setCellValue("Designation");
			cell = row.createCell(3);
			cell.setCellValue("FirstName");
			cell = row.createCell(4);
			cell.getCellStyle().setFillBackgroundColor(new
			XSSFColor(java.awt.Color.GREEN));
			cell.setCellValue("LastName");
			XSSFCellStyle createCellStyle = workbook.createCellStyle();

			XSSFFont createFont = workbook.createFont();

			int i = 5;
			for (Employee st : emp) {
				row = reportSheet.createRow(i);
				cell = row.createCell(1);
				cell.setCellValue(st.getId());
				cell = row.createCell(2);
				cell.setCellValue(st.getDesignation());
				cell = row.createCell(3);
				workbook.createFont().setColor(HSSFColor.BLUE.index);
				createCellStyle.setFont(createFont);
				cell.setCellStyle(createCellStyle);
				cell.setCellValue(st.getFirstName());
				cell = row.createCell(4);
				cell.setCellValue(st.getLastName());
				createFont.setColor(HSSFColor.BRIGHT_GREEN.index);
				createCellStyle.setFont(createFont);
				cell.setCellStyle(createCellStyle);
				i++;
			}

			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("GenerateReport.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Writesheet.xlsx written successfully");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}

	public void exportReport() {
		try {
			File file = new File("config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			String str = properties.getProperty("Column_Name");
			String[] columnlist = str.split(",");
			XSSFSheet reportSheet = workbook.createSheet("Report");
			int cellCount = 0;
			Row row = reportSheet.createRow(1);

			for (String st : columnlist) {

				Cell cell = row.createCell(cellCount++);
				cell.getCellTypeEnum();
				cell.setCellValue(st);
				System.out.println(st);
			}

			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File("Writesheet.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Writesheet.xlsx written successfully");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}
