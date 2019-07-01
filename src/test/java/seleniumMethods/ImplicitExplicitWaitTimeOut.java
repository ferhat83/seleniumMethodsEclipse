package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitExplicitWaitTimeOut {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\saadi\\\\eclipse-workspace\\\\seleniumAutomation\\\\SeleniumPractice\\\\driver\\\\chromeDriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.half.ebay.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//it is recommended to start all the previous methods and add dynamic wait
		
	//1- dynamic wait(if the page or element is loaded before the time set, selenium will ignore the rest of the time)
		 	
		//A- page load time out method(applicable to load the page):
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		//B- implicitly wait method ( applicable to global page element)
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		//C- explicitly wait( applicable for specific elements(wait for specific element),long time wait)
		    // we use the generic method explicitlyWait we have down
		   explicitlyWait(driver,driver.findElement(By.id("gh-btn")), 10); 
		   driver.close();
		    //if you don't apply explicitly wait when needed you will get time out error with expected condition failed
	         
   
   //2- static wait time:( even if the page is loaded, selenium will wait the all set time).
		 
		Thread.sleep(3000);
		 
		 //-important: when you don't use dynamic or static wait errors given is TIME OUT.
	}
	
	    //C-generic Explicitly wait method(for clickable elements)
	public static void explicitlyWait(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
   	    locator.click();
    }

}
