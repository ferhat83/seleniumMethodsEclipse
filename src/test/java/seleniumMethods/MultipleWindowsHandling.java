package seleniumMethods;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsHandling {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp()  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
		
		driver.get("http://demo.automationtesting.in/Windows.html");
	}
		@Test
		public void windows() throws InterruptedException {
		System.out.println("the parent window title is: " + driver.getTitle());
		driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();
		
		Thread.sleep(5000);
		
		   //1- multiple windows handling using ITERATOR:
//		          
//		Set<String> windowsIds = driver.getWindowHandles(); // return type of getWindowHandles is set
//		
//		Iterator<String> itr = windowsIds.iterator(); // iterate the set with itr
//		 
//		String mainWindow = itr.next();//get window id
//		String childWindow = itr.next();//get window id
//		
//		driver.switchTo().window(childWindow);
//		System.out.println("the child window title is: "+ driver.getTitle());
//		    
		  //2- multiple windows handling using for each loop:
		for(String windowHandle : driver.getWindowHandles()){
			driver.switchTo().window(windowHandle);
			}
		System.out.println("the child window title is: "+ driver.getTitle());
		
	}
		@AfterMethod
		public void cleanUp() {
			driver.quit();
		}

}
