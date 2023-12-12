package stepDefinition;

import PageObject.Homepage.HambergerMenuPage;
import PageObject.Homepage.HomePage;
import PageObject.LoginPage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseStep {
    public LoginPage lpage;
    HambergerMenuPage hpage;
    HomePage homepage;
}
