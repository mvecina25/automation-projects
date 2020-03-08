package testsuites;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import base.TestListener;
import helper.SeleniumUtilities;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.RestrictionsPage;
import pagefactory.SpacePage;

import org.testng.annotations.Parameters;


public class TestCase1 extends TestBaseSetup{
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(ITestContext iTestContext) {
		driver = getDriver();		
		
		// Set the driver object to the ITestContext
		TestListener.setContext(iTestContext, driver);
	}
	
	@Test
	public void testMethod1(){		
		
		LoginPage LP = new LoginPage(driver);
		HomePage HP = new HomePage(driver);

	
		HP.inputLeavingFrom("New Orleans, United States - Lakefront [NEW]");
		HP.inputGoingTo("New York, United States - All Airports [NYC]");
		HP.clickDeparting();
		HP.clickReturning();
		HP.clickSearch();
		
		ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForPageLoad();
	}
}
