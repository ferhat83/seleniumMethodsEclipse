package seleniumMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenshotHandling {
	@Test
	public void takeScreenshot() throws IOException {
		String projectPath = System.getProperty("user.dir");// method to customize the path.
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\driver\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.google.com");
		
		//take screenshot method (we use TakesScreenshot interface):
		    //*you need to add Apache commons io dependency to you project before you use that interface
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// save the file in desired location:
		FileUtils.copyFile(src, new File("C:\\Users\\saadi\\Desktop\\Screenshot\\google.png"));
		
		// NB:at the end of the path you need to add name to that file ex: \\google.png
		driver.close();
		
	}

}
