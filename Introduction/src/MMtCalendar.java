import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MMtCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("div[id='SW']")).click();
		
		driver.findElement(By.cssSelector("div[class='fsw_inputBox dates inactiveWidget ']")).click();
		
		String text = driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1] //div[@class='DayPicker-Caption']/div")).getText();
		System.out.println(text);
		while(!(text.contains("November"))) {
			System.out.println(text);
			driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']/span[2]")).click();
			text = driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1] //div[@class='DayPicker-Caption']/div")).getText();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("(//div[@class='DayPicker-Month'])[1]  //div[@class='dateInnerCell']"));
		int size = dates.size();
		
		for(int i=0;i<size;i++) {
			System.out.println(dates.get(i).getText());
			if(dates.get(i).getText().contains("13")) {
				dates.get(i).click();
				driver.close();
		}
	}

}
}
