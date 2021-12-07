package guru99.Ecommerce;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Day1Test extends Base {
	WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);

	}

	/*
	 * Test Steps Step 1. Goto http://live.techpanda.org/ Step 2. Verify Title of
	 * the page Step 3. Click on ‘MOBILE’ menu Step 4. Verify Title of the page Step
	 * 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’ Step 6.
	 * Verify all products are sorted by name
	 */
	@Test
	public void testcase1() throws IOException {

		String expectedHomeTitle = "THIS IS DEMO SITE FOR   ";
		String expectedMobileTitle = "MOBILE";

		// Verifying the tiltle of Home Page
		String actualHomeTitle = driver.findElement(By.cssSelector("h2")).getText();
		System.out.println(actualHomeTitle);
		Assert.assertEquals(actualHomeTitle, expectedHomeTitle);

		// clicking on mobile link
		driver.findElement(By.cssSelector("a[href*='mobile.html']")).click();

		// Verifying the tiltle of Mobile Page
		String actualMobileTitle = driver.findElement(By.cssSelector("h1")).getText();
		System.out.println(actualMobileTitle);
		Assert.assertEquals(actualMobileTitle, expectedMobileTitle);

		// select ‘SORT BY’ dropdown as ‘name’
		WebElement element = driver.findElement(By.cssSelector("select[title='Sort By']"));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText("Name");

		// Taking screenshot to verify all the products sorted by "Name"
		getScreenshot("VerifyProductsName");

	}

	@AfterTest
	public void finish() {
		driver.close();
	}
}
