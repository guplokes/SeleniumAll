package Assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		Set<String> window=driver.getWindowHandles();
		Iterator<String> itr=window.iterator();
		String parentId=itr.next();
		String childId=itr.next();
		
		//getting text from child window
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".example")).getText());
		
		//getting text from parent window
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	}

}
