package seleniumMethods;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadPDF {
	
	//1- we need to add pdfBox dependency from maven to pom.xml
	@Test
	public void readPDFFromInternet() throws IOException {
		//NB: make sure that your pdf url always have (.pdf) at the end
	        //get url pdf file in local machin: pdf file => write click => open with browser => copy the url from the browser 
		    // we can't get text from image even if its pdf format
		
		//1- without using selenium(use just the next line)
		    //URL url = new URL("https://www.fcusd.org/cms/lib/CA01001934/Centricity/Domain/1250/Formal%20Letter%20Writing%20Workshop.pdf");// URL OF MY PDF FILE
		
		//2- using selenium:
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.fcusd.org/cms/lib/CA01001934/Centricity/Domain/1250/Formal%20Letter%20Writing%20Workshop.pdf");
		String currentUrl = driver.getCurrentUrl();
		URL url = new URL (currentUrl);
		
		InputStream inStr = url. openStream();// open connection the url
		BufferedInputStream fileParse = new BufferedInputStream(inStr);//to read the pdf
		PDDocument document = null;
		
		document = PDDocument.load(fileParse);// to load the text
		String pdfContent = new PDFTextStripper().getText(document); // store the text 
		System.out.println(pdfContent); 
		
		Assert.assertTrue(pdfContent.contains("Thomas Sawyer"));//  (need to add text from pdf ) 
		Assert.assertTrue(pdfContent.contains("Mr. Joseph Bicman"));
		Assert.assertTrue(pdfContent.contains("Writing a Formal Letter"));
		

		
	}
	@Test
	public void readPDFFromLocal() throws IOException {
		
		
		//NB: make sure that your pdf url always have (.pdf) at the end
		    // get url pdf file in local machin: pdf file => write click => open with browser => copy the url from the browser 
		    // we can't get text from image even if its pdf format
		
    //1- without using selenium(use just the next line)
	    //URL url = new URL("file:///C:/Users/saadi/Desktop/3833NYCertificate[304].pdf");// URL OF MY PDF FILE
	
	//2- using selenium:
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\saadi\\eclipse-workspace\\seleniumAutomation\\SeleniumPractice\\driver\\chromeDriver\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("file:///C:/Users/saadi/Desktop/3833NYCertificate[304].pdf");
	String currentUrl = driver.getCurrentUrl();
	URL url = new URL (currentUrl);
	
	InputStream inStr = url. openStream();// open connection the url
	BufferedInputStream fileParse = new BufferedInputStream(inStr);//to read the pdf
	PDDocument document = null;
	
	document = PDDocument.load(fileParse);// to load the text
	String pdfContent = new PDFTextStripper().getText(document); // store the text 
	System.out.println(pdfContent); 
	
	
	Assert.assertTrue(pdfContent.contains("FERHAT SAADI"));//  (need to add text from pdf ) 
	Assert.assertTrue(pdfContent.contains("Date 5/1/2019"));
	Assert.assertTrue(pdfContent.contains("Director’s Signature"));
		
	}
	
}
 