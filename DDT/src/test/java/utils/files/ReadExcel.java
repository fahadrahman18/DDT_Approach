package utils.files;

import java.io.IOException;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.cli.Main;
import ddt.testcases.ProjectSpecificMethods;

public class ReadExcel extends ProjectSpecificMethods{
	
	//public void exceldatas() throws IOException {
	public static String[][] getData(String excelFilePath) throws IOException {
		
		DataFormatter format = new DataFormatter();
		
		//open a excel
		XSSFWorkbook book = new XSSFWorkbook(excelFilePath);
		
		//open a sheet
		XSSFSheet sheet = book.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("Number of rows: " + rowCount);
		
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of columns:" + colCount);
		String[][] data = new String[rowCount][colCount];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i); //get each row
			for (int j = 0; j < colCount; j++) {
				XSSFCell eachCell = eachRow.getCell(j); //get each cell in an row
				//CellType value = eachCell.getCellType(); //Read Value
				String formatCellValue = format.formatCellValue(eachCell);
				//System.out.println(value);
				//System.out.println(formatCellValue);
				data[i-1][j] = formatCellValue;
				System.out.println(data);
			}
			
		book.close();
		}
		// return 2d array
		return data;
		
		
		
	}

}
