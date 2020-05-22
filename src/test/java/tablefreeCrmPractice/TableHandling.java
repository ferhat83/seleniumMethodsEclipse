package tablefreeCrmPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TableHandling {
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.get("https://ui.cogmento.com/");
	}
	@Test(enabled = false)
	public void rowColomnHandling() {
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("saadiferhatsaid@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("Palah2004");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		
	    WebElement ele1 = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
		visibilityWait(driver, ele1, 40, "nacer hadj");
		System.out.println(ele1.getText());
		
	}
	@Test(enabled = true)
	public void tableHandling() {
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("saadiferhatsaid@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("Palah2004");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		
		   
		// to handl table you need to split our expath to beforeXpath and afterXpath
		   //xpath ex is:      //table//tr[2]//td[2]
		String beforeXpath = "//table//tr[";
		String afterXoath = "]//td[2]";
		
		WebElement ele1 = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
		visibilityWait(driver, ele1, 20, "youcef harg");
		
		for(int i = 1; i<=4 ;  i++) {
			String names = driver.findElement(By.xpath(beforeXpath+i+afterXoath)).getText();
			System.out.println(names);
			if(names.contains("youcef harg")) {
				driver.findElement(By.xpath(beforeXpath+i+"]//td[1]")).click();
				
			}
		}
		
	}
	
	//@AfterMethod
	public void cleanUp() {
		driver.close();
		
	}
	 //explicitly wait method
	public static void visibilityWait(WebDriver driver, WebElement element, int timeOut, String text) {
		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(element, text));
		
	}
	
	

}
