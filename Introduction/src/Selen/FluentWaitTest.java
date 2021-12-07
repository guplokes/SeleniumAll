package Selen;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		
		//for help--  https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html
		
		
		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed())
		    		 return driver.findElement(By.cssSelector("div[id='finish'] h4"));
		    	 else
		    		 return null;
		     }
		   });
         	
			System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());     
			     }
			     
			     
		   }


