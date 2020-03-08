package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

public class TestBaseSetup extends InitializeLogging{
	
	private WebDriver driver;		
	
	public WebDriver getDriver() {
		return driver;
	}
	
	private void setDriver(String browserType, String appURL) throws Exception {
		
		log.info("Browser is : "+ browserType);
		
		// Select which browser
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as a default");
			driver = initFirefoxDriver(appURL);
		}
	}
	
	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome");
		
		// FOR TESTING
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability("pageLoadStrategy", "none");
		
		/**
	     * Old Way
	     * Set property which browser to use (browserName, browserDriverLocation)
	     * System.setProperty("webdriver.chrome.driver", "./src\\webdrivers\\chromedriver.exe");
	     */
		
		// https://github.com/bonigarcia/webdrivermanager/
		// Set which browser to use
		WebDriverManager.chromedriver().setup();
		
		// Initializing instance of chrome webdriver
		WebDriver driver = new ChromeDriver();
		
		// Initializing EventFiringWebDriver using chrome webdriver instance. For logging purposes.
		EventFiringWebDriver driverEvent = new EventFiringWebDriver(driver);		
		EventListener listener = new EventListener();		
		driverEvent.register(listener);
		
		// Maximize the window
		driverEvent.manage().window().maximize();
		
		// Navigating to page
		driverEvent.get(appURL);
		
		return driverEvent;
	}
	
	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		
		/**
	     * Old Way
	     * Set property which browser to use (browserName, browserDriverLocation)
	     * System.setProperty("webdriver.firefox.driver", "./src\\webdrivers\\geckodriver.exe");;
	     */
		
		// FOR TESTING
		FirefoxOptions options2 = new FirefoxOptions();
		options2.addArguments("--start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options2);
		capabilities.setCapability("marionette", true);
		
		// https://github.com/bonigarcia/webdrivermanager/
		// Set which browser to use
//		WebDriverManager.firefoxdriver().setup();
		FirefoxDriverManager.getInstance(FIREFOX).arch64().setup();
//		System.out.println(System.getProperty("webdriver.gecko.driver"));
//		WebDriverManager.firefoxdriver().version("69.0.1").setup();
		
		// Initializing instance of firefox webdriver
		WebDriver driver = new FirefoxDriver();
		
		// Initializing EventFiringWebDriver using the webdriver instance. For logging purposes.
		EventFiringWebDriver driverEvent = new EventFiringWebDriver(driver);		
		EventListener listener = new EventListener();		
		driverEvent.register(listener);
		
		// Maximize the window
		driverEvent.manage().window().maximize();
		
		// Navigating to page
		driverEvent.get(appURL);
		
		return driverEvent;
	}

	// Change the parameters in the testng.xml
	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error : " + e.getStackTrace());
		}
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
}
