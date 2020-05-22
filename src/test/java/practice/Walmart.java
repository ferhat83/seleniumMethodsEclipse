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

public class Walmart {
	WebDriver driver = null;
	@BeforeMethod 
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(" ");
		}

	@Test(enabled = true)
	public void listElements() { 
	 List<WebElement> tempCategoriTitle = driver.findElements(By.xpath("//div[@id='HomePage-contentZone12-FeaturedCategoriesCollapsible-expander']//div[@class='TempoCategoryTile-tile valign-top']"));
	 for(WebElement TitlesList : tempCategoriTitle ) {
		 
		 TitlesList.click();
		 
	 }
	}
	
	
	@AfterMethod(enabled =true)
	public void cleanUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
