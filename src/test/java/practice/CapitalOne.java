package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CapitalOne {
	WebDriver driver = null;
	
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.capitalone.com/");
	}
	@Test(enabled = false, priority = 1)
	public void signIn() {
		String actualTitle = driver.getTitle();
		System.out.println("the title that we have got is : "+actualTitle);
		String expectedTitle = "Capital One Credit Cards, Bank, and Loans - Personal and Business";
		System.out.println("the expected title is : "+expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.findElement(By.xpath("//input[contains(@id,'no-acct-uid')]")).sendKeys("ferhatssss");
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("abcdefg");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
	@Test(enabled = true, priority = 2)
	public void creditCard() {
		WebElement creditCard = driver.findElement(By.xpath("//a[@id = 'card']//span[text()='Credit Cards']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(creditCard).click().build().perform();
	   
	}
	
	@AfterMethod
	public void cleanUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
	}
	public static void clickON(WebDriver driver, WebElement locator, int timeOut) {
		new WebDriverWait (driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
	}

}
