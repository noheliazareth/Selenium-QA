package datadriven.framework.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static XSSFWorkbook wb;

	public static void main(String args[]) throws IOException {
		
		try {
			FileInputStream fis = new FileInputStream(new File("/Users/noheliaborjas/Documents/QA/TestData.xlsx"));
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();	//iterating over excel file
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();	//iterating per row
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();				//iterating per cell
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue()+"\t\t\t");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue()+"\t\t\t");
						break;
					default:
					}
				}
				System.out.println("");
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
