package datadriven.framework.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	private static XSSFWorkbook wbI, wbE;
	
	public static String[] importData() {
		try (
			FileInputStream fis = new FileInputStream(new File("/Users/noheliaborjas/Documents/QA/TestData.xlsx"))) {
			wbI = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheetI = wbI.getSheetAt(0);
		int rowNum = 2;		//Initializing FIRST row number to import
		int colNum = 1;		//Initializing FIRST column to import 
		String[] data = new String[sheetI.getLastRowNum()-1];	//creating string, with size of the column
		System.out.println("Importing Data... \n");		//System.out.println(sheet.getLastRowNum());

		for (int i = rowNum; i <= sheetI.getLastRowNum(); i++) {		//Importing from rowNum to lastRowNum
			Row rowI = sheetI.getRow(i);
			Cell cellI = rowI.getCell(colNum);
			data[i-rowNum] = cellI.getStringCellValue();		//Values are String type, change to double for numeric 
		}
		
		System.out.println("The imported data as array is: \n");
		
		for ( String element : data ) {
			System.out.println( element );		//Printing newly built array
		}
		
		return data;
	}
	
	static void exportData(String[] x) throws IOException {
		try (
				FileInputStream fis = new FileInputStream(new File("/Users/noheliaborjas/Documents/QA/TestData.xlsx"))) {
				wbE = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		XSSFSheet sheetE = wbE.createSheet("ReadWriteExcel");
		
		int rowNum = x.length;		//Initializing FIRST row number to export
		int colNum = 0;		//Initializing FIRST column to export 
		String[] data = x;
		
		
		for (int i = 0; i < rowNum; i++) {			//moving through rows on column to export
			Row row = sheetE.createRow(i);
			Cell cell = row.createCell(colNum);
			cell.setCellValue(data[i]);
			System.out.println(cell);
		}
		
		FileOutputStream fos = new FileOutputStream(new File("/Users/noheliaborjas/Documents/QA/TestData.xlsx"));	//Select File to stream the output data
		wbE.write(fos);
		wbE.close();
		System.out.println("Done.");
	}
	
	
	public static void main(String args[]) throws IOException {
		
		String[] data = ReadWriteExcel.importData();
		System.out.println("\n");
		
		System.out.println("The exported data array is:");
		ReadWriteExcel.exportData(data);
		
	}
}
