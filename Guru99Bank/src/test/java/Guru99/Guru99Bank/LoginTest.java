package Guru99.Guru99Bank;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import resources.Base;
import resources.DataDriven;
import resources.HomePage;

public class LoginTest extends Base{

	@Test(dataProvider="Guru Test")
	void verifyLogin(String username, String password) throws IOException {
		WebDriver driver = initializeDriver();
		String actualTitle, actualAlertText;
		LoginPage lp = new LoginPage(driver);
		lp.getUserId().clear();
		lp.getUserId().sendKeys(username);
		lp.getPassword().clear();
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String expectedAlertText = "User or Password is not valid";
		String regex = "[0-9]+";
		
		try {
			Alert alrt = driver.switchTo().alert();
			actualAlertText = alrt.getText();
			System.out.println("Login not succesful");
			alrt.accept();
			Assert.assertEquals(actualAlertText, expectedAlertText);
		}
		catch(NoAlertPresentException E) {
			actualTitle = driver.getTitle();
			System.out.println("Login successfull");
			System.out.println(actualTitle);
			
			// Get text displays on login page 
			String text = new HomePage(driver).getManagerText().getText();
			
			// Extract the dynamic text mngrXXXX on page	
			String[] parts = text.split(":");
			String dynamicText = parts[1];
			
			// First 4 characters must be "mngr"(while string is starting with space)
			System.out.println(dynamicText);
			dynamicText = dynamicText.trim();
			Assert.assertTrue(dynamicText.substring(0,4).equals("mngr"));
			System.out.println(dynamicText);
			
			// remain stores the "XXXX" in pattern mngrXXXX
			String remain = dynamicText.substring(4,dynamicText.length());
			System.out.println(remain);
			
			// Check remain string must be numbers(must match with regex)
			Assert.assertTrue(remain.matches(regex));
			
			getScreenshot();	//taking sceenshot of homePage
			
			//to verify login is successful
			Assert.assertEquals(actualTitle, expectedTitle );
		}
	    //System.out.println(driver.getTitle());
	    
	    
	    
	}
	
	@DataProvider(name="Guru Test")
	// row stands for how many time a Test should run
	// column stands for how many values for 1 Test case
	public Object[][] getXcelData() throws IOException {
		/*
		 * Object data[][] = new Object[4][2];
		 * 
		 * DataDriven d = new DataDriven(); data = d.getData();
		 */
		return new DataDriven().getData();
	}
	
	@AfterMethod
	public void close() {
		driver.close();		
	}
}
