package PageObject.Homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
 WebDriver driver;

    public HomePage(WebDriver rDriver) {
        this.driver =rDriver;
        PageFactory.initElements(driver, this);
        rDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @FindBy(className = "oxd-userdropdown-tab")
    WebElement UserDropdown;
    public WebElement getUserDrpdwnElement(){
        return UserDropdown;
    }
}
