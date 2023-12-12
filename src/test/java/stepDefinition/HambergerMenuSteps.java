package stepDefinition;

import PageObject.Homepage.HambergerMenuPage;
import PageObject.Homepage.HomePage;
import Utilities.Helper;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HambergerMenuSteps extends BaseStep {

    @When("user tries to colapse hambergerMenu")
    public void user_Tries_To_Colapse_HambergerMenu() {
        hpage= new HambergerMenuPage(Helper.getDriver());
        hpage.verifyDashboardMenuIsCollapsable();
    }
}
