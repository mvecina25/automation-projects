package testsuites;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import base.TestListener;
import helper.SeleniumUtilities;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;
import pagefactory.ContactUs;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.RestrictionsPage;
import pagefactory.ShoppingCart;
import pagefactory.SignIn;
import pagefactory.SpacePage;

import org.testng.annotations.Parameters;


public class PlanIT extends TestBaseSetup{
	
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
		SpacePage SP = new SpacePage(driver);
		RestrictionsPage RP = new RestrictionsPage(driver);	
		ContactUs CU = new ContactUs(driver);
		SignIn SI = new SignIn(driver);
		ShoppingCart SC = new ShoppingCart(driver);
		SeleniumUtilities util = new SeleniumUtilities(driver);

		CU.btnClick_ContactUs();
		CU.select_Subject("Customer service");
		CU.input_EmailAdd("test@test.com");
		CU.input_MessageBox("This is automation scripts built using Selenium and Eclipse");
		CU.btnClick_Send();
		
		Assert.assertEquals(CU.messageSuccessful(), "Your message has been successfully sent to our team.");
		
		SI.btnClick_SignIn();
		SI.input_EmailCreate("test@test.com");
		SI.btnClick_CreateAccount();
		
		Assert.assertEquals(SI.emailExist(), "An account using this email address has already been registered. Please enter a valid password or request a new one.");

		SC.btnClick_Dresses();
		
		util.selectProductItemByCSSNameAndPrice("#center_column > ul > li > div", "Printed Summer Dress", "$30.50");
		
		SC.btnClick_AddToCart();
		
		SC.btnClick_ProceedToCheckOut();
		
		SC.btnClick_DeleteItem();
		
		Assert.assertEquals(SC.messageShoppingCartEmpty(), "Your shopping cart is empty.");
	}
}
