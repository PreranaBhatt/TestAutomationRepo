package PageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
    WebDriverWait wait;
	public LoginPage(WebDriver rDriver) {
		PageFactory.initElements(rDriver, this);
		rDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		

	@FindBy(xpath="//img[contains(@alt ,'company-branding')]")
	WebElement companyLogo;

	@FindBy(name = "username")
	WebElement UserName;

	@FindBy(name="password")
	WebElement PassWord;

	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
	public void setUserName(){
		UserName.clear();
		UserName.sendKeys("Admin");
	}
	public void setPassword(){
		PassWord.clear();
		PassWord.sendKeys("admin123");
	}
	public void clickLoginButton(){
		loginButton.click();
	}
	public WebElement getElementCompanyLogo() {
		return companyLogo;
	}
}
