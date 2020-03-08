package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollElementIntoView {
	
	WebDriver driver;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ScrollElementIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
