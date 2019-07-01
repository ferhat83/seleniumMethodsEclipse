package seleniumMethods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PopUpWindowHandling {
	@Test
	public void popUpWindow() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");// method to customize the path.
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\driver\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.className("black")).click();
		
		// get the windows using getWindowHandles method and stock it on Set(unordered collection of element(ex: window))
		Set<String> handler = driver.getWindowHandles();
		
		//use iterator to iterate that Set(handler). we can't use loop because Set is unordered collection(no index)
		Iterator<String> iterat1 = handler.iterator();
		//get parent window id
		String parentWindowId = iterat1.next();
		System.out.println("parent window id is: " + parentWindowId);
		//get child window id
		String chilWindowId = iterat1.next();
		System.out.println("child window id is: " + chilWindowId);
		// switch to child window
		driver.switchTo().window(chilWindowId); 
		//get title of child window and close it
		System.out.println("child window title: " + driver.getTitle());
		driver.close();
		//switch back to parent window and get title 
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window title: " + driver.getTitle());
		
		Thread.sleep(3000);
		driver.close();
	}

}
