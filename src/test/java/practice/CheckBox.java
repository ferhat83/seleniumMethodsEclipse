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

public class CheckBox {
	
  WebDriver driver = null;
	
	@BeforeMethod
	   public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		}
	@Test  
	public void checkBox() { 
		List<WebElement> webCHeckBox = driver.findElements(By.xpath("//input[@type = 'radio']"));
		for(WebElement element : webCHeckBox) {
			String checkBoxValue = element.getAttribute("value");
			System.out.println("check box values are : " + checkBoxValue);
		    if(checkBoxValue.equalsIgnoreCase("Male")) {
				element.click();
			}
		}
	}  
	@AfterMethod
	public void cleanUp() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
 