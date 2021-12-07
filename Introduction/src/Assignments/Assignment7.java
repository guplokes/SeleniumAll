package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		int row = driver.findElements(By.cssSelector(".table-display tr")).size();
		System.out.println("number of rows:-" + row);
		
		int col=driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td")).size();
		System.out.println("number of columns:-" + col);
		
		//data in second row
		for(int i=0;i<col;i++) {
			System.out.println(driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td")).get(i).getText());
		}
		
		

	}

}





/*
 * ExaMple of Assignment 7 done by rahul shetty using concept of nested driver
 * 
 * 
 * 
 * public class A3 {
 * 
 * 
 * 
 * public static void main(String[] args) {
 * 
 * 
 * 
 * // TODO Auto-generated method stub
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
 * 
 * 
 * 
 * WebDriver driver=new ChromeDriver();
 * 
 * 
 * 
 * driver.get("http://qaclickacademy.com/practice.php");
 * 
 * 
 * 
 * WebElement table=driver.findElement(By.id("product"));
 * 
 * 
 * 
 * System.out.println(table.findElements(By.tagName("tr")).size());
 * 
 * 
 * 
 * System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(
 * By.tagName("th")).size());
 * 
 * 
 * 
 * List<WebElement>
 * secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName
 * ("td"));
 * 
 * 
 * 
 * System.out.println(secondrow.get(0).getText());
 * 
 * 
 * 
 * System.out.println(secondrow.get(1).getText());
 * 
 * 
 * 
 * System.out.println(secondrow.get(2).getText());
 * 
 * }
 * 
 * }
 */