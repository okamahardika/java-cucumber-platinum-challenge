package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;

public class AddProduct {
    protected WebDriver webDriver;

    public AddProduct(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (xpath = "//input[@id='nm_produk']")
    private WebElement txtNameProduct;

    @FindBy (xpath = "//input[@id='harga_produk']")
    private WebElement txtPrice;

    @FindBy (xpath = "//select[@id='kategori']")
    private WebElement slctCategories;

    @FindBy (xpath = "//textarea[@id='deskripsi']")
    private WebElement txtDescription;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    private WebElement btnPost;

    @FindBy (xpath = "//button[@class='btn btn-outline-primary']")
    private WebElement btnPreview;

    //path for added photo cant convert

    public void addDataProduct(String name, String price,String desc){
        Keyword.inputText(txtNameProduct, name);
        Keyword.inputText(txtPrice, price);

        Select se = new Select(slctCategories);
        ArrayList<String> value = new ArrayList<String>();
        value.add("1");
        value.add("2");
        value.add("3");
        value.add("4");
        value.add("5");
        int randomValue = (int) (Math.random() * value.size());
        se.selectByValue(String.valueOf(randomValue));

        Keyword.inputText(txtDescription, desc);
    }

    public void clickBtnPost(){
        Keyword.tapElement(btnPost);
    }
}
