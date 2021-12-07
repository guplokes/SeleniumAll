package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
WebDriver driver;

public HomePage(WebDriver driver) {
	this.driver = driver;
}

private By managerText = By.xpath("//table/tbody/tr[3]/td");

public WebElement getManagerText() {
	return driver.findElement(managerText);
}
}
