package datadriven.framework.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class ExportExcelDataToWeb {

	static XSSFWorkbook wbI;
	static WebDriver driver;
	
	public static void invokeBrowser(String url) {
		try {
			System.setProperty("webdriver.safari.driver", "safaridriver");
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String[] importData() {
		try (
			FileInputStream fis = new FileInputStream(new File("/Users/noheliaborjas/Documents/QA/TestData.xlsx"))) {
			wbI = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheetI = wbI.getSheetAt(2);
		int rowNum = 0;		//Initializing FIRST row number to import
		int colNum = 0;		//Initializing FIRST column to import 
		String[] data = new String[sheetI.getLastRowNum()];	//creating string, with size of the data
		System.out.println("Importing Data... \n");		//System.out.println(sheet.getLastRowNum());

		for (int i = rowNum; i < sheetI.getLastRowNum(); i++) {		//Importing from rowNum to lastRowNum
			Row rowI = sheetI.getRow(i);
			Cell cellI = rowI.getCell(colNum);
			data[i] = cellI.getStringCellValue();		//Values are String type, change to double for numeric in all instances
		}
		
		System.out.println("The imported data as array is: \n");
		
		for ( String element : data ) {
			System.out.println( element );		//Printing newly built array
		}
		
		return data;
	}
	
	public void export2Web(String[] x){
		
		try {
			invokeBrowser("https://www.barnesandnoble.com/"); 
			WebElement container = driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[2]/div/input[1]"));
			
			String[] data = x;
			
			for (String element: data) {
				container.sendKeys(element+"\n");
				Thread.sleep(4000);
				driver.navigate().back();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExportExcelDataToWeb obj = new ExportExcelDataToWeb();
		obj.export2Web(importData());
	}
}
