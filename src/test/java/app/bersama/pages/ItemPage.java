package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class ItemPage {
    protected WebDriver webDriver;

    public ItemPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    private WebElement btnOffer;

    @FindBy (xpath = "//input[@class='form-control']")
    private WebElement txtPriceOffer;

    @FindBy (xpath = "//h4[@class='card-price']")
    private WebElement priceItem;

    @FindBy (xpath = "//button[.='Kirim']")
    private WebElement btnSendOffer;

    @FindBy (xpath = "//div[@class='fade position-absolute top-0 start-50 translate-middle alert alert-success show']")
    private WebElement modalSuccessOffer;

    @FindBy (xpath = "//button[text()='Menunggu respon penjual']")
    private WebElement btnResponSeller;

    public void clickCardItem () throws InterruptedException {
        boolean randomCard = true;
        int i = 1;

        while (randomCard) {
            String productList = "//div[@class='products']/div["+i+"]/div[@class='card-body']";
            WebElement product = webDriver.findElement(By.xpath(productList));
            Keyword.scrollIntoView(product);
            Keyword.waitUntilElementIsClickable(product);
            Keyword.tapElement(product);
            Thread.sleep(8000);
                if (!btnResponSeller.isDisplayed()){
                    randomCard = false;
                } else {
                    webDriver.navigate().back();
                }
            i++;
        }
    }

    public void addOfferItem () throws InterruptedException {
        Keyword.scrollIntoView(priceItem);
        Thread.sleep(4000);
        String price = priceItem.getText();
        String finalPrice = price.split("Rp") [1];
        finalPrice.trim();
        int number = Integer. valueOf(price);
        Keyword.scrollIntoView(btnOffer);
        Keyword.waitUntilElementIsClickable(btnOffer);
        Keyword.tapElement(btnOffer);

        if ( number > 0) {
            String itemPrice = String.valueOf(number*0.9);
            Keyword.inputText(txtPriceOffer, itemPrice);
            Keyword.tapElement(btnSendOffer);
        } else {
            Keyword.inputText(txtPriceOffer, "0");
            Keyword.tapElement(btnSendOffer);
        }
    }

    public void modalSuccessOffer(){
        Boolean isExist =  modalSuccessOffer.isDisplayed();
        Assert.assertTrue(modalSuccessOffer.isDisplayed());
    }
}
