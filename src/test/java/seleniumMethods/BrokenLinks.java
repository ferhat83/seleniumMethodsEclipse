package seleniumMethods;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinks {
	WebDriver driver = null;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.express-scripts.com/");
	}
	@Test
	public void brokenLinkTest() throws MalformedURLException, IOException { 
		//get links
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("The number of the links and Images is : "+linksList.size());
		
		// select active links (Attribute "href" represent active links)
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for(int i = 0;i<linksList.size();i++) {
		if(linksList.get(i).getAttribute("href")!= null) {
		activeLinks.add(linksList.get(i));
		 }
		}
		System.out.println("The nubmer of active links is : " +activeLinks.size());
		
		//test active links
		for(int j=0;j<activeLinks.size();j++) {
		HttpURLConnection connection = (HttpURLConnection) new URL (activeLinks.get(j).getAttribute("href")).openConnection(); 
		String response = connection.getResponseMessage();
		connection.disconnect();
		System.out.println(activeLinks.get(j).getAttribute("href")+" ---------> " + response);
		 }
		}


    @AfterMethod
    public void cleanUp() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.close();
        }	
    }

