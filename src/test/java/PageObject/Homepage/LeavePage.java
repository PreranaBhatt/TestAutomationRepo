package PageObject.Homepage;

import PageObject.BasePage;
import Utilities.DateUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeavePage extends BasePage {
    WebDriver driver;
    String givenFromDate;

    public LeavePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//h6[text( )='Leave']")
    WebElement LeavePageHeading;
    @FindBy(xpath="//label[text()='From Date']/../../div/div[@class='oxd-date-wrapper']")
    WebElement fromDateDrpdwn;
    @FindBy(xpath="//label[text()='To Date']/../../div/div[@class='oxd-date-wrapper']")
    WebElement toDateDrpdwn;
    @FindBy(xpath="//label[text()='From Date']/../../../div/div/div/div/input[@placeholder='yyyy-mm-dd']")
    WebElement fromDateDrpdwnInputBox;
    @FindBy(xpath="//label[text()='To Date']/../../../div/div/div/div/input[@placeholder='yyyy-mm-dd']")
    WebElement toDateDrpdwnInputBox;
    @FindBy(xpath = "//div[@class='oxd-multiselect-wrapper']")
    WebElement leaveStatus;

    @FindBys(@FindBy(xpath = "//label[ text( )='Show Leave with Status']/../../div/div/div[@role='listbox']/div/span"))
    List<WebElement> leaveStatusOption;
    @FindBy(xpath = "//button[@type='submit']")
   WebElement searchButton;
    @FindBy(xpath = "//label[text()='Leave Type']/../../div/div")
   WebElement leaveTypeDrpdwn;
    @FindBys(@FindBy(xpath = "//label[ text( )='Leave Type']/../../div/div/div[@role='listbox']/div/span"))
    List<WebElement> leaveTypeOption;
     @FindBys(@FindBy(xpath = "//span[@class='oxd-chip oxd-chip--default oxd-multiselect-chips-selected']/i"))
    List<WebElement> multiselectleaveTypeOptionCrosBtn;
     @FindBy(xpath="//div[@class='oxd-toast-content oxd-toast-content--info']")
     WebElement toastMessage;

    public WebElement getPageHeading(){
      return LeavePageHeading;
    }

    public void selectFromDate() {
        fromDateDrpdwnInputBox.click();
        setfromDateDrpdwn();
    }
    private void setfromDateDrpdwn()  {
        givenFromDate =  DateUtils.getCurrentDate();
        if(!fromDateDrpdwnInputBox.getAttribute("value").isEmpty()){
        fromDateDrpdwnInputBox.sendKeys(Keys.CONTROL + "a");
        fromDateDrpdwnInputBox.sendKeys(Keys.DELETE);}
        fromDateDrpdwnInputBox.sendKeys(givenFromDate);
    }

    public void selectToDate() {
        toDateDrpdwnInputBox.click();
        setToDateDrpdwn();
    }
    // selecting a week time off
    //adding 7 days to current date
    private void setToDateDrpdwn() {
        if(!toDateDrpdwnInputBox.getAttribute("value").isEmpty()){
            toDateDrpdwnInputBox.sendKeys(Keys.CONTROL + "a");
            toDateDrpdwnInputBox.sendKeys(Keys.DELETE);}
       String toDate= DateUtils.addNumberOfDaysinDate(7);
       toDateDrpdwnInputBox.sendKeys(toDate);
    }

    public void selectLeaveStatus(String leaveType) {

        if(!multiselectleaveTypeOptionCrosBtn.isEmpty()) {
            for (WebElement ele:multiselectleaveTypeOptionCrosBtn) {
                ele.click();
                break;
            }
        }

        leaveStatus.click();
        for (WebElement ele:leaveStatusOption) {
            if(ele.getText().equals(leaveType)){
                ele.click();break;
            }
        }
    }
    public void selectLeaveType(String type) {
        leaveTypeDrpdwn.click();
        for (WebElement ele:leaveTypeOption) {
            if(ele.getText().equals(type)){
                ele.click();break;
            }
        }
    }
    public void clickOnSearchButton() {
        searchButton.click();
    }
    public void verifySearchResult() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(toastMessage.isDisplayed());
    }
}
