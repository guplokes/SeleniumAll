import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> itr = handles.iterator(); 
		String parentId = itr.next();
		String childId =itr.next();
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/");
		
		String str = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentId);
		
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(str);
		//driver.quit();
		
		//Taking screenshot of WebElement{Partial Screenshot}
		File src = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("webelement.jpg"));
		
		//get height and width of web element
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		



	}

}
