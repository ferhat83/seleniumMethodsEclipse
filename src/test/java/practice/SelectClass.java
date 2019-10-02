package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectClass {
	public WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(23, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	@Test
	public void selectMethod() {
		WebElement years = driver.findElement(By.cssSelector("select[id='yearbox']"));
		WebElement months = driver.findElement(By.cssSelector("select[placeholder='Month']"));
		WebElement days = driver.findElement(By.cssSelector("select[id='daybox']"));
		
		Select select1 = new Select(years);
		select1.selectByVisibleText("1940");
		
		Select select2 = new Select(months);
		select2.selectByVisibleText("October");
		
		Select select3 = new Select(days);
		select3.selectByVisibleText("10");
		
	}
	@AfterMethod
	public void cleanUp() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
	
	

}
