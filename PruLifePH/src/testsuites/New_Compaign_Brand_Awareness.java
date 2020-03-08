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

import org.testng.annotations.Parameters;


public class New_Compaign_Brand_Awareness extends TestBaseSetup{
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(ITestContext iTestContext) {
		driver = getDriver();		
		
		// Set the driver object to the ITestContext
		TestListener.setContext(iTestContext, driver);
	}
	
	// This test case will change the from 'Can view and edit' to 'Can view'
	@Parameters({ "userName", "password" })
	@Test
	public void testMethod1(String userName, String password){		
		
		LoginPage LP = new LoginPage(driver);
		HomePage HP = new HomePage(driver);
		SpacePage SP = new SpacePage(driver);
		RestrictionsPage RP = new RestrictionsPage(driver);		

		
		LP.loginAs(userName, password);
//		
//		LP.setUserName(userName);
//		LP.setPassword(password);
//		LP.clickLoginButton();
		
		
		
		
//		HP.clickSwitchTo();
//		HP.clickConfluence();
//		SP.createSpace(spaceName);
//		RP.applyRestrictionChange();
	}
}
