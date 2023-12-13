package PageObject.Homepage;

import PageObject.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HambergerMenuPage extends BasePage {
    WebDriver driver;
    public List<String> ExpectedContentList;
    public List<String> Actualcontent;
    public HambergerMenuPage(WebDriver rdriver){
        super(rdriver);
        this.driver = rdriver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-chevron-left\"]")
    WebElement DashboardMenuLeftIcon;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-chevron-right\"]")
    WebElement DashboardMenuRightIcon;

    @FindBy(xpath = " //div[@class=\"oxd-main-menu-search\"]/input")
    WebElement menuSearchIcon;

    @FindBy(xpath = "//h6[text()=\"Personal Details\"]")
    WebElement elePersonalDetail;

    @FindBys(@FindBy(xpath = "//ul[@class='oxd-main-menu']/li/a/span"))
    List<WebElement> menuList;

    private WebElement getDashboardIcon(){
      return DashboardMenuLeftIcon;
    }

    public void verifyDashboardMenuIsCollapsable(){
        DashboardMenuLeftIcon.click();
        Assert.assertTrue("menu should have collapse",DashboardMenuRightIcon.isDisplayed());
    }

    public void verifyHambergerMenuSectionList() {
        Assert.assertEquals("hamberger menu list count should be 12",12,menuList.size());
    }

    public void verifyAllHambergerMenuTitles() {
        ExpectedContentList = Arrays.asList("Admin","PIM","Leave","Time","Recruitment","My Info","Performance","Dashboard","Directory","Maintenance","Claim","Buzz");
        if(Actualcontent==null){
            Actualcontent = new ArrayList<>();
        }
        for (WebElement element : menuList) {
            Actualcontent.add(element.getText());
        }
        Assert.assertEquals(ExpectedContentList,Actualcontent);
    }

    public void clickOnSearchBar() {
        menuSearchIcon.click();
    }

    public void performSearch(String searchKey) throws InterruptedException {
        menuSearchIcon.sendKeys(Keys.CLEAR);
    menuSearchIcon.sendKeys(searchKey);
    menuSearchIcon.sendKeys(Keys.ENTER);

    menuList.get(0).click();

    Thread.sleep(10000);
    Assert.assertTrue(elePersonalDetail.isDisplayed());
    }
}
