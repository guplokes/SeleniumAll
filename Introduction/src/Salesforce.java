
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com/?locale=in");
//		driver.findElement(By.id("username")).sendKeys("lokesh");
//		driver.findElement(By.id("password")).sendKeys("12345678");
//		driver.findElement(By.className("button r4 wide primary")).click();
//		driver.findElement(By.cssSelector(".button.r4.wide.primary")).click();
		
		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("lokesh");
		driver.findElement(By.cssSelector("#password")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\'error\']")).getText());
		
		
			

	}

}
