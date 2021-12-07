package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaExecutouDemo {
// for scrolling in webTables or at window level
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver; //for window scrolling
		js.executeScript("window.scroll(0,600)");
		Thread.sleep(2500);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500"); //for table scrolling
		
		//css selector nth-child concept
		
		List<WebElement> Amount = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum=0;
		for(int i=0;i<Amount.size();i++) {
			//System.out.println(Integer.parseInt(Amount.get(i).getText()));
			sum = sum + Integer.parseInt(Amount.get(i).getText());
		}
		System.out.println(sum);
		
		String text=driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		
		
		Assert.assertEquals(sum,Integer.parseInt(text));
		
	}

}
