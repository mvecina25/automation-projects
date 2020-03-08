package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.SeleniumUtilities;

public class SpacePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//span[contains(@class,'sc-bdVaJa ixkqUR')])[10]") WebElement pageDropDownElement;
	@FindBy(xpath = "(//span[contains(.,'Restrictions')])[5]") WebElement restrictionsElement;
	@FindBy(xpath = "//div[@class='css-172b2ru'][contains(.,'Spaces')]") WebElement spacesElement;
	@FindBy(xpath = "//span[contains(.,'Create Space')]") WebElement createSpaceElement;
	@FindBy(xpath = "//button[@data-test-id='create-dialog-create-button']") WebElement createSpaceNextElement;
	@FindBy(xpath = "//input[contains(@name,'name')]") WebElement spaceNameElement;
	@FindBy(xpath = "//button[@class='create-dialog-create-button aui-button aui-button-primary'][contains(.,'Create')]") WebElement createElement;
	
	// Constructor
	public SpacePage(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	// 
	public SpacePage clickPageDropdown() {		
		WebDriverWait wait = new WebDriverWait(driver, 10);
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
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.fluentWait(createSpaceNextElement);		
		createSpaceNextElement.click();
		return this;
	}
	
	public SpacePage setUserName(String strSpaceName) {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(spaceNameElement, 20);	
		spaceNameElement.sendKeys(strSpaceName);
		return this;
	}
	
	public SpacePage clickCreateButton() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.fluentWait(createElement);		
		createElement.click();
		return this;
	}
	
	public SpacePage createSpace(String strSpaceName) {
		clickSpaces();
		clickCreateSpaceButton();
		clickCreateSpaceNextButton();
		setUserName(strSpaceName);
		clickCreateButton();
		return this;		
	}
	
}
