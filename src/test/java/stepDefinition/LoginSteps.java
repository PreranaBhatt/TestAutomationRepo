package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps {

	WebDriver driver;
	public LoginPage lPage;
	@Given("user launches chrome browser")
	public void  user_launches_chrome_browser() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver","D:\\PreranaAutomationProject\\TestAutomationRepo\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		lPage = new LoginPage(driver);
	}
	@Given("user Lauches orangehrm website")
	public void user_lauches_orangehrm_website() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	    lPage.getElementCompanyLogo().isDisplayed();
	}
	
	@Then("user logs in to the website as valid user")
	public void user_logs_in_to_the_website_as_valid_user(){
		lPage.performLogin("Admin", "admin123");
	}
	
	@Then("user quit browser")
	public void user_quit_browser() {
		driver.quit();
	}

}
