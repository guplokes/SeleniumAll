package Selen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class staticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		System.out.println("This is demo Git practice");
		/*
		 * To undrstand static Dropdown--------(Select dropdown)
		 * -------------------------
		 */

		WebElement element = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select dropdown = new Select(element);

		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.close();

	}

}
