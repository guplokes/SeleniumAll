
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;



	public class RelLocators {

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			WebElement nameEditbox = driver.findElement(By.xpath("//input[@name='name']"));
			System.out.println(driver.findElement(withTagName("label").above(nameEditbox)).getText());
			
			//Below relative locator
			WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
			driver.findElement(withTagName("input").below(dob)).sendKeys("01/01/1996");
			
			WebElement icecreamLabel = driver.findElement(By.xpath("//label[text() ='Check me out if you Love IceCreams!' ]"));
			driver.findElement(withTagName("input").toLeftOf(icecreamLabel)).click();
			
			WebElement radio = driver.findElement(By.id("inlineRadio1"));
			System.out.println(driver.findElement(withTagName("label").toRightOf(radio)).getText());
			
			
			
			

}
	}
