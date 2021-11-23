package betterPlace.stepDefinitions;

import betterPlace.pages.BetterDonatePage;
import betterPlace.utilities.ConfigurationReader;
import betterPlace.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BetterStepDefs {
    BetterDonatePage betterLoginPage = new BetterDonatePage();

    @Given("the user is on the betterplace page")
    public void the_user_is_on_the_betterplace_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        String expectedUrl = ConfigurationReader.get("url");
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @When("the user clicks login button")
    public void the_user_clicks_login_button() {
        betterLoginPage.clickPopUp();
        betterLoginPage.clickLoginButton();

    }

    @When("the login page shows as expected")
    public void the_login_page_shows_as_expected() {
        String expectedUrl = ConfigurationReader.get("url") +"/users/sign_in";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Then("the user logins with valid credentials")
    public void the_user_logins_with_valid_credentials() {
        betterLoginPage.login();


    }


    @Then("the user sign in successfully {string}")
    public void theUserSignInSuccessfully(String expactedMessage) {
      Assert.assertEquals("The user is not logged successfully",expactedMessage,betterLoginPage.getSuccessMessageText());

    }
}
