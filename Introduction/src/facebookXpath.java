import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		 driver.get("https://www.facebook.com/");

//		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("guplokes");
//		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("paasssu");
//		driver.findElement(By.xpath("//button[@name='login']")).click();

		
		  driver.findElement(By.cssSelector("input#email")).sendKeys("guplpkes");
		  driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("passsu");
		  driver.findElement(By.cssSelector("[name='login']")).click();
		 

//		driver.get("https://www.google.com");
//		driver.findElement(By.xpath("//div[@class='LX3sZb']/div/div/div/div/div[2]/a")).click();

	}

}
