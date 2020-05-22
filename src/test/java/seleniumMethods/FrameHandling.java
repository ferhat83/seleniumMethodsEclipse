package seleniumMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameHandling {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
  	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
  	  driver = new ChromeDriver();
  	  driver.get("https://www.toolsqa.com/iframe-practice-page/");//navigate to that url.
  	  driver.manage().window().maximize();
  	  driver.manage().deleteAllCookies();
  	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    } 
	@Test
	public void frameHandle() throws InterruptedException {
		
		// find out iframes in page 
		List <WebElement> totalIframe = driver.findElements(By.tagName("iframe"));
		System.out.println("we have " + totalIframe.size() + " iframes in this page");
		for(WebElement frame : totalIframe ) {
			System.out.println(frame.getText());
		}
		 
		
		// switch to frame to be able to work on it
//		driver.switchTo().frame("iframe2");
//		Thread.sleep(2000);
//		
//		String text = driver.findElement(By.className("widget-title")).getText();
//		System.out.println("the text1 we got is "+text);
//		
//	    String text2 = driver.findElement(By.xpath("//a[contains(text(),'Droppable')]")).getText();
//	    System.out.println("the text2 we got is "+text2);
	}
	
	//NB: to switch back to page after done with frame => driver.switchTo().defaultContent()
    
	@AfterMethod
	public void cleanUp() {
		driver.close();
		driver.quit();
    }


}
