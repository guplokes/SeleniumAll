package Tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Actions a=new Actions(driver);
		driver.manage().window().maximize();
		//driver.findElement(By.className("gb_g")).click();
		a.moveToElement(driver.findElement(By.xpath("//a[@data-pid='2']"))).keyDown(Keys.LEFT_CONTROL).click().build().perform();
		
		//window handles
		
		Set<String> windows = driver.getWindowHandles(); //returns ids of all the windows opened currently(here parent and child windows) in a set
		Iterator<String> itr=windows.iterator();
		String parentId=itr.next();
		String childId=itr.next();
		driver.switchTo().window(childId);
//		driver.findElement(By.cssSelector(".gLFyf.gsfi")).click();
//		driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("Virat kohli");
//		driver.findElement(By.cssSelector("div[class='FAuhyb'] span svg")).click();
		

//		Actions b=new Actions(driver);
//		b.moveToElement(driver.findElement(By.cssSelector(".gLFyf.gsfi"))).click().sendKeys("Virat kohli").build().perform();
//		driver.findElement(By.cssSelector("div[class='FAuhyb'] span svg")).click();
		
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentId);
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(itr.next());

	}

}
