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

public class Day5Test extends Base {
	WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);

	}

	@Test
	public void testcase5() throws IOException {

		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/a")).click();

		// clicking on my account in Account header
		driver.findElement(By.xpath("//div[@id='header-account'] //a[@title='My Account']")).click();

		// click on create Account link
		driver.findElement(By.cssSelector("a[title='Create an Account'] span")).click();

		// first name
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Lokesh");
		// lastnmae
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Ji");
		// email
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("loka234@gmail.com");
		// password
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("12345678");
		// confirm password
		driver.findElement(By.id("confirmation")).clear();
		driver.findElement(By.id("confirmation")).sendKeys("12345678");

		// Register
		driver.findElement(By.xpath("//span[text()='Register']")).click();

		String successMsg = "Thank you for registering with Main Website Store.";
		String text = driver.findElement(By.cssSelector("li.success-msg")).getText();
		Assert.assertEquals(text, successMsg);

		// going to TV zone
		driver.findElement(By.cssSelector("a[href*='tv.html']")).click();

		// adding tv to wishlist
		driver.findElement(By.xpath("(//a[@class='link-wishlist'])[1] ")).click();

		// sharing wishlist
		driver.findElement(By.xpath("//span[text()='Share Wishlist']")).click();

		driver.findElement(By.id("email_address")).sendKeys("loka234@gmail.com");
		driver.findElement(By.id("message")).sendKeys("I Love thi TV , please look into its cool specifications");

		driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();

		String sharedMsg = "Your Wishlist has been shared.";
		String text2 = driver.findElement(By.cssSelector("li.success-msg")).getText();
		Assert.assertEquals(text2, sharedMsg);

	}

	@AfterTest
	public void finish() {
		driver.close();
	}
}
