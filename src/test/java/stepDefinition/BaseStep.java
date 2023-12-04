package stepDefinition;

import PageObject.LoginPage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;

public class BaseStep {
    WebDriver driver= null;
    public WebDriver getBrowser(String browser){
        if(browser.equals("chrome")){
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("stable");
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            return driver;
        }
        else{
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            FirefoxOptions options = new FirefoxOptions();
            options.setBrowserVersion("stable");
            driver = new FirefoxDriver(options);
            return driver;
        }
    }
}
