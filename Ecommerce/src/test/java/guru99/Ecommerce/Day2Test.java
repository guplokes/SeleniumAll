package guru99.Ecommerce;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Day2Test extends Base {

	WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
		
	}
	
	//"Verify that cost of product "Sony Xperia" in list page and details page are equal"
	/*      
	Test Steps:
	1. Goto http://live.techpanda.org/
	2. Click on ‘MOBILE’ menu
	3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
	4. Click on Sony Xperia mobile
	5. Read the Sony Xperia mobile from detail page. Product value in list and details page should be equal ($100). 
	*/
	@Test
	public void testcase2() {
		
		//clicking on mobile link
		driver.findElement(By.cssSelector("a[href*='mobile.html']")).click();
		
		// In the list of all mobile , read the cost of Sony Xperia mobile (which is $100) 
		String listpagePice = driver.findElement(By.xpath("//span[@id='product-price-1']/span")).getText();
		System.out.println(listpagePice);
		
		//clicking on details page
		driver.findElement(By.cssSelector("a[href*=sony-xperia]")).click();
		
		//Read the XPeria mobile price from details page		
		String detailpagePrice = driver.findElement(By.cssSelector("span.price")).getText();
		System.out.println(detailpagePrice );
		
		//Product price in list and details page should be equal ($100)
		Assert.assertTrue(listpagePice.equals(detailpagePrice));
		}
	
	@AfterTest
	public void finish() {
		driver.close();
	}
}
