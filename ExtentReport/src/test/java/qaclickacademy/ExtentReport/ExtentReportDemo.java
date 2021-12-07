package qaclickacademy.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extent;
	
	
	@BeforeTest
	public void config() {
		//ExtentSparkReporter and ExtentReports class
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Report"); //changing configuration of report i.e, report name
		report.config().setDocumentTitle("Test Results");////changing configuration of report i.e, report Title
		//***********************************************************************************
		extent = new ExtentReports();//ExtentReports extent is global
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Lokesh Gupta"); // Putting the name of tester in Report
		
	}
	@Test
	public void initialDemo() {
		ExtentTest Test = extent.createTest("Initial Demo"); // ExtentTest object is responsible for the test
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getTitle());
		driver.close();
		Test.fail("Test Fail kra diya");
		extent.flush();
	}

}
