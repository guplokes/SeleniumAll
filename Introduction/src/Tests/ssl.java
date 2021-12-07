package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ssl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * //for firefox //or u can also use Firefox Profile concept to handle ssl i
		 * firefox DesiredCapabilities ff = DesiredCapabilities.firefox();
		 * ff.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 * ff.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 * 
		 * // FirefoxOptions fo = new FirefoxOptions(); // fo.merge(ff);
		 * 
		 * 
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Selenium\\geckodriver.exe"); WebDriver driver = new FirefoxDriver(ff);
		 * 
		 */
				
		String baseurl = "https://expired.badssl.com/";
		
		//for chrome
		//Desired capabilities=
		//general chrome profile
		DesiredCapabilities ch=DesiredCapabilities.chrome();
		//ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		//Belows to your local browser
		ChromeOptions c= new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(c);
		
		driver.get(baseurl);

	}

}
