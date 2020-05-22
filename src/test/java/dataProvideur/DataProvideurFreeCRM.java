package dataProvideur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelUtility.GetTestDataFromXl;

public class DataProvideurFreeCRM {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice+Java\\driver\\chromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();


	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	driver.get("https://freecrm.com/");

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
	ArrayList<Object[]> testData =  GetTestDataFromXl.getExcelData();
	return testData.iterator(); // used to iterate all the test data available in the excel sheet by order
	}


	//@Test
	public void createNewContactFreeCRMTest() throws InterruptedException {
	createNewContactFreeCRM("youuu", "HArggg", "Virtusa", "Lead");
	}


	@Test(dataProvider="getTestData", priority=1)
	public void createNewContactFreeCRM(String firstName, String lastName, String company, String category) throws InterruptedException {
	driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click(); //login button
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hargasyoucef@gmail.com"); // username
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("17031991You"); // password
	driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click(); // login button2
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click(); // contacts button
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(@href,'/contacts/new')]")).click(); // new contact
	Thread.sleep(3000);

	// fill up the info
	driver.findElement(By.name("first_name")).sendKeys(firstName);  // first name
	driver.findElement(By.name("last_name")).sendKeys(lastName); // last name
	driver.findElement(By.xpath("//div[@name='company']//input[@type='text']")).sendKeys(company); // company field
	driver.findElement(By.xpath("//div[@name='category']")).click();  // click on category field
	driver.findElement(By.xpath("//span[contains(text(),'" + category + "')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click(); // save button
	}

	@AfterMethod
	public void closeUp() {
	driver.quit();
	}

}
