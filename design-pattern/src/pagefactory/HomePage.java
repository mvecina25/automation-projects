package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.SeleniumUtilities;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@data-test-id,'objectName')]") WebElement testingPage;
	@FindBy(xpath = "//span[contains(@aria-label,'Switch to...')]") WebElement switchTo;
	@FindBy(xpath = "//span[@class='ItemParts__Content-sc-14xek3m-5 jRBaLt'][contains(.,'Confluence')]") WebElement confluencePage; 
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	// Click Existing Page
	public HomePage clickPage() {
		
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(testingPage, 20);
		
		testingPage.click();
		return this;
	}
	
	// Click Switch To
	public HomePage clickSwitchTo() {
		
//		SeleniumUtilities util = new SeleniumUtilities(driver);		
//		util.waitForElement(switchTo, 30);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(switchTo));
		
		switchTo.click();
		return this;
	}
	
	// Click Confluence Page
	public HomePage clickConfluence() {
		
//		SeleniumUtilities util = new SeleniumUtilities(driver);
//		util.waitForElement(confluencePage, 20);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(confluencePage));
		
		confluencePage.click();
		return this;
	}
	
		
	
}
