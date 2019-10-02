package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUpDownJavaScript {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		JavascriptExecutor js = ((JavascriptExecutor)driver);

		      //1.scroll down by pixel
		//js.executeScript("window.scrollBy(0,2000)");

		      //2. scrolling page till we find the element
		//WebElement flag = driver.findElement(By.xpath("//img[@alt='Flag of United States of America']"));
		//js.executeScript("arguments[0].scrollIntoView();", flag);

		      //3.Scroll page till bottom 
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

}
