package stepDefinations;



import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
public class stepDefination {
	

	@Given("^User is on landing page$")
	public void user_is_on_landing_page() {
		System.out.println("Navigated to landing page");
		
	}
	
    @When("^User login into application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_username_something_and_password_something(String strArg1, String strArg2) throws Throwable {
        //code
    	System.out.println(strArg1);
    	System.out.println(strArg2);
    }

	@Then("^Home page is populated$")
	public void home_page_is_populated() {
		System.out.println("home page");
	}
	
    @And("^cards displayed are \"([^\"]*)\"$")
    public void cards_displayed_are_something(String strArg) throws Throwable {
        if(strArg.equals("true"))
        	System.out.println("Cards are displayed");
        else
        	System.out.println("Cards are not displayed");
        
    }

	
}