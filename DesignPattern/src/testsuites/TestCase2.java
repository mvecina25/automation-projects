package testsuites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import base.TestListener;
import helper.ScrollElementIntoView;
import pagefactory.OpenSourceHomePage;

public class TestCase2 extends TestBaseSetup{
	
	WebDriver driver;
	OpenSourceHomePage objOpenSourceHomePage = new OpenSourceHomePage();
//	@FindBy(xpath = "//a[contains(.,'Log in')]") WebElement LoginLinkElement;

	@BeforeClass
	public void setUp(ITestContext iTestContext) {
		driver=getDriver();		
		
		// Set the driver object to the ITestContext
		TestListener.setContext(iTestContext, driver);
		
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void testMethod2(){
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
//		OpenSourceHomePage objOpenSourceHomePage = new OpenSourceHomePage();
		
//		objOpenSourceHomePage.checkArrowDown();

//		driver.findElement(By.xpath("//*[@class='menu-scroll-down']")).click();

		// Working
//		WebElement element = driver.findElement(By.xpath("//*[@id=\"meta-2\"]/ul/li[1]/a"));
		System.out.println("driver="+ driver);
		
//		LoginButton.click();
		js.executeScript("arguments[0].scrollIntoView(true);", objOpenSourceHomePage.LoginLinkElement);
//		js.executeScript("arguments[0].scrollIntoView(true);", LoginLinkElement);
		objOpenSourceHomePage.clickLoginLink();
//		LoginLinkElement.click();
		
		
//		objOpenSourceHomePage.clickScrollDown();
		
//		objOpenSourceHomePage.clickLoginLink();
		
		

	}
}
