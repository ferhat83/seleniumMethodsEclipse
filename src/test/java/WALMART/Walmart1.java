package WALMART;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Walmart1 {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.walmart.com/");
	}
	@Test(enabled = false)
	public void test1() throws InterruptedException {
		
	WebElement searchBar= driver.findElement(By.xpath("//input[@class='h_a a5_b header-GlobalSearch-input mweb-Typeahead-input h_b']"));
	if(searchBar.isDisplayed()) {
	searchBar.sendKeys("soccer shoes");
	searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		}
	}
	@Test(enabled = true)
	public void test2 () {
		driver.findElement(By.xpath("//button[@class='f_a al_c f_c']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//div//div[@data-tl-id='header-top-links']//a[@class='i_a']"));
		for(int i=0; i<elements.size(); i++) {
			String str1 = elements.get(i).getText();
			System.out.println(str1);
			if(str1.contains("Walmart Credit Card")) {
				elements.get(i).click();
			}
		}
		
	}
	
	@AfterMethod
	public void cleanUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
