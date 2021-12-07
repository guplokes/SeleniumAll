package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Start4 {


	@BeforeClass
	public void beforeClass() {
		System.out.println("this method executes before any method in the class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("this method executes after evrey method executed  in the class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This method will be invoked before every test method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This method will be invoked after every test method");
	}


	@Parameters({"URL","key"})
	@Test
	public void webLoginHomeLoan(String url, String key)
	{
		//selenium
		System.out.println(url);
		System.out.println(key);
		System.out.println("webLoginHomeLoan");
	}

	@Test
	public void mobileLoginHomeLoan()
	{
		//Appium
		System.out.println("mobileLoginHomeLoan");
	}

	@Test(groups= {"Smoke"})
	public void LoginAPIHomeLoan()
	{
		//Rest Api Automation
		System.out.println("LoginAPIHomeLoan");
	}



}
