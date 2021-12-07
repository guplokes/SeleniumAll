package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Start3 {

	@Test(groups= {"Smoke"})
	public void webLoginCarLoan()
	{
		//selenium
		System.out.println("webLoginCarLoan");
	}
	
	@Test(dataProvider="getData") // this test will get execute 3 times
	public void signInCarLoan(String username, String pass)
	{
		//selenium
		System.out.println("signInCarLoan/credit score");
		System.out.println(username);
		System.out.println(pass);
	}


	@Test
	public void mobileLoginCarLoan()
	{
		//Appium
		System.out.println("mobileLoginCarLoan");

	}

	@Test
	public void mobileLogOutCarLoan()
	{
		//Appium
		System.out.println("mobileLoginCarLoan");
	}


	@AfterSuite
	public void afterSuite()
	{
		System.out.println("This is the no. 1 from lAST");
	}


	@Test
	public void mobileAmountCarLoan()
	{
		//Appium
		System.out.println("mobileLoginCarLoan");
	}

	@Test(dependsOnMethods={"webLoginCarLoan"})
	public void APICarLoan()
	{
		//Rest Api Automation
		System.out.println("LoginAPICarLoan");
		Assert.assertTrue(false);
	}
	
@DataProvider
public Object[][] getData() {
	//Ist username and password -- credit score is good
	//IInd username and password -- credit score is average
	//3rd username and password -- credit score is bad

		Object[][] data = new Object[3][2];
		
		data[0][0]="firstusername";
		data[0][1]="firstpassword";
		
		data[1][0]="secondusername";
		data[1][1]="secondpassword";
		
		data[2][0]="3rdusername";
		data[2][1]="3rdpassword";
		
		return data;
}

}
