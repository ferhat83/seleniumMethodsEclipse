package seleniumMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class RdioButton {
	@Test(enabled= true)
	public void radioButton() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("   http://demo.automationtesting.in/Register.html");
		   
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));// return list of radio button
		
		//use for loop to get the radioBotton values and click on them.
		for(int i=0;i<radioButtons.size();i++) {
			WebElement radioElement = radioButtons.get(i);// get values
			String radioValue = radioElement.getAttribute("value");// store the values in Strings
			System.out.println("the values of radionBottons are :"+radioValue);
			   // to click on all radioButtons
			//radioElement.click();
			   // click on a specific radioBatton
			if(radioValue.equalsIgnoreCase("Male")) {
				radioElement.click();
				
			} 
			
			
			}
		
		
		
	}
}
