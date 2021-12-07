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

public class ValidateTittleTest extends Base {
	
	WebDriver driver;
	LandingPage ln; //this is done after optimazation i.e, after creating of new @Test  validateHeader()
	public static Logger log = LogManager.getLogger(ValidateTittleTest.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
		log.info("driver is initialized");
		ln = new LandingPage(driver);//this is done after optimazation i.e, after creating of new @Test  validateHeader()
		
		
		driver.get(prop.getProperty("url")); //using the inherited prop variable from Base class to access data.properties file
		log.info("base url is reached");
	}
	
	@Test
	public void  validateTittle() throws IOException  {
		
		//this below step is of before optimazation i.e, before creating of new @Test  validateHeader()
		//LandingPage ln = new LandingPage(driver);

		/*
		 * ln.skipNewsLetter().click();
		 * // to remove the pop-up from site(it can also be
		 * moved in beforeTest or here thi @Test is running first sor also fine)
		 */
		//ln.getTittle().getText();
		//Compare the text from browser with actual text
		
		if(ln.getPopupSize()>0) 
		{
			ln.getPopup().click();  // Handling dynamic pop-up
		}
		
		Assert.assertEquals(ln.getTittle().getText(), "FEATURED COURSES44");
		log.info("Text is validated");


	}
	
	@Test
	public void  validateHeader() {
		Assert.assertEquals(ln.getHeader().getText(),"An Academy to learn Everything about Testin");
	}
	
	@AfterTest
	public void closing() {
		driver.close();
	}

}
