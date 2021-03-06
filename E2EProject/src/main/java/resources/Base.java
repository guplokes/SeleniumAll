package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {
	
	public  WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		//System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		
		String browserName = prop.getProperty("browser"); //this is using property file
		
		//mvn test -Dbrowser=chrome   Using argument from maven at runtime instead of Properties file
		//String browserName = System.getProperty("browser");//this is using parameter from maven and jenkins(not using this for cucumber**)
		
		
		if(browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			//ChromeOptions is used for running testcases in background i.e headless browser
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("IE")){
			//code foe internet explorer
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
				
	}
	
	//Screenshot method
	public String getScreenshotPath(String testMethodName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String destinationPath = System.getProperty("user.dir") + "\\Reports\\" + testMethodName + ".png"; //name of the screenshot with location
		
		//FileUtils.copyFile(src, new File(""));
		FileHandler.copy(src, new File(destinationPath));
		
		return destinationPath;
		
	}
}
