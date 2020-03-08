package helper;

import static org.testng.Assert.assertFalse;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBaseSetup;

public class SeleniumUtilities {

	WebDriver driver;
	
	public SeleniumUtilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement waitForElement(WebElement elementLocator, int timeout) {
		
		WebElement webElement = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		try {
			System.out.println(elementLocator);
			webElement = wait.until(ExpectedConditions.visibilityOf(elementLocator));
			
		} catch (WebDriverException e) {
			// TODO: handle exception
		}
		
		if (webElement == null) {
			assertFalse(true, "WebElement not found within " + timeout + " seconds. Test Failed - " + "Element: " + elementLocator + "\nCurrent Page: " + driver.getCurrentUrl());
		}
		
		return webElement;
	}
	
	public WebElement fluentWait(final WebElement createSpaceNextElement) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(30, TimeUnit.SECONDS)
	            .pollingEvery(5, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);

	    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement((By) createSpaceNextElement);
	        }
	    });

	    return  foo;
	};

		
}
