package zimuSeleniumMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoopInIfStatment {
	
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.capitalone.com/");
	}
	@Test
	public void loopInIfStatment() throws InterruptedException {
		List<WebElement> products = driver.findElements(By.xpath("//div[@id='footer-products-section']/ul/li"));
//		List<String> text = new ArrayList<String>();
//		System.out.println(products.size());
		for(int i=0; i<products.size(); i++) {
			products.get(0).click();
	}
//		WebElement element = driver.findElement(By.xpath("//div[@id='footer-products-section']/ul/li[1]"));
//		Thread.sleep(3000);
//		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@id='footer-products-section']/ul/li"))).click().build().perform();
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", element);
//		for(WebElement productLiist : products ) {
//			//text.add(productLiist.getText()); 
//			//String elementText = productLiist.getText();
//			//System.out.println(elementText);
//			if(productLiist.getText().equalsIgnoreCase("Credit Cards")) {
//				productLiist.click();
//			}
//		}

	}
	//@AfterMethod
	public void cleanUp() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	

}
