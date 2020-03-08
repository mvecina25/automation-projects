package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import net.bytebuddy.asm.Advice.This;
import okhttp3.internal.Util;

import java.awt.print.Pageable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import helper.SeleniumUtilities;


public class LoginPage {
	
	WebDriver driver;

	
//	Page Factory
	@FindBy(xpath = "//input[contains(@id,'email')]") WebElement userName;
	@FindBy(xpath = "//input[contains(@id,'pass')]") WebElement password;
	@FindBy(xpath = "(//span[contains(.,'Continue')])[3]") WebElement btnContinue;	
	@FindBy(xpath = "//input[contains(@data-testid,'royal_login_button')]") WebElement btnLogin;	
	
	
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	// Set user name in the username textbox
	public LoginPage setUserName(String strUserName) {
//		Page Object
//		driver.findElement(userName).sendKeys(strUserName);
		
//		Page Factory
		userName.sendKeys(strUserName);
		return this;
	}	
	
	// Set password in password textbox
	public LoginPage setPassword(String strPassword) {
//		Page Object
//		driver.findElement(password).sendKeys(strPassword);
		
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(password, 10);
		
				
//		Page Factory
		password.sendKeys(strPassword);
		return this;
	}
	
	
	// Click on continue button
	public LoginPage clickContinueButton() {
//		Page Object
//		driver.findElement(btnContinue).click();
		
//		Page Factory
		btnContinue.click();
		return this;
	}
	
	// Click on login button
	public HomePage clickLoginButton() {
//		Page Object
//		driver.findElement(login).click();
		
//		Page Factory
		btnLogin.click();
		return new HomePage(driver);
	}
	
	
	public void loginAs(String strUserName, String strPassword) {
		setUserName(strUserName);
		setPassword(strPassword);
		clickLoginButton();
	}
	
}

