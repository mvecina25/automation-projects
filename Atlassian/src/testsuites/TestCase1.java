package testsuites;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import base.TestListener;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.RestrictionsPage;
import pagefactory.SpacePage;


public class TestCase1 extends TestBaseSetup{
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(ITestContext iTestContext) {
		driver = getDriver();		
		
		// Set the driver object to the ITestContext
		TestListener.setContext(iTestContext, driver);
	}
	
	// This test case will change the from 'Can view and edit' to 'Can view'
	@Test
	public void testMethod1(){		
		
		LoginPage LP = new LoginPage(driver);
		HomePage HP = new HomePage(driver);
		SpacePage SP = new SpacePage(driver);
		RestrictionsPage RP = new RestrictionsPage(driver);
		
		
		
		
		LP.loginAs("medel.vecina@gmail.com", "Testing1234");
//		HP.clickPage();
//		SP.selectRestrictions();
//		RP.applyRestrictionChange();

		

	}

	
}
