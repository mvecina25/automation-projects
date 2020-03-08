package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpacePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "(//span[contains(@class,'sc-bdVaJa ixkqUR')])[10]") WebElement pageDropDown;
	@FindBy(xpath = "(//span[contains(.,'Restrictions')])[5]") WebElement selectRestrictions;
	
	// Constructor
	public SpacePage(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	// 
	public SpacePage clickPageDropdown() {		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(pageDropDown));
		
		pageDropDown.click();
		return this;
	}
	
	public SpacePage clickRestrictions() {		
		selectRestrictions.click();
		return this;
	}
	
	public SpacePage selectRestrictions() {
		clickPageDropdown();
		clickRestrictions();
		return this;
	}
}
