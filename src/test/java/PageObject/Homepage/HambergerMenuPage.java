package PageObject.Homepage;

import PageObject.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HambergerMenuPage extends BasePage {
    WebDriver driver;
    public HambergerMenuPage(WebDriver rdriver){
        super(rdriver);
        this.driver = rdriver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-chevron-left\"]")
    WebElement DashboardMenuLeftIcon;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-chevron-right\"]")
    WebElement DashboardMenuRightIcon;


    private WebElement getDashboardIcon(){
      return DashboardMenuLeftIcon;
    }

    public void verifyDashboardMenuIsCollapsable(){
        DashboardMenuLeftIcon.click();
        Assert.assertTrue("menu should have collapse",DashboardMenuRightIcon.isDisplayed());
    }
}
