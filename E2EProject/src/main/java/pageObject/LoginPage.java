package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


		public WebDriver driver;

		private By email = By.cssSelector("input[id='user_email']");
		private By password = By.cssSelector("input[type='password']");
		private By login = By.cssSelector("input[name='commit']");
		private By forgotPassword = By.cssSelector("a[class='link-below-button']");
		
		public LoginPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public WebElement getEmail() {
			return driver.findElement(email);
		}
		
		public WebElement getPassword() {
			return driver.findElement(password);
		}
		

		public WebElement getLogin() {
			return driver.findElement(login);
		}
	
		public RecoverPassword getForgotPassword() {
			driver.findElement(forgotPassword).click();
			return new RecoverPassword(driver);
		}

		
}
