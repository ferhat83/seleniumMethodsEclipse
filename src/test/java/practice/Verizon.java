package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Verizon {
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.verizonwireless.com/");
		}
	@Test(enabled = false)
	public void scenario() throws InterruptedException {
		WebElement phones = driver.findElement(By.xpath("//button[text()='Phones list']"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(phones).build().perform();
		driver.findElement(By.xpath("//ul[@class='gnav-submenu-list']//a[@ id='thirdLevel00']")).click();
		
		System.out.println("step one passed");
		Thread.sleep(4000);
		
		     //phones list
		List<WebElement> phonesList = driver.findElements(By.xpath("//div[@class='tile-outer  displayFlex rowWrap']//div[@class='tile-content']"));
		System.out.println("phones list: "+phonesList.size());
		for(int i=0; i<phonesList.size(); i++) {
			String elements = phonesList.get(i).getText();
			System.out.println(elements);
			if(elements.contains("Galaxy Note10+ 5G")) {
				phonesList.get(i).click();
			}
		}
		System.out.println("step two passed");
		Thread.sleep(4000);
		     //color
		List<WebElement> radioButton = driver.findElements(By.xpath("//div[@class='flex width100p pad15 onlyBottomPad']//input[@name='colors']"));
		for(WebElement button : radioButton ) {
			String atributValue = button.getAttribute("value");
			if(atributValue.equalsIgnoreCase("atributValue")) {
				button.click();
			}
		}
		System.out.println("step three passed");
		     //storage
		driver.findElement(By.xpath("//div[contains(@class,'positionRelative border_grayThree inStock invalidItem')]//div[contains(@class,'sizePad')]")).click();
		System.out.println("step four passed");
		     //price
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='row noSideMargin width100p']//input[@name='pricing option']"));
		for(int i=1; i<=price.size(); i++) {
			String phonePrice = price.get(i).getAttribute("id");
			if(phonePrice.equalsIgnoreCase("phonePrice")) {
				price.get(i).click();
			}
		}
		
		System.out.println("step five passed");
		Thread.sleep(4000);
		
		String popUpWindow = driver.getWindowHandle();
		driver.switchTo().window(popUpWindow);
	    driver.findElement(By.id("zipcode")).sendKeys("07306");
		driver.findElement(By.xpath("//button[text()='Confirm Location']")).click();
		
		System.out.println("step six passed");
		
		}
	@Test(enabled = false)
	public void img() {
		WebElement img = driver.findElement(By.xpath("//div//h1"));
		System.out.println(img.getText());
	}
	@Test(enabled = false)
	public void search() throws InterruptedException {
		List<String> options = new ArrayList<String>();
		WebElement clicksearch = driver.findElement(By.xpath("//input[@id='navPhoneSearch']"));
		clicksearch.click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='lower-right']//ul//li//a"));
		for(WebElement element : list) {
			System.out.println(element.getText());
			String text = element.getText();
			options.add(text);
		}
		for(int i=0; i<options.size(); i++) {
			String locator = "//div[@class='lower-right']//ul//li//*[text()='"+options.get(i)+"']";
			driver.findElement(By.xpath(locator)).click();
			driver.navigate().back();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='navPhoneSearch']")).click();
			Thread.sleep(3000);
			
		}
	
	}
	@Test(enabled = false)
	public void plans() throws InterruptedException {
		List<String> plansOptions = new ArrayList<String>();
		WebElement plans = driver.findElement(By.xpath("//button[text()='Plans list']"));
		Actions act3 = new Actions(driver);
		act3.moveToElement(plans).build().perform();
		
		List<WebElement> plansList = driver.findElements(By.xpath("//div[@class='lower-right shiftMe displayBlock']//ul//li"));
		for(WebElement list2 : plansList) {
			System.out.println(list2.getText());
			String plansText = list2.getText();
			plansOptions.add(plansText);
			}
		for(int i=0; i<plansOptions.size(); i++) {
			String locator = "//div[@class='lower-right shiftMe displayBlock']//ul//li//*[text()='"+plansOptions.get(i)+"']";
			act3.moveToElement(driver.findElement(By.xpath("//button[text()='Plans list']"))).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath(locator)).click();
			driver.navigate().back();
				
		}
	}
	@Test(enabled = true)
	public void verizonNews() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='News']")).click();
		Thread.sleep(3000);	
		//category
		driver.findElement(By.xpath("//button[contains(@data-id,'news-categories')]")).click();
		List<WebElement> categorys = driver.findElements(By.xpath("//div[@class='form-type-select form-item-category-type form-item form-group']//li"));
		System.out.println(categorys.size());
		categorys.get(2).click();
		 
		//years
		driver.findElement(By.xpath("//span[text()='All Years']")).click();
		Thread.sleep(3000);
	    Actions act = new Actions (driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='All Years']"))).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
		driver.findElement(By.id("news-search")).click();
	    }
		
	
	
	@AfterMethod(enabled = true)
	public void cleanUP() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	

}
