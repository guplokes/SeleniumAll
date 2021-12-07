package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {

	public  WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser"); //this is using property file

		if(browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");			
			driver = new ChromeDriver();
		}

		else if(browserName.equals("firefox"))  {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();		
			driver.get(prop.getProperty("url"));
		}

		else if(browserName.equals("IE")){
			//code foe internet explorer
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		return driver;

	}
	
	
	public void getScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String filePath = "C:\\Users\\guplokes\\selenium\\Guru99Bank\\Screenshot\\managerlogin.png";
		FileUtils.copyFile(src, new File(filePath));
	}


}
