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
	
	
	@FindBy(xpath = "//input[@name='seg0_from']") WebElement leavingFromElement;
	@FindBy(xpath = "//input[contains(@placeholder,'Departing')]") WebElement departingElement;
	@FindBy(xpath = "//a[@class='ui-state-default ui-state-highlight'][contains(.,'3')]") WebElement departingCalendarElement;
	@FindBy(xpath = "//input[@name='seg0_to']") WebElement goingToElement;
	@FindBy(xpath = "//input[@placeholder='Returning']") WebElement returningElement;
	@FindBy(xpath = "(//a[@class='ui-state-default'][contains(.,'6')])[1]") WebElement returningCalendarElement;
	@FindBy(xpath = "//a[contains(.,'SEARCH')]") WebElement searchElement;

	
	
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void inputLeavingFrom(String strLeavingFrom) {
		leavingFromElement.sendKeys(strLeavingFrom);
	}
	
	public void inputGoingTo(String strGoingTo) {
		goingToElement.sendKeys(strGoingTo);
	}
	
	public void clickDeparting() {
		departingElement.click();
		departingCalendarElement.click();
	}
	
	public void clickReturning() {
		returningElement.click();
		returningCalendarElement.click();
	}
	
	public void clickSearch() {
		searchElement.click();
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
