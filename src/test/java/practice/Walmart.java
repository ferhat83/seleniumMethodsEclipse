package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Walmart {
	WebDriver driver = null;
	@BeforeMethod 
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.walmart.com/");
		}
	@Test(enabled = true)
	public void humburgerButon() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='f_a ak_c f_c']")).click();
		
		Actions act1 = new Actions(driver);
		WebElement haloween = driver.findElement(By.xpath("//span[text()='Halloween']"));
		act1.moveToElement(haloween).build().perform();
		Thread.sleep(3000);
		
		List<WebElement> haloweenList = driver.findElements(By.xpath("//div[@id='dept-tjBZNglU-children']//a"));
		System.out.println("haloween list have " + haloweenList.size() + " elements:"); 
		for(WebElement haloween1 : haloweenList) {
			String haloweenListText = haloween1.getText();
			System.out.println(haloweenListText);
			if(haloweenListText.equalsIgnoreCase("Kids' Costumes")) {
				haloween1.click();
			}
		 }
		 
	}
	
	
	@AfterMethod(enabled =true)
	public void cleanUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
