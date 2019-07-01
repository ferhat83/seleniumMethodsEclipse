package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAlertHandle {
      WebDriver driver = null;
	   @BeforeMethod
	   public void setUp() {
    	  System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\saadi\\\\eclipse-workspace\\\\seleniumAutomation\\\\SeleniumPractice\\\\driver\\\\chromeDriver\\\\chromedriver.exe");
    	  driver = new ChromeDriver();
    	  driver.get("  https://mail.rediff.com/cgi-bin/login.cgi");//navigate to that url.
    	  driver.manage().window().maximize();
    	  driver.manage().deleteAllCookies();
    	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	   
	   @Test
	   public void popUpAlert() {
		   
		   driver.findElement(By.name("proceed")).click();
		   //create alert object from selenium class
		   Alert alert = driver.switchTo().alert();
		   System.out.println(alert.getText());//get alert text and print it.
		   String alertText = alert.getText();// stock text in alertText String variable 
		   //check alert text
		   if(alertText.equals("Please enter a valid user name")) {
			   System.out.println("correct alert messag");
			   }
		       else {System.out.println("incorrect alert messag");
		   }
		   
		   
		   alert.accept();// click on OK
		   //alert.dismiss();// if there is a cancel button 
	   }
	   @AfterMethod
	   public void cleanUp() {
		   driver.close();
		   driver.quit();
	   }
}
