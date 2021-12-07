package guru99.Ecommerce;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Day3Test extends Base {

	WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}

	/*      
	Test Steps:
	1. Goto http://live.techpanda.org/
	2. Click on ‘MOBILE’ menu
	3. In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
	4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button. Expected that an error is displayed 
	   "The requested quantity for "Sony Xperia" is not available.
	5. Verify the error message
	6. Then click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
	7. Verify cart is empty
	 */
	@Test
	public void testcase3() {

		//clicking on mobile link
		driver.findElement(By.cssSelector("a[href*='mobile.html']")).click();
		
		//3. In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
		//driver.findElements(By.xpath("//button[@title='Add to Cart']")).get(2).click();
		driver.findElement(By.xpath("(//button[@class='button btn-cart'])[3]")).click(); //using xpath index concept

		//4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button. Expected that an error is displayed 
		//   "The requested quantity for "Sony Xperia" is not available.
		driver.findElement(By.cssSelector("input[class='input-text qty']")).clear();
		driver.findElement(By.cssSelector("input[class='input-text qty']")).sendKeys("1000");
		driver.findElement(By.xpath("//button[@class='button btn-update']")).click();

		//// 5. Verify the error message
		String errorMsg = driver.findElement(By.cssSelector("p[class='item-msg error']")).getText();
		System.out.println(errorMsg);
		Assert.assertTrue(errorMsg.contains("The maximum quantity allowed for purchase is 500"));
		
		// 6. Click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
		driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]")).click();

		 // 7. Verify cart is empty
		String emptyCart = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		System.out.println(emptyCart);
		Assert.assertTrue(emptyCart.equals("Shopping Cart is Empty"));

	}

	@AfterTest
	public void finish() {
		driver.close();
	}

}
