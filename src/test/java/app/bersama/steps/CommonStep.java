package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import app.bersama.pages.HomePage;
import app.bersama.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

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

        HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
        homePage.clickButtonLogin();

        String email = "";
        String password = "";

        switch (credentialType) {
            case "valid_credential":
                email = "kenadijaya@gmail.com";
                password = "123123123";
                break;

            default:
                throw new RuntimeException("credential type doesn't exist");
        }

        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.userLogin(email, password);

    }

    @Then("current url should be {string}")
    public void currentUrlShouldBe(String expectedUrl) {
        Keyword.assertCurrentUrl(expectedUrl);
    }

}
