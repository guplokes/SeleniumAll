package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class ValidateNavigationBarTest extends Base {
	
	WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateNavigationBarTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		
		driver.get(prop.getProperty("url")); //using the inherited prop variable from Base class to access data.properties file
		log.info("base url is reached");
	}
	
	@Test
	public void validateNavigationBar()   {

		LandingPage ln = new LandingPage(driver);
		//ln.skipNewsLetter().click();// to remove the pop-up from site
		
		if(ln.getPopupSize()>0) 
		{
			ln.getPopup().click();  // Handling dynamic pop-up
		}

		//ln.getTittle().getText();
		//Compare the text from browser with actual text
		//Assert.assertEquals(ln.getTittle().getText(), "FEATURED COURSES 4");
		Assert.assertTrue(ln.getNavigationBar().isDisplayed());
		log.info("navigation bar is displayed");


	}
	
	@AfterTest
	public void closing() {
		driver.close();
	}

}
