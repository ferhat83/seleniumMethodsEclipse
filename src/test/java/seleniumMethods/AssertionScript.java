package seleniumMethods;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionScript {

    SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false,priority = 1)
    public void  test1() {//expect an AssertionError will be thrown  ; this assertion it is called hard assertion
    	Assert.assertEquals(12,13); // hard Assertd
    	
    }

    @Test(enabled = false,priority = 2)
    public void test2() { 
    	System.out.println("Test case 2 satrted");
    	Assert.assertEquals(12,13,"DropDown does not much please check with the developer");//hard Assert
    	System.out.println("Test case 2 Completed");
    }

	@Test(enabled = false, priority = 3) 
	
	public void test3() {
		System.out.println("Test case 3 Started");
		Assert.assertEquals("Hello", "Hello","Word does not match please raise bug");// hard Assert
		System.out.println("Test case 3 Completed");
	}

	@Test(enabled = true)
	public void test4() {
		System.out.println("open browser");   
		Assert.assertEquals(true,true);   // we used hard assertion where  it is critical for the next series of testSuit 
		 
		System.out.println("enter username");
		System.out.println("enter password"); 
		System.out.println("click on sign button");
		Assert.assertEquals(true, true);    //hard assertion
		
		System.out.println("validate the homePage");
		softAssert.assertEquals(false, true,"home Page is missing");  //soft assertion
		
		System.out.println("go to smartPhone");
		System.out.println("Click on IphoneX");
		System.out.println("Choose the color");
		 
		softAssert.assertEquals(false, true,"No colors are displayed"); //soft assertion 
		
		softAssert.assertAll();  // it is very important to write this statement to get all the details 
	                        //about the failed tests and the test will be considered as passed 
	
	}
	
	@Test(enabled = true)
	public void test5() {
		System.out.println("logout");
		softAssert.assertEquals(true, false,"didn't  not logout from the application");//soft assertion 
		softAssert.assertAll();//soft assertion 
	}

}
