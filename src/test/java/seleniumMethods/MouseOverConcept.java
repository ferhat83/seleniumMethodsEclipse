package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOverConcept {
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
			driver.get("https://www.spicejet.com/");
			driver.manage().window().maximize();
			 
	 }
	 @Test
	 public void mouseMoveOver() throws InterruptedException {
		 // create object to action class witch is selenium class
		 Actions action = new Actions(driver);
		 WebElement addOns = driver.findElement(By.id("highlight-addons"));
	     
		 // use actions class to move the mouse over the the Add-ons section
		 action.moveToElement(addOns).build().perform();
		 //use thread to wait some time to display
		 Thread.sleep(3000);
		 //click on element
		 driver.findElement(By.linkText("Hot Meals")).click();
		  }
	
	 @AfterMethod
		public void cleanUp() {
			driver.close();
			driver.quit();
		}
	 

}
