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
		System.setProperty("webdriver.chrome.driver","D:\\Prerana Workspace\\Project1\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		lPage = new LoginPage(driver);
	}
	@Given("user Lauches orangehrm website")
	public void user_lauches_orangehrm_website() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		lPage.getElementCompanyLogo().isDisplayed();
	}
	@Then("user quit browser")
	public void user_quit_browser() {
		driver.quit();
	}

}
