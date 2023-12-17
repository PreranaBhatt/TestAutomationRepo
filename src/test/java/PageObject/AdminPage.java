package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdminPage extends BasePage{
WebDriver driver;

    public AdminPage(WebDriver rdriver) {
        super(rdriver);
        driver=rdriver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/h6")
    WebElement PageHeading;

    @FindBy(xpath = "//label[text()='User Role']/../../div/div[@class='oxd-select-wrapper']/div")
    WebElement UserRoleDrpDwn; // this is select class

    @FindBy(xpath = "//label[text()='Status']/../../div/div[@class='oxd-select-wrapper']/div")
    WebElement UserStatusDrpDwn; // this is select class

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
    WebElement recordFoundTxt;

    @FindBys(
    @FindBy(xpath = "//span[ @class = 'oxd-topbar-body-nav-tab-item']"))
    List<WebElement> PageSubHeading;


    public void isPageHeadingisDisaplyed(){
        Assert.assertTrue(PageHeading.isDisplayed());}

    public void verifyAllSubTabs() {

        for (WebElement ele:PageSubHeading) {
            ele.isDisplayed();
        }
    }

    public void selectUserRole() throws InterruptedException {
     UserRoleDrpDwn.click();
   List<WebElement> ele=  driver.findElements(By.xpath("//div[@class='oxd-select-wrapper']/div/div[@class='oxd-select-option']/span"));
       for (WebElement e: ele) {
            if(e.getText().equals("Admin")){
                e.click();
                break;
            }
        }
    }

    public void clickOnSearchButton() throws InterruptedException {
     searchButton.click();
    }

    public void selectStatus() throws InterruptedException {
     UserStatusDrpDwn.click();
        List<WebElement> ele=  driver.findElements(By.xpath("//div[@class='oxd-select-wrapper']/div/div[@class='oxd-select-option']/span"));
        for (WebElement e: ele) {
            System.out.println(e.getText());
            if(e.getText().equals("Enabled")){
                e.click();
                break;
            }
        }
    }

    public void verifySearchResultScreen() {
        Assert.assertTrue(recordFoundTxt.isDisplayed());
    }
}
