package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.RecoverPassword;
import resources.Base;

public class HomePageTest extends Base {

	WebDriver driver;	
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url")); //using the inherited prop variable from Base class to access data.properties file
		log.info("base url is reached");
	}

	@Test(dataProvider = "getData")
	public void validateLogin(String username, String password, String text) throws IOException {
		LandingPage ln = new LandingPage(driver);
		
		if(ln.getPopup().isDisplayed())
			ln.getPopup().click();  // to remove the pop-up from site

		/*
		 * ln.signin().click(); // driver.findElements().click(); LoginPage lp = new
		 * LoginPage(driver);
		 */

		LoginPage lp = ln.signin();
		lp.getEmail().sendKeys(username);	
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		
		//moving to another Page Forgot Password
		
		RecoverPassword rp = lp.getForgotPassword();
		rp.getEmail().sendKeys(username);
		rp.getSendMeInstructions().click();

		//System.out.println(text);
		log.info(username + "is" + text);

	}

	@DataProvider
	// row stands for how many time a Test should run
	// column stands for how many values for 1 Test case
	public Object[][] getData() {
		Object data[][] = new Object[2][3];

		data[0][0] = "lucky22@gmail.com";
		data[0][1] = "37489";
		data[0][2] = "Restricted user";

		data[1][0] = "kusum23@gmail.com";
		data[1][1] = "46447";
		data[1][2] = "Non-Rsetricted user";

		return data;

	}


	@AfterMethod
	public void closing() {
		driver.close();
	}
}
