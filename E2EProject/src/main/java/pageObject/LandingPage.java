package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//By signin = By.cssSelector("a[href*='sign in']");
	private By signin = By.xpath("//span[contains(text(),'Login')]");
	private By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	private By tittle = By.cssSelector("div[class='text-center'] h2");
	private By navigationBar = By.cssSelector("nav[class='navbar-collapse collapse']");
	private By header = By.cssSelector("div[class*=video-banner] h3");

	public LoginPage signin() {
		 driver.findElement(signin).click();
		 return new LoginPage(driver);
	}
	
	public WebElement getPopup() {
		return driver.findElement(popup);
	}
	
	//for handling of dynamic pop-up we need popup szie > 0
	public int getPopupSize() {
		return driver.findElements(popup).size();
	}
	
	
	public WebElement getTittle() {
		return driver.findElement(tittle); 
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar); 
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}
	
}
