package TestNG;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Start2 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("this method executes before any method in the class Start22222222222");
	}

	@Test(groups= {"Smoke"})
	public void starter() {
		System.out.println("This is the starter pack");
		Assert.assertTrue(false);
	}

	@BeforeTest
	public void prerequisite() {
		System.out.println("Test folder is starting");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is the no. 1 from first i.e Before Suite");
	}
}