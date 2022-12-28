package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.pages.HomePage;
import app.bersama.pages.ItemPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddOfferItem {
    @Given("click card item")
    public void click_card_item() throws InterruptedException {
        ItemPage itemPage = new ItemPage(DriverManager.getInstance().getDriver());
        itemPage.clickCardItem();
    }

    @Given("click offer and put price offer")
    public void click_offer_and_put_price_offer() throws InterruptedException {
    /*    ItemPage itemPage = new ItemPage(DriverManager.getInstance().getDriver());
        itemPage.addOfferItem();*/
    }

    @When("click button send")
    public void click_button_send() {

    }

    @Then("Alert success will shown")
    public void alert_success_will_shown() {
        ItemPage itemPage =new ItemPage(DriverManager.getInstance().getDriver());
        itemPage.modalSuccessOffer();
    }

}
