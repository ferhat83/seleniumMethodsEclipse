package seleniumMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetHtmlTags {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.ebay.com/");
		// all the links are represented by <a> tag in HTML
		List<WebElement> linklist = driver.findElements(By.tagName("a"));

		//get the size of the linklist
		System.out.println(linklist.size());
 
		for(int i=0; i<linklist.size();i++) {
		System.out.println(linklist.get(i).getText());
		}

		//List<WebElement> buttonList = driver.findElements(By.tagName("button"));
		//System.out.println(buttonList.size());

		//for(int i =0;i<buttonList.size();i++) {
//			System.out.println(buttonList.get(i).getText());
		//}

	}

}
