package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD {
	@Given("User is Netbanking landing page")
	public void user_is_netbanking_landing_page() {
	   System.out.println("User is Netbanking landing page");
	}

	@When("User login into applicaton with {string} and password {string}")
	public void user_login_into_applicaton_with_and_password(String string1, String string2) {
		System.out.println("User login into applicaton with and password");
		System.out.println(string1);
		System.out.println(string2);
	}

	@Then("Home page is populated")
	public void home_page_is_populated() {
		System.out.println("Home page is populated");
	}
	
	@Then("Cards displayed is {string}")
	public void cards_displayed_is(String string1) {
		System.out.println("Cards displayed is "+string1);
	}

}
