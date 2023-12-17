package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Helper {
public static Helper helper;
    public static WebDriver driver;
    static String givenBrowser;

    public static void tearDown(){
        if(driver !=null){
            driver.close();
            driver.quit();
        }
        helper=null;
    }

    public static WebDriver setUpDriver(){
         givenBrowser="chrome";

        if(givenBrowser.equals("chrome")){
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("stable");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
          //  options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);}
        else{
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            FirefoxOptions options = new FirefoxOptions();
            options.setBrowserVersion("stable");
            driver = new FirefoxDriver(options);
        }
        driver.manage().window().maximize();
        return driver;
}
    public static WebDriver getDriver(){
        return driver;
    }
    public static void openPage(String url) {
        driver.get(url);
    }
    public static String getTitle() {
        return driver.getTitle();
    }
}
