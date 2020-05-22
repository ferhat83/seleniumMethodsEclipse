package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CapitalOne2 {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.capitalone.com/"); 
		
		
	}
	@Test
	public void signIn() {
		WebElement capitalOneLogo = driver.findElement(By.xpath("//a[@id='unav-l1-logo']"));
		WebElement userName = driver.findElement(By.xpath("//input[@id='noAcctUid']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id='noAcctPw']"));
		WebElement logInButton = driver.findElement(By.xpath("//button[contains(@id,'noAcctSubmit')]"));
		if(capitalOneLogo.isDisplayed()) {
			userName.sendKeys("ferhat");
			passWord.sendKeys("na3misa3");
			logInButton.click();
			 
		}
		
		
	}
	@AfterMethod
	public void cleaUp() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		
		
		
	}
	

}
