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

public class DynamiqueXpath {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test(enabled = true)
	public void dynamicXpath() {
		driver.findElement(By.xpath("//input[contains(@name,'q')]")).sendKeys("foot");
		List<WebElement> searchList = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		System.out.println("search list have "+searchList.size()+" elements");
		for(int i =0; i<searchList.size(); i++) {
			String elements = searchList.get(i).getText();
			System.out.println(elements);
			if(elements.contains("football schedule")) {
				searchList.get(i).click();
			}
		}
	
	}
	@AfterMethod
	public void cleanUP() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
		
		
		
	
}
