package Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//find broken links based on status code
		//Java methods will call the URL's and get u the status code
		
		
		
		//1. to get all url's tied upto all links
		//2.get status code
		//3. if status code>400 then link is broken link
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		//driver.findElement(By.linkText("REST API")).click();
		//a[href*='restapi'] ---customize css
		
		
		SoftAssert a = new SoftAssert(); //SoftAssert class
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a")) ;//all the links in the footer section
		for(WebElement link : links) {
			
			String url=link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			
			//a.assertTrue(condition, message)
			a.assertTrue(responseCode<400,"The broken link is " + link.getText() + " with response code s" + responseCode );
			
		}
		
		
		a.assertAll(); //To report all the failures
		
		/*
		 * String url =
		 * driver.findElement(By.cssSelector("a[href*='apache']")).getAttribute("href");
		 * System.out.println(url);
		 * 
		 * URL u = new URL(url); HttpURLConnection conn =
		 * (HttpURLConnection)u.openConnection(); conn.setRequestMethod("HEAD"); int
		 * responseCode = conn.getResponseCode(); System.out.println(responseCode);
		 */
		
	}

}
