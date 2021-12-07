package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;		
	}

	private By userId = By.name("uid");
	private By password = By.name("password");
	private By login = By.name("btnLogin");
	
	public WebElement getUserId() {
		return driver.findElement(userId);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
}
