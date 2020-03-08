package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePO {
	
	WebDriver driver;
	
	By searchBarElement = By.name("q");
	By searchButtonElement = By.xpath("//input[contains(@value, 'Search')]");
	
	// Constructor
	public HomePagePO(WebDriver driver) {
		this.driver = driver;
	}
	
	// Input search item
	public void searchBar(String searchItem) {
		driver.findElement(searchBarElement).sendKeys(searchItem);
	}
	
	// Click search button
	public void searchButton() {
		driver.findElement(searchButtonElement).click();
	}
	
}
