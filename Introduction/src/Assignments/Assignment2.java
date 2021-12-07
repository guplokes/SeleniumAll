package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//tis site has been upadated no id and name attribute are present so it also contains updated xptah and css

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//WebElement emt1 = driver.findElement(By.id("Adults"));
		WebElement emt1 = driver.findElement(By.xpath("(//div[@class='col flex flex-middle']//select)[1]"));
		Select adult = new Select(emt1);
		adult.selectByValue("3");
		//WebElement emt2 = driver.findElement(By.id("Childrens"));
		WebElement emt2 =  driver.findElement(By.xpath("(//div[@class='col flex flex-middle']//select)[2]"));
		Select child = new Select(emt2);
		child.selectByValue("1");

		/*
		 * //driver.findElement(By.cssSelector("input[id='DepartDate']")).click();
		 * driver.findElement(By.xpath("//div[@class='col flex flex-middle'])[2]"));
		 * driver.findElement(By.
		 * cssSelector("a[class='ui-state-default ui-state-highlight ui-state-active ']"
		 * )).click();
		 */
		//driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();
		driver.findElement(By.xpath("//strong[@class='pr-1']")).click();

		//driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");
		driver.findElement(By.xpath("(//div[@class='p-relative']/input)[3]")).sendKeys("Lawda");
		Thread.sleep(2000L);
		
		//driver.findElement(By.id("SearchBtn")).click(); // search bUtton
		driver.findElement(By.xpath("//button[normalize-space()='Search flights']")).click(); // search bUtton
		
		//System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		System.out.println(driver.findElement(By.cssSelector("div[class*='container p-fixed ']")).getText());


		/*
		 * driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 * 
		 * //java Alerts :: handling
		 * 
		 * String text="lucky"; driver.findElement(By.id("name")).sendKeys(text);
		 * driver.findElement(By.id("alertbtn")).click(); //switching driver to
		 * alertobject System.out.println(driver.switchTo().alert().getText());
		 * driver.switchTo().alert().accept();
		 * 
		 * //two types of alert button driver.findElement(By.id("name")).sendKeys(text);
		 * driver.findElement(By.id("confirmbtn")).click();
		 * System.out.println(driver.switchTo().alert().getText());
		 * driver.switchTo().alert().dismiss();
		 */

		////////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		 * driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		 * Assert.assertTrue(driver.findElement(By.xpath(
		 * "//input[@id='checkBoxOption1']")).isSelected());
		 * 
		 * driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		 * Assert.assertFalse(driver.findElement(By.xpath(
		 * "//input[@id='checkBoxOption1']")).isSelected());
		 * 
		 * //counting number of check boxes
		 * System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']"))
		 * .size());
		 */

	}

}
