package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementVisibilityTest {
	
	// isDsiplayed vs isEnable vs isSelected
	
	
	@Test
	public void elementVisibility() {
		String projectPath = System.getProperty("user.dir");// method to customize the path.
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\driver\\chromeDriver\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		//1- isDisplayed method(applicable for all elements)
		boolean b1 = driver.findElement(By.id("ppaFormSbtBtn")).isDisplayed();
		System.out.println(b1);//return true
		
		//2-isEnabled method 
		    //1-1 before you agree conditions (result is false)
		boolean b2 = driver.findElement(By.id("ppaFormSbtBtn")).isEnabled();
		System.out.println(b2);//return false (because you need to agree the conditions or fill up the form)
		    
		    //1-2 agree check box or filUp (result is true)
		    
		driver.findElement(By.id("firstname")).sendKeys("aaaaa");
		driver.findElement(By.id("lastname")).sendKeys("sssss");
		driver.findElement(By.id("email")).sendKeys("ferhat.saadi@live.fr");
		driver.findElement(By.id("PASSWORD")).sendKeys("sssssss1111");
	    
		boolean b3 =driver.findElement(By.id("ppaFormSbtBtn")).isEnabled();
		System.out.println(b3);//return true 
		
		//3- isSelected method(only used for checBox, dropDown, radiButton)
		   //3-1 checkBox is not selected
		boolean b4 =driver.findElement(By.className("checkbox__control")).isSelected();
		System.out.println(b4);//return false(checkBox is not selected) 
		   //3-2 checkBox selected
		driver.findElement(By.className("checkbox__control")).click();
		boolean b5 =driver.findElement(By.className("checkbox__control")).isSelected();
		System.out.println(b5);//return true
		
		driver.close();
		}

}
