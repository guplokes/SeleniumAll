package Selen;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.cssSelector("li[data-cy='account']")).click();
		driver.findElement(By.id("username")).sendKeys("9424568");
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();
		
		//to search hotel in 
		driver.findElement(By.id("booking_engine_hotels")).click();
		driver.findElement(By.xpath("search")).sendKeys("Dub");
		String str = "Dubai Coast";
		List<WebElement> list = driver.findElements(By.xpath("avav"));
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().equals(str))
				list.get(i).click();
				
		}
		
		driver.findElement(By.xpath("date")).click();
		driver.findElement(By.cssSelector("traveller")).click();
		driver.findElement(By.xpath("search")).click();
	}

	
//swapping the numbers	
	int a=15,b=23;
	int temp;
	temp=a;
	a=b;
	b=temp;
}
