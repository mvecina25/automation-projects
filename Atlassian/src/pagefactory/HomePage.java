package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@data-test-id,'objectName')]") WebElement testingPage;
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	// Click Existing Page
	public HomePage clickPage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(testingPage));
		
		testingPage.click();
		return this;
	}
	
	
}
