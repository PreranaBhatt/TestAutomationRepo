package stepDefinition;

import PageObject.Homepage.HomePage;
import Utilities.Helper;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class HomepageSteps extends BaseStep{

    @And("verify homePage layout")
    public void verifyHomePageLayout() {
     homepage = new HomePage(Helper.getDriver());
     Assert.assertTrue("drpdwn isn't displayed",homepage.getUserDrpdwnElement().isDisplayed());
    }
}
