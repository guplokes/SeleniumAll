package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	


	public RediffLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}

	WebDriver driver ;	
	By username = By.xpath("//input[@id='login1']");
	By password = By.id("password");
	By go = By.xpath("//input[@value='Sign in']");
	By home = By.linkText("rediff.com");
	
	public WebElement email() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement submit() {
		return driver.findElement(go);
	}
	
	public WebElement home() {
		return driver.findElement(home);
	}
	
}
