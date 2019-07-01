package seleniumMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BackAndForwardSimulation {
	@Test
	public void navigation() throws InterruptedException{
		String projectPath = System.getProperty("user.dir");// method to customize the path.
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\driver\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.navigate().to("http://www.amazon.com");
		
		// back and forward button simulation
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.close();
		 
		// refresh button 
		driver.navigate().refresh();
		
		
		
		// get vs navigate:
		// get used to launch url, navigate used to launch external url.
	}
}
