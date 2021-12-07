package guru99.Ecommerce;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Day4Test extends Base {
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
	public void testcase4() throws IOException, InterruptedException {

		//String[] phones = { "SONY XPERIA", "IPHONE" };
		// clicking on mobile link
		driver.findElement(By.cssSelector("a[href*='mobile.html']")).click();

		// Elemnts getting stale in this approach

		//List<String> phonesList = Arrays.asList(phones);
		/*
		 * List<WebElement> itemList =
		 * driver.findElements(By.xpath("//h2[@class='product-name']/a"));
		 * System.out.println(itemList.size());
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver,20); // List<WebElement>
		 * addToCart = // driver.findElements(By.xpath("//a[@class='link-compare']"));
		 * // System.out.println(addToCart.size());
		 * 
		 * for (int i = 0; i < itemList.size(); i++) { String text =
		 * itemList.get(i).getText();
		 * 
		 * // if the name of phone matches than click on add to comapare for that
		 * product if (phonesList.contains(text)) {
		 * //wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(
		 * "//a[@class='link-compare']"))));
		 * //wait.until(ExpectedConditions.visibilityOf(driver.findElements(By.xpath(
		 * "//a[@class='link-compare']")).get(i)));
		 * wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver
		 * .findElements(By.xpath("//a[@class='link-compare']")).get(i))));
		 * driver.findElements(By.xpath("//a[@class='link-compare']")).get(i).click();
		 * driver.navigate().refresh();
		 * //wait.until(ExpectedConditions.stalenessOf(driver.findElements(By.xpath(
		 * "//a[@class='link-compare']")).get(i))); }
		 * 
		 * }
		 */

		// click on add to compare for sony xperia mobile
		driver.findElement(By.xpath("(//a[@class='link-compare'])[2]")).click();
		String mainMobile1 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
		System.out.println(mainMobile1);

		// click on add to compare for Iphone mobile
		driver.findElement(By.xpath("(//a[@class='link-compare'])[3]")).click();
		String mainMobile2 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
		System.out.println(mainMobile2);

		driver.findElement(By.cssSelector("button[title='Compare']")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();

		String parent = itr.next(); // parent window
		String childPopup = itr.next(); // child window

		System.out.println(driver.getCurrentUrl());
		// driver.switchTo().window(parent);

		driver.switchTo().window(childPopup);
		System.out.println(driver.getCurrentUrl());
		//Thread.sleep(2000L);
		String text = driver.findElement(By.xpath("//h1[text()='Compare Products']")).getText();
		Assert.assertEquals(text, "COMPARE PRODUCTS");
		System.out.println("true");

		List<WebElement> compareItems = driver.findElements(By.xpath("//h2[@class='product-name']"));

		for (WebElement m : compareItems) {
			System.out.println(m.getText());
			if (m.getText().equals(mainMobile1) || m.getText().equals(mainMobile2))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		}

		driver.close();
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());

	}

	@AfterTest
	public void finish() {
		driver.close();
	}
}
