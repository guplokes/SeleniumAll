package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {
	


	public RediffHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}

	WebDriver driver ;	
	By searchBox = By.id("srchword");
	By submit = By.className("newsrchbtn");	
	
	public WebElement searchBox() {
		return driver.findElement(searchBox);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	
	
}
