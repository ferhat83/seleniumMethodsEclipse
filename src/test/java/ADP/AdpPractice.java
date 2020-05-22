package ADP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdpPractice {
	WebDriver driver= null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.adp.com/");
	}
	@Test(enabled = true)
	public void resources() {
		WebElement res = driver.findElement(By.xpath("//div[@class='col-xs-6 col-sm-2']//a[text()='Resources']"));
		String text1 = res.getText();
		System.out.println("the text we got is "+text1);
		res.click();
		
	}

}
