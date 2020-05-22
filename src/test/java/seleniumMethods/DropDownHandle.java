
package seleniumMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownHandle {

	    //A-declare WebDriver as global variable
	static WebDriver driver =null;
	
	@BeforeMethod
	public void setUp() {
		//B-set chrome path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		 
		//C- instantiate the WebDrive
		driver= new ChromeDriver();
		
		//D- navigate to the web site
		driver.get("https://www.facebook.com/"); 
		}
	//@Test
	public void dropDown() {
		WebElement month = driver.findElement(By.id("month"));
		WebElement day = driver.findElement(By.id("day"));
		WebElement year = driver.findElement(By.id("year")); 
		
		      // 1st way using selectByVisibleText 
//      Select select1 = new Select(month);
//      select1.selectByVisibleText("Oct");
//
//      Select select2 = new Select(day);
//      select2.selectByVisibleText("10");
//
//      Select select3 = new Select(year);
//      select3.selectByVisibleText("1940");
		
		  
		      // 2nd way using selectByVisibleText and selectValueFromDropDown method
		
//	    selectValueFromDropDown(month, "Oct");
//		selectValueFromDropDown(day, "10");
//		selectValueFromDropDown(year, "1940");
		
		      // 3rd way using selectByVisibleText and split function with select class
		String DOB = "Oct-10-1940";
		String dobArray [] = DOB.split("-");
		
		selectValueFromDropDown(month, dobArray[0]);
		selectValueFromDropDown(day, dobArray[1]);
		selectValueFromDropDown(year, dobArray[2]);
	}
	public static void selectValueFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	//@Test
	          // 4th way using select.getOptions
	public void selectUsingGetOptions() {
	    WebElement month = driver.findElement(By.id("month"));
	    WebElement day = driver.findElement(By.id("day"));
	    WebElement year = driver.findElement(By.id("year")); 
	    
	    Select select1 = new Select(month);
	    List<WebElement> monthsList = select1.getOptions();
	    System.out.println(monthsList.size()); // we get the size of months list
	    for (int i=0; i<monthsList.size(); i++) {// we get months list and print it(you can do same with days&years)
	    	String monthVal = monthsList.get(i).getText();
	    	System.out.println(monthVal);
	    	  // select a value from that list using getOptions
	    	if(monthVal.equals("Feb")) {
	    		monthsList.get(i).click();
	    		break;
	    	} 	 
	    }
	     Select select2 = new Select(day);
	    List<WebElement> daysList = select2.getOptions();
	    System.out.println(daysList.size()); // we get the size of days list with word day (32 in that list )
	    int ListOfDays = daysList.size()-1;
	    System.out.println(ListOfDays);  // we get just the list of days(31 in that list)
	    
	    
	    Select select3 = new Select(year);
	    List<WebElement> yearsList = select3.getOptions();
	    System.out.println(yearsList.size());  // we get the size of years list
	}
	
   //  @Test
	
	                 // other way to use drop down(ex:month) without using select class or get method
     
     
	public void DropDown() {
		  
		       // this method will give me number of elements in month drop down.
		    List<WebElement> monthList = driver.findElements(By.xpath("//select[@id='month']//option"));
		    System.out.println(monthList.size());
		     
		       // this method will print all of the previous elements
		     for (int i=0; i<monthList.size();i++) {
		    	 System.out.println(monthList.get(i).getText());
		    
		       // print one value from that list (ex:Jun)
		    	 if (monthList.get(i).getText().equals("Jun")) {
		    		 monthList.get(i).click();
		    		 break;// it will break the loop after getting Jun.
		    	 }
				  
		     }
	}
    
     @Test
     public void genericDropDowTest() {
    
          String monthXpath="//select[@id='month']//option";
 	      String dayXpath="//select[@id='day']//option";
 	      String yearXpath="//select[@id='year']//option";
 	
 	      genericDropDow(monthXpath,"May"); 
 	      genericDropDow(dayXpath,"29"); 
 	      genericDropDow(yearXpath,"2000"); 
        }
	
	    	 
	     
	
	
	@AfterMethod
	public void cleanUp() {
		driver.close();
		driver.quit();
	}
	
    // generic method for the last test
    public static void genericDropDow(String xpathValue, String value) {
            List<WebElement> dropDownList = driver.findElements(By.xpath(xpathValue));
         		    System.out.println(dropDownList.size());
         	     for (int i=0; i<dropDownList.size();i++) {
         		    	 System.out.println(dropDownList.get(i).getText());
         		         if (dropDownList.get(i).getText().equals(value)) {
         		        	dropDownList.get(i).click();
         		    		 break;
         		    	 }
         				  
         		     }
		
	           //select method in selenium have 3 methods:
	                      //-1 selectByIndex,
	                      //-2 selectByValue,
	                      //-3 selectByVisibleText(the best one because if the list changes no need to change your code).
                          //-4 deSelect(4 methods).
	                      //-5 multiSelect(if you can select more than one (return bolean value))
	                      //-6 getOptions
     }
    }
