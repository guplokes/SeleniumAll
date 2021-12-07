package Selen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// handling static dropdown

		/*
		 * driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		 * 
		 * driver.findElement(By.id("divpaxinfo")).click();
		 * driver.findElement(By.id("hrefIncAdt")).click();
		 * driver.findElement(By.id("hrefIncAdt")).click();
		 * driver.findElement(By.id("btnclosepaxoption")).click();
		 */

		// handling dynamic dropdown

		

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		//driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();

		Thread.sleep(2000);

		// driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click(); //it was
		// using index

		// alternative to index: parent-child relationship X-path

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']"))
				.click();

	}
}
