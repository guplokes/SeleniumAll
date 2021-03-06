package guru99.Ecommerce;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Day6Test extends Base {

	WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	@Test
	public void testcase6() throws IOException {
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/a/span[2]")).click();
		driver.findElement(By.xpath("//a[@title='Log In']")).click();
		
		//entering user email
		driver.findElement(By.cssSelector("input[title='Email Address']")).sendKeys("loka234@gmail.com");
		
		//entering password
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("12345678");
		
		driver.findElement(By.id("send2")).click();
		
		//selecting My Wishlist
		//driver.findElement(By.xpath("//div[@class='block-content']/ul/li[8]")).click();
		driver.findElement(By.linkText("MY WISHLIST")).click();
		
		//click on add to cart button
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		
		//Selecting country in dropdown
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByValue("US");
		
		//Selecting region in dropdown
		Select region = new Select(driver.findElement(By.id("region_id")));
		region.selectByValue("41");
		
		driver.findElement(By.id("postcode")).sendKeys("542896");
		driver.findElement(By.xpath("//button[@title='Estimate']")).click();//clicking on estimate
		String shipPrice = driver.findElement(By.cssSelector("label[for*='s_method']>span")).getText();
		//int price2 = Integer.parseInt(shipPrice.substring(1));
		Assert.assertEquals("$5.00", shipPrice);
		driver.findElement(By.name("estimate_method")).click();
		driver.findElement(By.cssSelector("button[title='Update Total']>span")).click(); //upadting total
		
		//String cartPrice = driver.findElement(By.xpath("(//span[@class='cart-price'])[2]")).getText();
		//int price1 = Integer.parseInt(cartPrice.substring(1));
		
		//String totalPrice = driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]")).getText();
		//int tprice = Integer.parseInt(totalPrice.substring(1)
	
		driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click(); //proceed to checkout
		
		//System.out.println(driver.findElement(By.id("billing-address-select")).isDisplayed());
		
		//checking if user is ordering first or have ordered before
		if(driver.findElement(By.id("billing-address-select")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@onClick='billing.save()']")).click(); //click on continue
		}
		else {		
		
		//entering the shipping details
		driver.findElement(By.xpath("//input[@title='Street Address']")).sendKeys("Bank Road"); //street name
		driver.findElement(By.xpath("//input[@title='City']")).sendKeys("New York");
		Select billingRegion = new Select(driver.findElement(By.id("billing:region_id")));
		billingRegion.selectByValue("43");
		driver.findElement(By.id("billing:postcode")).sendKeys("542896");
		Select billingCountry = new Select(driver.findElement(By.id("billing:country_id")));
		billingCountry.selectByValue("US");
		driver.findElement(By.id("billing:telephone")).sendKeys("3476787871");
		
		
		}
		
		driver.findElement(By.xpath("//button[@onClick='shippingMethod.save()']")).click(); //click on continue
		
		driver.findElement(By.cssSelector("[title='Check / Money order']")).click(); //click on check/money order
		driver.findElement(By.cssSelector("[onClick='payment.save()']")).click(); //click on continue
		
		driver.findElement(By.cssSelector("[title='Place Order']")).click(); //Placing order
		
		String text = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		System.out.println(text);
		Assert.assertTrue(text.equalsIgnoreCase("Your order has been received."));
		String orderId = driver.findElement(By.cssSelector("a[href*='order/view/order_id']")).getText();
		
		
	}

}
