package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestrictionsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='css-dnjv80'][contains(.,'Type a user name or group')]") WebElement restrictionSearchBox;
	@FindBy(xpath = "(//div[contains(@class,'css-dnjv80')])[4]") WebElement restrictionDropdown;
	@FindBy(xpath = "(//span[contains(.,'Can view')])[3]") WebElement selectCanView;
	@FindBy(xpath = "//span[@class='css-t5emrf'][contains(.,'Apply')]") WebElement restrictionSubmit;
	
	// Constructor
	public RestrictionsPage(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	// 
	private RestrictionsPage inputUserOrGroup(String userOrGroup) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(restrictionSearchBox));
		
		
		restrictionSearchBox.sendKeys(userOrGroup);
		return this;
	}
	
	public RestrictionsPage selectCanView() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(restrictionDropdown));
		
		restrictionDropdown.click();
		selectCanView.click();
		return new RestrictionsPage(driver);
	}
	
	
	public SpacePage clickApply() {		
		restrictionSubmit.click();
		return new SpacePage(driver);
	}
	
	
	public SpacePage applyRestrictionChange() {
		selectCanView();
		clickApply();
		return clickApply();
	}
	
}
