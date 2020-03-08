package testsuites;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import base.TestListener;
import pagefactory.GoogleHomePage;


public class TestCase1 extends TestBaseSetup{
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(ITestContext iTestContext) {
		driver=getDriver();		
		
		// Set the driver object to the ITestContext
		TestListener.setContext(iTestContext, driver);
	}
	
	@Test
	public void testMethod1(){
		
		GoogleHomePage objHomePage = new GoogleHomePage(driver);
				
		objHomePage.searchGoogle("first test with POM");
		
		objHomePage.checkGmailLogo();
		
		objHomePage.clickGmailLink();
		
		objHomePage.checkGmailLogo();
		
//		objHomePage.checkGmailLogo2();
		
//		softAssert.assertAll();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
