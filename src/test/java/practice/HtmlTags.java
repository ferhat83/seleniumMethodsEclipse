package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HtmlTags {
	public WebDriver driver = null;
	@BeforeMethod
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	    driver.get("http://demo.automationtesting.in/Register.html"); 
	    }
	@Test
	public void htmlTags() {
		List<WebElement> links = driver.findElements(By.tagName("link"));
		System.out.println("we have " + links.size() + " links tags in this page");
		
		List<WebElement> image = driver.findElements(By.tagName("img"));
		System.out.println("we have " + image.size() + " img tags in this page");
		
		List<WebElement> title = driver.findElements(By.tagName("title")); 
		System.out.println("we have " + title.size() + " title tags in this page");
		
		List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
		System.out.println("we have " + iframe.size() + "iframe tags in this page");
		 
		List<WebElement> button = driver.findElements(By.tagName("button"));
		System.out.println("we have "+ button.size()+" button tags in this page");
	}
	@AfterMethod
	public void cleanUp() {
		driver.close();
		driver.quit();
	}

}
