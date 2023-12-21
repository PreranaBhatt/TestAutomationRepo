package stepDefinition;

import PageObject.Homepage.LeavePage;
import Utilities.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LeaveSteps extends BaseStep{

    @Then("User on leave page selects from-Date")
    public void userOnLeavePageSelectsFromDate() {
        new LeavePage(Helper.getDriver()).selectFromDate();
    }
    @Then("User on leave page select leave with status as (.*) type$")
    public void userOnLeavePageSelectLeaveWithStatusAsScheduledType(String statusType) {
        new LeavePage(Helper.getDriver()).selectLeaveStatus(statusType);
    }
    @And("User on Leave page selects to-date")
    public void userOnLeavePageSelectsToDate() {
        new LeavePage(Helper.getDriver()).selectToDate();
    }
    @And("User on Leave page selects leave type as (.*)$")
    public void userOnLeavePageSelectsLeaveTypeasvacation(String leaveType) {
        new LeavePage(Helper.getDriver()).selectLeaveType(leaveType);
    }
    @Then("User click on SearchButton")
    public void userClickOnSearchButton() throws InterruptedException {
        new LeavePage(Helper.getDriver()).clickOnSearchButton();
    }
    @Then("User on Leave page verify record at search result")
    public void userOnLeavePageVerifyRecordAtSearchResult() throws InterruptedException {
        new LeavePage(Helper.getDriver()).verifySearchResult();}
}
