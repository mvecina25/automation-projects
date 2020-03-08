package com.wtech.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {
	
	  public static RemoteWebDriver driver;
	  
	  @BeforeTest
	  @Parameters({"platform", "browserName", "remoteurl"})
	  public void beforeTest(String platform, String browserName, String remoteurl) throws MalformedURLException {
		  
		  DesiredCapabilities capabilities = null;		  
		  String baseURL = "http://www.google.com";
		  String nodeURL = "http://127.0.0.1:5566/wd/hub";
		  
		  if (browserName.equals("firefox"))  {
			  capabilities = new DesiredCapabilities().firefox();
			  capabilities.setBrowserName("firefox");
		  }else if (browserName.equals("chrome")) {
			  capabilities = new DesiredCapabilities().chrome();
			  capabilities.setBrowserName("chrome");
		  }
		  		
		  capabilities.setPlatform(Platform.WIN10);
		  		  
		  driver = new RemoteWebDriver(new URL(remoteurl), capabilities);		
		  
		  driver.navigate().to(baseURL);
	  }	
	
	  @Test
	  public void GoogleSearch() {
		  
		  driver.findElementByName("q").sendKeys("execute automation");
		  driver.findElementByName("btnG").click();
	  }


}
