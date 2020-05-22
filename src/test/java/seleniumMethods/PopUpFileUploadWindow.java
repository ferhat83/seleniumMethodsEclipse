package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpFileUploadWindow {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
  	  System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\saadi\\\\eclipse-workspace\\\\seleniumAutomation\\\\SeleniumPractice\\\\driver\\\\chromeDriver\\\\chromedriver.exe");
  	  driver = new ChromeDriver();
  	  driver.get("https://html.com/input-type-file/");//navigate to that url.
  	  driver.manage().window().maximize();
  	  driver.manage().deleteAllCookies();
  	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	@Test
	public void upLoadFilePopUp() {
		// upLoad file we use sendKeys using the path of the doc we want to upLoad
		//we should see:(type ="file") when we inspect the page(in that specific locator) 
		driver.findElement(By.id("fileupload")).sendKeys("D:\\testing\\PNT");

    }
	@AfterMethod
	public void cleanUp() {
		driver.close();
		driver.quit();
    }

	
}
