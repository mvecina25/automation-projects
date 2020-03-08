package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import org.testng.asserts.SoftAssert;
import org.testng.Reporter;

import base.CustomAssertion;

public class GoogleHomePage {

	/**
     * All WebElements are identified by @FindBy annotation
     */
	
	WebDriver driver;
	
	private CustomAssertion customAssert = new CustomAssertion();
	
	@FindBy(name="q") WebElement searchBar;	
	@FindBy(name="btnK") WebElement searchButton;
	@FindBy(className="gb_e") WebElement GmailLink;
	@FindBy(id="hplogo") WebElement gmailLogo;
		
	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;		
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void searchGoogle(String searchTerm){		
		searchBar.sendKeys(searchTerm);
		Reporter.log("Input in the search bar: " + searchTerm);
		searchBar.click();
		Reporter.log("Click search bar");
	}
	
	public void clickGmailLink() {
		GmailLink.click();
		Reporter.log("Click Gmail link");
	}
	
	public void checkGmailLogo() {
		Reporter.log("Assert: " + gmailLogo);
		Assert.assertEquals(true, gmailLogo.isDisplayed(), "TESTING123");
	}
	
	public void checkGmailLogo2() {
		customAssert.assertEquals(true, gmailLogo.isDisplayed(), "TESTING123");
		System.out.println(customAssert.getAssertMessages());
	}

	
	
}
