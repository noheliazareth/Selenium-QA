package datadriven.framework.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class ImportWebDataToExcel {
		
	static XSSFWorkbook wbE;
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
	
	public static String[] webImport(){
		invokeBrowser("https://www.barnesandnoble.com/"); 
		
		WebElement container= driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div/ul"));
		List<WebElement> elementList= container.findElements(By.tagName("li"));
		
	    int listSize = elementList.size();		//Counter of elements on a html list via cssSelector
		String[] elements = new String[listSize];
		
		int i = 0;
		for (WebElement li : elementList) {
			elements[i] = li.getText();
			System.out.print(elements[i]+"\n");
			i++;
			}
		return elements;
	}
	
	static void export2Excel(String[] x) throws IOException {
		try (
				FileInputStream fis = new FileInputStream(new File("/Users/noheliaborjas/Documents/QA/TestData.xlsx"))) {
				wbE = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		XSSFSheet sheetE = wbE.getSheetAt(2);
		
		int rowNum = x.length;		//Initializing FIRST row number to export
		int colNum = 0;		//Initializing FIRST column to export 
		String[] data = x;
		
		
		for (int i = 0; i < rowNum; i++) {			//moving through rows on column to export
			Row row = sheetE.createRow(i);
			Cell cell = row.createCell(colNum);
			cell.setCellValue(data[i]);
		}
		
		FileOutputStream fos = new FileOutputStream(new File("/Users/noheliaborjas/Documents/QA/TestData.xlsx"));	//Select File to stream the output data
		wbE.write(fos);
		wbE.close();
		System.out.println("Done.");
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ImportWebDataToExcel obj = new ImportWebDataToExcel();
		try {
			obj.export2Excel(webImport());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
