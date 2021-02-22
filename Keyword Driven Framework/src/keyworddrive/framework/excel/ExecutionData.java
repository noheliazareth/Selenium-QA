package keyworddrive.framework.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExecutionData {
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	
	public static void readExcel(String path, int sheetNum) {	//gets the excel file with keywords
		
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheetNum);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getData(int rowNum, int cellNum) {		//gets the data needed to test
		String data = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;	
	}
	
	public static int getRowNum() {
		int RowNum = sheet.getLastRowNum();
		return RowNum;
	}
	
	public static int getColNum() {
		int ColNum = sheet.getRow(sheet.getLastRowNum()).getLastCellNum();
		return ColNum;
	}
}
