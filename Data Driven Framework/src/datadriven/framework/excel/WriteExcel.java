package datadriven.framework.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileInputStream fis = new FileInputStream(new File("/Users/noheliaborjas/Documents/QA/TestData.xlsx"));	//Select file address to define input stream
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(1);
			String[][] Places = {							//Create Data to be Written
					{"Argentina"},
					{"Mexico"},
					{"Brazil"},
					{"Dominican Republic"},
					{"Costa Rica"}
			};
			
			int rowNum = 2;
			System.out.println("Creating Excel");
			
			for (String[] datatype: Places) {
				Row row = sheet.createRow(rowNum++);
				int colNum = 1;
				for (String field: datatype) {
					Cell cell = row.createCell(colNum++);
					if(field instanceof String) {
						cell.setCellValue((String) field);
					}
				}
			}
			
			FileOutputStream fos = new FileOutputStream(new File("/Users/noheliaborjas/Documents/QA/TestData.xlsx"));	//Select File to stream the output data
			wb.write(fos);
			wb.close();
			System.out.println("Done.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
