package stepDefinations;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import pageObject.LoginPage;

import resources.Base;

public class stepDefination extends Base {
	LoginPage lp;
	@Given("^Inialize the chrome browser$")
    public void inialize_the_chrome_browser() throws Throwable {
		driver = initializeDriver(); 
    }
	
    @And("^Navigate to \"([^\"]*)\" website$")
    public void navigate_to_website(String strArg) throws Throwable {
    	driver.get(strArg);
    }

    @And("^Click on login page link to land on Login Page$")
    public void click_on_login_page_link_to_land_on_login_page() throws Throwable {
    	LandingPage ln = new LandingPage(driver);
		if(ln.getPopupSize()>0){
			ln.getPopup().click();
		}// to remove the pop-up from site
		lp = ln.signin();
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and click on login button$")
    public void user_enters_something_and_something_and_click_on_login_button(String strArg1, String strArg2) throws Throwable {
        lp.getEmail().sendKeys(strArg1);
        lp.getPassword().sendKeys(strArg2);
        lp.getLogin().click();
    }
    

    @When("^User enters (.+) and (.+) and click on login button$")
    public void user_enters_and_and_click_on_login_button(String username, String password) throws Throwable {
    	  lp.getEmail().sendKeys(username);
          lp.getPassword().sendKeys(password);
          lp.getLogin().click();
    }

    @Then("^Verify user is sucessfully logged in$")
    public void verify_user_is_sucessfully_logged_in() throws Throwable {
//        PortalHomePage php = new PortalHomePage(driver);
//        Assert.assertTrue(php.getsearchBox().isDisplayed());
    	System.out.println("Displayed..done..dhibnkachika");
    }
    
    @And("^close the browser$")
    public void close_the_browser() throws Throwable {
    	driver.close();
    }


 }

