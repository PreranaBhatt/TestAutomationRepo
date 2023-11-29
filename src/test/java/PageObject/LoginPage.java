package PageObject;

import java.time.Duration;

import org.junit.Assert;
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
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
	WebElement DashboardText;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement InvalidCredentialText;
	
	public void setUserName(String userName){
		UserName.clear();
		UserName.sendKeys(userName);
	}
	public void setPassword(String pwd){
		PassWord.clear();
		PassWord.sendKeys(pwd);
	}
	public void clickLoginButton(){
		loginButton.click();
	}
	public WebElement getElementCompanyLogo() {
		return companyLogo;
	}
	public WebElement getElementDashboard() {
		return DashboardText;
	}
	public WebElement getElementInvalidCredText() {
		return InvalidCredentialText;
	}
	
	public void performValidLogin(String name,String pwd) {
		setUserName(name);
		setPassword(pwd);
		clickLoginButton();
		Assert.assertTrue(getElementDashboard().isDisplayed());
	}
	
	public void performInvalidLogin(String name,String pwd) {
		setUserName(name);
		setPassword(pwd);
		clickLoginButton();
		Assert.assertTrue(getElementInvalidCredText().isDisplayed());
	}
}
