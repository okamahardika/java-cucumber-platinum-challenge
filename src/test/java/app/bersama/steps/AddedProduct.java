package app.bersama.steps;

import app.bersama.DriverManager;
import app.bersama.TestDataProvider;
import app.bersama.pages.AddProduct;
import app.bersama.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddedProduct {

    HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());

    @Given("click button jual")
    public void click_button_jual() {
        homePage.addedProduct();
    }

    @When("input valid data for product")
    public void input_valid_data_for_product() {
        String name = TestDataProvider.getRandomProductName();
        String price = TestDataProvider.getRandomPrice();
        String desc = TestDataProvider.getRandomDescription();

        AddProduct addProduct =new AddProduct(DriverManager.getInstance().getDriver());
        addProduct.addDataProduct(name, price, desc);
        addProduct.clickBtnPost();

        homePage.waitBtnAddProduct();
    }
}
