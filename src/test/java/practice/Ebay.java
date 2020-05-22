package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ebay {
	
	WebDriver driver = null;
			
	@BeforeMethod 
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
	}
	//@Test(priority = 2)
	public void search() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		WebElement searchClick = driver.findElement(By.id("gh-btn"));
		search.sendKeys("phones");
		searchClick.click();
		Thread.sleep(3000);
		WebElement ebayLOgo = driver.findElement(By.xpath("//img[@id='gh-logo']"));
		WebElement unlockedPhones = driver.findElement(By.xpath("//a[@_sp='p2351460.m4117.l8280.c1']//span[contains(text(),'unlocked')][1]"));
	    if(ebayLOgo.isDisplayed()) {
	    	unlockedPhones.click();
	    }
	}
	//@Test(priority = 1)
	public void phonesList() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		WebElement searchClick = driver.findElement(By.id("gh-btn"));
		search.sendKeys("phones");
		searchClick.click();
		Thread.sleep(3000);
		WebElement ebayLOgo = driver.findElement(By.xpath("//img[@id='gh-logo']"));
		WebElement unlockedPhones = driver.findElement(By.xpath("//a[@_sp='p2351460.m4117.l8280.c1']//span[contains(text(),'unlocked')][1]"));
	    if(ebayLOgo.isDisplayed()) {
	    	unlockedPhones.click();
	    }
		List<WebElement> phonesList=driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']//li[@class='s-item   ']"));
		for(WebElement ph : phonesList) {
			String phone = ph.getText();
			System.out.println("****************: "+phone);
			if(ph.getText().equalsIgnoreCase("Apple iPhone 6")) {
				ph.click();
				Thread.sleep(3000);
				System.out.println("********************");
			}
		}
		
		
	}
	//@Test(priority = 3)
	public void lits() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		WebElement searchClick = driver.findElement(By.id("gh-btn"));
		search.sendKeys("phones");
		searchClick.click();
		Thread.sleep(3000);
		WebElement ebayLOgo = driver.findElement(By.xpath("//img[@id='gh-logo']"));
		WebElement unlockedPhones = driver.findElement(By.xpath("//a[@_sp='p2351460.m4117.l8280.c1']//span[contains(text(),'unlocked')][1]"));
	    if(ebayLOgo.isDisplayed()) {
	    	unlockedPhones.click();
	    }
		int size = 1;
		for(int i=0;i<size ;i++) {
			List<WebElement> phonesList=driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']//li[@class='s-item   ']"));
			size=phonesList.size();
			if(phonesList.get(i).getText().equalsIgnoreCase("Apple iPhone 6")) {
				
				phonesList.get(i).click();
			} 
			
		}
	}
	@Test
	public void bigTitle() throws InterruptedException {
		List<WebElement> bigt=driver.findElements(By.xpath("//div//ul[@class='hl-cat-nav__container']//li[@class='hl-cat-nav__js-tab']"));
		for(WebElement titles: bigt) {
			titles.click();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
		}
	}
	@AfterMethod
	public void cleanUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
