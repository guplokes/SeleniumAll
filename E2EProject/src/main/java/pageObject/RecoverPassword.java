package pageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecoverPassword  {
	
	WebDriver driver;

	private By email = By.cssSelector("input[id='user_email']");
	private By sendMeInstructions = By.xpath("//input[@value = 'Send Me Instruction']");
    
    
    
	public RecoverPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getSendMeInstructions() {
		 return driver.findElement(sendMeInstructions);
	}
}
