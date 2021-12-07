package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.RediffHomePage;
import objectRepository.RediffLoginPage;
import objectRepository.RediffLoginPagePF;


public class LoginTest {

	@Test
	public void Login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		RediffLoginPage loginPage = new RediffLoginPage(driver);
		loginPage.email().sendKeys("lokesh123");
		loginPage.password().sendKeys("122u65u");
		loginPage.submit().click();
		loginPage.home().click();
		RediffHomePage homePage = new RediffHomePage(driver);
		homePage.searchBox().sendKeys("Baymax puma");
		homePage.submit().click();
		
		//Example for page Factory
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		RediffLoginPagePF pf = new RediffLoginPagePF(driver);
		pf.email().sendKeys("lillla");
		pf.password().sendKeys("chuhuhu");
		pf.submit().click();
		pf.home().click();
		

	}
}
