package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;


public class LoginPagePO {
	
	WebDriver driver;
	
//	WebElement titlePage = driver.findElement(By.tagName("title"));
	
	By userName = By.id("//*[@id=\"user_login\"]");
	By password = By.id("//*[@id=\"user_pass\"]");
	By login = 	By.id("//*[@id=\"wp-submit\"]");
	
	
	
	// Constructor
	public LoginPagePO(WebDriver driver) {
		this.driver = driver;
	}
	
	// Set user name in the username textbox
	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
	}
	
	// Set password in password textbox
	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}
	
	// Click on login button
	public void clickLoginButton() {
		driver.findElement(login).click();
	}
	
	// Get the title of the login page
	public String getLoginTitle() {
		return driver.findElement(By.tagName("title")).getText();
	}	
	

	
}

