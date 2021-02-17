package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestElementLocatorTechniques {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser(String url) {
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
	
	public void elementLocatorTechniques1() {
		
		try {
			invokeBrowser("https://es.wikipedia.org/wiki/Wikipedia:Portada");
			driver.findElement(By.id("searchInput")).sendKeys("Menorca");	//Find element by ID technique
			driver.findElement(By.id("searchButton")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("mar Mediterráneo")).click();	//Find element by linkText technique
			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("Mallorca")).click();		//Find element by partialLinkText technique
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void elementLocatorTechniques2() {
			
			try {
				invokeBrowser("https://www.amazon.com");
				driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Iphone 12");	//Find element by cssSelector technique
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input")).click();	//Find element by xpath technique
				Thread.sleep(2000);
				jse = (JavascriptExecutor)driver;	//scrolldown Execution
				jse.executeScript("scroll(0,100)");	//Scrolldown 1000 pixels
				driver.findElement(By.xpath("//*[contains(@img,'AC?UY218']")).click();		//Find element by xpath technique
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestElementLocatorTechniques obj = new TestElementLocatorTechniques();
		obj.elementLocatorTechniques2();

	}

}
