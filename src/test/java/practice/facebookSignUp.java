package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class facebookSignUp {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://en-gb.facebook.com/r.php?locale=en_GB");
		
	}
	
	@Test
	public void signUp() { 
		driver.findElement(By.name("firstname")).sendKeys("zzzz");
		driver.findElement(By.name("lastname")).sendKeys("lllll");
		driver.findElement(By.name("reg_email__")).sendKeys("2012389697");
		driver.findElement(By.name("reg_passwd__")).sendKeys("xxxxxxx09x0");
		
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		WebElement month =driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		Select sel1 = new Select(day);
		Select sel2 = new Select(month);
		Select sel3 = new Select(year);
		
		sel1.selectByVisibleText("10");
		sel2.selectByVisibleText("Oct");
		sel3.selectByVisibleText("1940");
		
		List<WebElement> gender = driver.findElements(By.xpath("//span//input[@type='radio']"));
		for(WebElement genderChois : gender) {
			if(genderChois.getAttribute("value").equalsIgnoreCase("2")) {
				
				genderChois.click();
			}
		}
		
		driver.findElement(By.name("websubmit")).click();
		
	}
	@AfterMethod(enabled = true)
	public void cleanUp() {
		driver.close(); 
		driver.quit();
	}
	

}
