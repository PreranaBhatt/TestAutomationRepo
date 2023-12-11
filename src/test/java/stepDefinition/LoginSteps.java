package stepDefinition;

import Utilities.Helper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;

public class LoginSteps extends BaseStep {

	@Given("user launches chrome browser")
	public void  user_launches_chrome_browser() {
		lpage = new LoginPage(Helper.getDriver());
	}
	@Given("user Launches orangehrm website")
	public void user_lauches_orangehrm_website() throws InterruptedException {
		//Helper.getDriver().get("https://opensource-demo.orangehrmlive.com/");
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
