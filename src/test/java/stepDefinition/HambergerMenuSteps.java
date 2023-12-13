package stepDefinition;

import PageObject.Homepage.HambergerMenuPage;
import Utilities.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HambergerMenuSteps extends BaseStep {

    @When("user on hamberger menu section tries to colapse hambergerMenu")
    public void user_on_hamberger_menu_section_Tries_To_Colapse_HambergerMenu() {
        new HambergerMenuPage(Helper.getDriver()).verifyDashboardMenuIsCollapsable();
    }

    @And("User on hamberger menu section verify count of title list")
    public void userOnHambergerMenuSectionVerifyCountOfTitleList() {
        new HambergerMenuPage(Helper.getDriver()).verifyHambergerMenuSectionList();
    }

    @Then("User on hamberger menu section verify all the title")
    public void userOnHambergerMenuSectionVerifyAllTheTitle() {
        new HambergerMenuPage(Helper.getDriver()).verifyAllHambergerMenuTitles();
    }

    @And("User on hamberger menu section clicks on search bar")
    public void userOnHambergerMenuSectionClicksOnSearchBar() {
        new HambergerMenuPage(Helper.getDriver()).clickOnSearchBar();
    }

    @And("User on hamberger menu section enter text (.*)$")
    public void user_On_Hamberger_Menu_Section_Enter_Text_My_Info(String searchKey) throws InterruptedException {
        new HambergerMenuPage(Helper.getDriver()).performSearch(searchKey);
    }
}
