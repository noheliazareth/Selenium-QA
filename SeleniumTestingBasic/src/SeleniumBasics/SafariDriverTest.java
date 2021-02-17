package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverTest {
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.safari.driver","safaridriver");
			driver = new SafariDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://astronomy.com/photos");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		SafariDriverTest myObj = new SafariDriverTest();
		myObj.invokeBrowser();
	}

}
