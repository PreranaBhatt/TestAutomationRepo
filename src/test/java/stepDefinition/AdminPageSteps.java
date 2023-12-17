package stepDefinition;

import PageObject.AdminPage;
import Utilities.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdminPageSteps extends BaseStep{
    @Then("User on Admin page verify PageHeading")
    public void user_on_Admin_page_Verify_PageHeading() {
        adminpage = new AdminPage(Helper.getDriver());
        adminpage.isPageHeadingisDisaplyed();
    }

    @And("User on Admin page verify sub tab headings")
    public void userOnAdminPageVerifySubTabHeadings() {
        adminpage.verifyAllSubTabs();
    }

    @And("User on Admin page perform search for given (.*) and (.*)$")
    public void userOnAdminPagePerformSearchForGivenUserRoleAndStatus(String UserRole,String status) throws InterruptedException {
        adminpage.selectUserRole();
        adminpage.selectStatus();
        adminpage.clickOnSearchButton();
    }

    @And("User on Admin page verify result screen")
    public void userOnAdminPageVerifyResultScreen() {
        adminpage.verifySearchResultScreen();
    }
}
