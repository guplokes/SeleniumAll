package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();
		
		//for month
		//Using child-parent Relationship(xpath or css)
		//used xpath child-parent Relationship in while loop condition
		while(!driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='datepicker-switch']")).getText().contains("December")) 
		{
			//used css child-parent Relationship
			driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='next']")).click();
		}

		//List<WebElement> dates = driver.findElements(By.className("day"));
		//int count = driver.findElements(By.className("day")).size();
		
		List<WebElement> dates = driver.findElements(By.xpath("//td[@class='day']"));
		int count = driver.findElements(By.xpath("//td[@class='day']")).size();

		System.out.println(count);
		for(int i=0;i<count;i++) {
			String text=dates.get(i).getText();

			if(text.equalsIgnoreCase("17")){
				//System.out.println("mauja hi mauja");
				dates.get(i).click();
				break;
				
			}
			 
		}

	
	}

}
