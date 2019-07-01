package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClickHanButton {
    //A-declare WebDriver as global variable
 WebDriver driver = null;
 
 @BeforeMethod
	public void setUp() { 
		//B-set chrome path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		
		//C- instantiate the WebDrive
		driver= new ChromeDriver();
	          // delete cookies
		driver.manage().deleteAllCookies();
		
		//D- navigate to the web site
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	  	driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
	  	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
 @Test
 public void rightClickButton() {
	 WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one"));
	 Actions action = new Actions(driver);// action class object.
	 action.contextClick(rightClickButton).build().perform();
	 //click on copy after rightClick
	 WebElement copy = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
	 String copyText = copy.getText(); 
	 System.out.println(copyText);
	 copy.click();
	 
     //switch to popUp alert and accept to be able to close the page
	 driver.switchTo().alert().accept();
	
    }
 
@AfterMethod
 public void cleanUp() {
	 driver.close();
	 driver.quit();
    }

}
