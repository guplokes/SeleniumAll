package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPagePF {
	

	WebDriver driver ;	

	public RediffLoginPagePF(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	/*
	 * By username = By.xpath("//input[@id='login1']");
	 *  By password =	 * By.id("password"); 
	 * By go = By.xpath("//input[@value='Sign in']");
	 *  By home = By.linkText("rediff.com");
	 * 
	 */
	
	//Find By annotations for page factory(it is simplified versiion of Page object Model)
	@FindBy (xpath="//input[@id='login1']")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement go;
	
	@FindBy(linkText="rediff.com")
	WebElement home ;
	
	//These commented method are for POM-- Page Onject MOdel(classic way)
	/*
	 * public WebElement email() { return driver.findElement(username); }
	 * 
	 * public WebElement password() { return driver.findElement(password); }
	 * 
	 * public WebElement submit() { return driver.findElement(go); }
	 * 
	 * public WebElement home() { return driver.findElement(home); }
	 */
	
	//these method for Page factory
	public WebElement email() {
		return username;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement submit() {
		return go;
	}
	
	public WebElement home() {
		return home;
	}
	
}
