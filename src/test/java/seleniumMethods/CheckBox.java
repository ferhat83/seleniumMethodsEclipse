package seleniumMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBox {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		} 
		
	@Test(enabled = true)
	public void checkBoxSelection() throws InterruptedException {
		// create list of webElement 
		List<WebElement> checkBoxButtons = driver.findElements(By.xpath("//input[@type='checkbox']"));
		//use for each loop
		for(WebElement buttons : checkBoxButtons) {
			String value = buttons.getAttribute("value");
			      //it will check all the check box:
			//buttons.click();
			System.out.println("chechBox bottons value is :" +value);
			
			      //check specific box:
			if(value.equalsIgnoreCase("Hockey")) {
				buttons.click();
			   }
			}
		Thread.sleep(2000);
		driver.close();
		}

}
