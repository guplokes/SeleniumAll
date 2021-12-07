package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Start {

	@Test
	public void base() {
		System.out.println("Base");
	}

	@Test(groups= {"Smoke"})
	public void demo() {
		System.out.println("Demo");
	}

	@AfterTest
	public void endTest() {
		System.out.println("THis is the end of Test folder");
	}
}
