package practiceTanmaysarkar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample1 {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://demo.tanmaysarkar.com/sample_01.html"); 
		
	}
	@Test(dataProvider = "sample1Data")
	public void sample1(String firstName, String lastName, String adress, String country, String gender) {
		 driver.findElement(By.xpath("//input[@id='ts_first_name']")).sendKeys(firstName);
		 driver.findElement(By.xpath("//input[@id='ts_last_name']")).sendKeys(lastName);
		 driver.findElement(By.xpath("//textarea[@id='ts_address']")).sendKeys(adress);
		 
		 WebElement nationality = driver.findElement(By.id("ts_country"));
		 
		 Select sel1 = new Select(nationality);
		 List<WebElement> nations = sel1.getOptions();
		 System.out.println(nations.size());  
		 for(WebElement listNations : nations) {
			 System.out.println(listNations.getText());
		 } 
		 sel1.selectByVisibleText(country);
		 
		 List<WebElement> radio = driver.findElements(By.xpath("//label//input[@type='radio']"));
		 System.out.println(radio.size());
		 for(WebElement radioButton : radio) {
			 System.out.println(radioButton.getAttribute("value"));
			 if(radioButton.getAttribute("value").equalsIgnoreCase(gender)){
				 
				 radioButton.click();
			 }
		 }
		 List<WebElement> check = driver.findElements(By.xpath("//tr//td//input[@type='checkbox']"));
		 for(WebElement checkBox : check) {
			 System.out.println(checkBox.getAttribute("id"));
			 if(checkBox.getAttribute("id").equalsIgnoreCase("ts_checkbox2")) {
				 checkBox.click();
			 }
		 }
		 driver.findElement(By.xpath("//input[@name='Submit1']")).click();
		
		 
		
	}
	@DataProvider(name ="sample1Data")
	public static Object [][] getdata() {
		Object[][] data = new Object[1][5];
		data[0][0]= "messi";
		data[0][1]= "leo";
		data[0][2]="3020 west side ave jersey city, NJ 07306";
		data[0][3]="America";
		data[0][4]="Male";
		
		
		return(data);
	}
	@AfterMethod 
	public void cleanUp() {
		driver.close();
	}

}
