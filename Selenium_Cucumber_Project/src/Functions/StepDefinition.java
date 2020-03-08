package Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class StepDefinition {
	
	WebDriver driver; // WebDriver allows you to write automation scripts with friendly API.
	
	@Given("^the user opens a browser and go to \"([^\"]*)\"$")
	public void the_user_opens_a_browser_and_go_to(String page) throws Throwable {
		
		driver=new FirefoxDriver(); // This will use the firefox browser
		driver.manage().window().maximize();
		driver.get(page);

	}

	@When("^user clicks on My Vodafone tab$")
	public void user_clicks_on_My_Vodafone_tab() throws Throwable {
		
		Thread.sleep(20000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("My Vodafone")).click();

	}

	@When("^user clicks on Login button$")
	public void user_clicks_on_Login_button() throws Throwable {

		Thread.sleep(10000);
		driver.findElement(By.linkText("Login")).click();
	}

	@When("^user enters invalid username \"([^\"]*)\"$")
	public void user_enters_invalid_username(String uname) throws Throwable {

		Thread.sleep(10000);
		driver.findElement(By.id("myvfLoginOnlineId")).sendKeys(uname);
	}

	@When("^user enters invalid password \"([^\"]*)\"$")
	public void user_enters_invalid_password(String pass) throws Throwable {
		
		driver.findElement(By.id("myvfLoginPassword")).sendKeys(pass);
	}
	
	@When("^user clicks Sign in button$")
	public void user_clicks_Sign_in_button() throws Throwable {

		driver.findElement(By.id("sign-in-button")).click();
	}

	@Then("^user should NOT be able to login successfully$")
	public void user_should_NOT_be_able_to_login_successfully() throws Throwable {

		Thread.sleep(2000);
		assertTrue(driver.findElement(By.className("submitError")).isDisplayed());
		
	}

}
