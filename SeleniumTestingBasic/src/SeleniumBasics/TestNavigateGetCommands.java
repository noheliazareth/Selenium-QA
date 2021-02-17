package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestNavigateGetCommands {
	
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
	
	public void navigateCommands() {
		
		try {
			driver.navigate().to("https://www.apple.com");
			driver.findElement(By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[4]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ac-gn-link-search\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"ac-gn-searchform-input\"]")).sendKeys("iWatch");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("button#ac-gn-searchform-submit")).click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getCommands() {
		driver.get("https://www.amazon.com");
		String titleofThePage = driver.getTitle();
		System.out.println("The title of the page is: " + titleofThePage);
		String currentURL = driver.getCurrentUrl();
		System.out.println("The Current URL is: " + currentURL);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Michio Kaku Books");
		driver.findElement(By.id("nav-search-submit-text")).click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		TestNavigateGetCommands myObj = new TestNavigateGetCommands();
		myObj.invokeBrowser("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		myObj.navigateCommands();
		//myObj.getCommands();
		
	}

}
