package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElements {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com");
	}
	@Test(enabled =false)
	public void webElementsTest() {
		WebElement motors = driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']//a[text()='Motors']"));
		Actions act1 = new  Actions(driver);
		act1.moveToElement(motors).build().perform();
		
		List<WebElement> motorsList = driver.findElements(By.xpath("//span[text()='Vehicles']/parent::div //a[@class='hl-cat-nav__js-link']"));
		System.out.println("motor list count : " +motorsList.size());
		
		for(WebElement list : motorsList) {
		   if(list.getText().contains("Motorcycles")) {
			   list.click();
			   break;
		   }	
		}
		
	}
	@Test(enabled = false)
	public void search() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("shoes");
		
		List<WebElement> searchList = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		System.out.println("search list size is : "+searchList.size());
		
		for(WebElement element :searchList ) {
		    System.out.println(element.getText());	
			if(element.getText().equalsIgnoreCase("shoes nike")) {
				element.click();
				break;
			}
		}
			
	}
	@Test(enabled = true)
	public void aboutEbay() {
		List<WebElement> aboutList = driver.findElements(By.xpath("//div[@id='gf-BIG']//tr//td[4]//li"));
		System.out.println("our list have "+aboutList.size()+" elements");
		for(int i=0; i<aboutList.size(); i++) {
			System.out.println(aboutList.get(i).getText());
			if(aboutList.get(i).getText().equalsIgnoreCase("News")) {
				aboutList.get(i).click();
			}
		}
	}
	@AfterMethod
	public void cleanUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
