package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import app.bersama.pages.HomePage;
import app.bersama.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author regiewby on 05/12/22
 * @project java-cucumber-learning
 */
public class CommonStep {

    @Given("navigate to url")
    public void navigate_to_url() {
        Keyword.navigateToUrl("https://secondhand-store.herokuapp.com/");
    }

    @When("login as {string}")
    public void loginAs(String credentialType) {

        String userName = "";
        String password = "";

        switch (credentialType) {
            case "standard_user":
                userName = "standard_user";
                password = "secret_sauce";
                break;

            case "locked_out_user":
                userName = "locked_out_user";
                password = "secret_sauce";
                break;

            case "invalid_user":
                userName = "invalid_user";
                password = "wrong_password";
                break;

            default:
                throw new RuntimeException("credential type doesn't exist");
        }

        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.userLogin(userName, password);
    }

    @Then("current url should be {string}")
    public void currentUrlShouldBe(String expectedUrl) {
        Keyword.assertCurrentUrl(expectedUrl);
    }


    @Then("user logout")
    public void userLogout() {
        HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
        homePage.userLogout();
    }

    @And("user take screenshot full page with name {string}")
    public void userTakeScreenshotFullPageWithName(String fileName) {
        Keyword.takeScreenshot(fileName);
    }
}
