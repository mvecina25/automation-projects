package com.wtech.grid;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestParallel {
	
//	  public static RemoteWebDriver driver;
//	public static WebDriver driver;
	
//	  String baseURL = "http://www.google.com";
	  
	  WebDriver driver;
	
	  @Parameters({"browserName","nodeURL"})
	  @BeforeTest
	  public void beforeTest(String browserName, String nodeURL) throws MalformedURLException{		  

	  
		  DesiredCapabilities cap = null;	  
		  
		  if (browserName.equals("chrome")) {
	          System.out.println("Chrome Browser Initiated");
	          cap = DesiredCapabilities.chrome(); 
	          cap.setBrowserName("chrome");
	          cap.setPlatform(Platform.WINDOWS);           
	          driver = new RemoteWebDriver(new URL(nodeURL),cap); 
		  }
		  else if(browserName.equals("firefox")) {
	          System.out.println("Firefox Browser Initiated");
	          cap = DesiredCapabilities.firefox();
	          cap.setBrowserName("firefox");
	          cap.setPlatform(Platform.WINDOWS);           
	          driver = new RemoteWebDriver(new URL(nodeURL),cap); 
		  }
		  
          driver.get("https://www.apple.com/");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  

	  }
	  
	    @Test
	    public void appleSite() throws InterruptedException
	    {
	        try
	        {
	         
	        driver.findElement(By.xpath("//*[@id=\'ac-globalnav\']/div/ul[2]/li[3]")).click();
	        Thread.sleep(9000);
	  
	        driver.findElement(By.cssSelector("#chapternav > div > ul > li.chapternav-item.chapternav-item-ipad-air > a > figure")).click();
	        Thread.sleep(9000);
	  
	        driver.findElement(By.linkText("Why iPad")).click();
	        Thread.sleep(9000);
	        }
	         
	        catch(Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    @AfterMethod()
	    public void tearDown()
	    {
	            driver.quit();
	            System.out.println("Browser Closed");
	    }

}
