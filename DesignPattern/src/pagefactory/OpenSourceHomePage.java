package pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import testsuites.TestCase2;

public class OpenSourceHomePage {

//	WebDriver driver;
	
//	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	// Scroll Down
	@FindBy(className="icon icon-arrow-right") WebElement ScrollDown;
	//Login Link
	@FindBy(xpath = "//a[contains(.,'Log in')]")
	public WebElement LoginLinkElement;
	
	
	public void clickLoginLink() {
		Reporter.log("Click Login link");
//		System.out.println("driver="+ driver);
		LoginLinkElement.click();
	}
	
	public void clickScrollDown() {
//		driver.findElement(By.xpath("//*[@class='menu-scroll-down']")).isDisplayed();
		Reporter.log("Click scroll down");
	}
	
	public void checkArrowDown() {
		Assert.assertEquals(true, ScrollDown.isDisplayed());
	}
	
}
