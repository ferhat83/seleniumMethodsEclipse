package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressEvent {
	@Test
	public void useKeyBoard() {
		
		String projectPath = System.getProperty("user.dir");// method to customize the path.
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\driver\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/key_presses");
		driver.manage().window().maximize();
		   
		//KeyPressEvent we have 2 options
		  // option1: use send keys method
		driver.findElement(By.id("target")).sendKeys(Keys.BACK_SPACE);
		String text = driver.findElement(By.id("result")).getText();
		System.out.println(text);
		Assert.assertEquals(text,"You entered: BACK_SPACE");
		  
		
		  // option2: use Action class:
		Actions action = new Actions(driver);
		driver.findElement(By.id("target")).click();
		action.sendKeys(Keys.SPACE).build().perform();
		String resultText = driver.findElement(By.id("result")).getText();
		System.out.println(resultText);
		Assert.assertEquals(resultText,"You entered: SPACE");
		driver.close();
		
	 } 
	

}
