package pagefactory;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

import helper.SeleniumUtilities;
import okio.Timeout;

public class SpacePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//span[contains(@class,'sc-bdVaJa ixkqUR')])[10]") WebElement pageDropDownElement;
	@FindBy(xpath = "(//span[contains(.,'Restrictions')])[5]") WebElement restrictionsElement;
	@FindBy(xpath = "//div[@class='css-172b2ru'][contains(.,'Spaces')]") WebElement spacesElement;
	@FindBy(xpath = "//span[contains(.,'Create Space')]") WebElement createSpaceElement;
	@FindBy(xpath = "//div[@id='create-dialog']/div[@class='dialog-components']//button[.='Next']") WebElement createSpaceNextElement;
	@FindBy(xpath = "//input[contains(@name,'name')]") WebElement spaceNameElement;
	@FindBy(xpath = "//div[@id='create-dialog']/div[2]//button[.='Create']") WebElement createElement;
	@FindBy(xpath = "//h3[@id='Welcome-to-your-new-space']/strong[.='Welcome to your new space']") WebElement spaceWelcomeElement;
	
	// Constructor
	public SpacePage(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	// 
	public SpacePage clickPageDropdown() {		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(pageDropDownElement));		
		pageDropDownElement.click();
		return this;
	}
	
	public SpacePage clickRestrictions() {		
		restrictionsElement.click();
		return this;
	}
	
	public SpacePage selectRestrictions() {
		clickPageDropdown();
		clickRestrictions();
		return this;
	}
	
	public SpacePage clickSpaces() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(spacesElement, 20);
		spacesElement.click();
		return this;
	}
	
	public SpacePage clickCreateSpaceButton() {		
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(createSpaceElement, 20);		
		createSpaceElement.click();		
		return this;
	}
	
	public SpacePage clickCreateSpaceNextButton() {		
		
		driver.switchTo().activeElement();	
			
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(createSpaceNextElement, 20);	
				
		createSpaceNextElement.click();
		return this;
	}
	
	public void clickCreateSpaceNextButton2() {		
		
		driver.switchTo().activeElement();	
				
		createSpaceNextElement.click();
	}
	
	public SpacePage setUserName(String strSpaceName) {
		driver.switchTo().activeElement();
		
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(spaceNameElement, 20);	
		
		spaceNameElement.sendKeys(strSpaceName);
		return this;
	}
	
	public SpacePage clickCreateButton() {
		
		driver.switchTo().activeElement();
			
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(createElement, 20);
		
		driver.switchTo().activeElement();	
		
		createElement.click();
		
		
		return this;
	}
	
	public void clickCreateButton2() {
		
		driver.switchTo().activeElement();
		
		createElement.click();

	}
	
	public void createSpace(String strSpaceName) {
				
		clickSpaces();
		
		clickCreateSpaceButton();		
		
		clickCreateSpaceNextButton2();
		
		setUserName(strSpaceName);
		
		clickCreateButton2();		
		
		assertTrue(driver.getPageSource().contains("Welcome to your new space"));
		
	}
	
}
