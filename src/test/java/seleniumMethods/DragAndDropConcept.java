package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropConcept {
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
		driver.get("https://www.jqueryui.com/droppable/");
		driver.manage().window().maximize();
		}
	
	 @Test
	 public void dragAndDrop() {
		 
		 driver.switchTo().frame(0);// switch to the frame.
		 Actions action = new Actions(driver);
		 WebElement dragElement = driver.findElement(By.id("draggable"));
		 WebElement dropElement = driver.findElement(By.id("droppable"));
		  
		 // use action class to perform drag and drop.
		 action.clickAndHold(dragElement).moveToElement(dropElement).release().build().perform();
		 
		 
	 }
	 
	  @AfterMethod
		public void cleanUp() {
			driver.close();
			driver.quit();
		}
	 

}
