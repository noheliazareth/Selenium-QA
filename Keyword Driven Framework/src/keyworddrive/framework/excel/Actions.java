package keyworddrive.framework.excel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Actions {
	
	static WebDriver driver;
	JavascriptExecutor jse;
	
	public static void invokeBrowser() {
		try {
			System.setProperty("webdriver.safari.driver", "safaridriver");
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void enterURL(String URL){
		driver.get(URL);
	}
	
	public static void sendKeys(String keys, String locator) {
		try {
			driver.findElement(By.id(locator)).sendKeys(keys);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clickOn(String locator) {
		try {
			driver.findElement(By.className(locator)).click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void quit() {
		driver.close();
	}

}
