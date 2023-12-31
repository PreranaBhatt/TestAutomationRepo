package stepDefinition;

import PageObject.LoginPage;
import Utilities.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps extends BaseStep {

	@Given("user launches chrome browser")
	public void  user_launches_chrome_browser() {
		lpage = new LoginPage(Helper.getDriver());
	}
	@Given("user Launches orangehrm website")
	public void user_lauches_orangehrm_website() throws InterruptedException {
        Helper.openPage("https://opensource-demo.orangehrmlive.com/");
		lpage.getElementCompanyLogo().isDisplayed();
	}
	@Then("user logs in to the website as valid user")
	public void user_logs_in_to_the_website_as_valid_user(){
		lpage.performValidLogin("Admin", "admin123");
	}
	@Then("user logs in to the website as Invalid user")
	public void user_logs_in_to_the_website_as_Invalid_user(){
		lpage.performInvalidLogin("InvalidAdmin", "invalid");
	}
}
