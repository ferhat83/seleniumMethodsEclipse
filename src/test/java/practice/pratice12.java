package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class pratice12 {
	WebDriver driver= null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice+Java\\driver\\chromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	@Test(enabled = false)
	public void facebookLogInPage() {
		String  ExistingLogInPageTitle ="Facebook - Log In or Sign Up";
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(ExistingLogInPageTitle, title);
		
		WebElement emailInPut = driver.findElement(By.cssSelector("input[id='email']"));
		WebElement pwInPut = driver.findElement(By.cssSelector("input[id='pass']"));
		WebElement logInButton = driver.findElement(By.cssSelector("label[id='loginbutton']"));
		
		
		emailInPut.sendKeys("xxxxx");
		pwInPut.sendKeys("jjjjj");
		logInButton.click();
		
		WebElement errorLogIn = driver.findElement(By.cssSelector("div[id='error_box']"));
		errorLogIn.getText();
		System.out.println(errorLogIn.getText());
	}
	@Test(enabled = true)
	public void signIn() {
		WebElement firstN = driver.findElement(By.cssSelector("input[name='firstname']"));
		WebElement lastN = driver.findElement(By.cssSelector("input[name='lastname']"));
		WebElement emailPhone =driver.findElement(By.cssSelector("input[name='reg_email__']"));
		WebElement passW = driver.findElement(By.cssSelector("input[name='reg_passwd__']"));
		
		firstN.sendKeys("ferrrr");
		lastN.sendKeys("saaaa");
		emailPhone.sendKeys("2012224444");
		
		
		
		WebElement month =driver.findElement(By.xpath("//select[@id='month']"));
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("Aug");
		
		Select selectDay = new Select(day);
		selectDay.selectByVisibleText("1");
		
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText("1944");
		
		
		List<WebElement> radioButton= driver.findElements(By.xpath("//span[@class='_5k_3']/span"));
		for(WebElement radio : radioButton) {
			String radioText = radio.getText();
			System.out.println("*********  " + radioText);
			if (radioText.equalsIgnoreCase("Female")) {
				radio.click();
			}
		}
		
	}

}
