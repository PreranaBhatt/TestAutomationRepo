package stepDefinition;

import PageObject.Homepage.HambergerMenuPage;
import PageObject.Homepage.HomePage;
import Utilities.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomepageSteps extends BaseStep{

    @And("verify homePage layout")
    public void verifyHomePageLayout() {
     homepage = new HomePage(Helper.getDriver());
     Assert.assertTrue("drpdwn isn't displayed",homepage.getUserDrpdwnElement().isDisplayed());
    }
}
