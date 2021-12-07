package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {
	public WebDriver driver;
	
	public PortalHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//By signin = By.cssSelector("a[href*='sign in']");
	private By searchBox = By.id("search-courses");


	

	public WebElement getsearchBox() {
		return driver.findElement(searchBox);
	}
	
}
