package app.bersama.pages;

import app.bersama.DriverManager;
import app.bersama.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

/**
 * @author regiewby on 02/12/22
 * @project java-cucumber-learning
 */
public class HomePage {

    protected WebDriver webDriver;
    private String num;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//li[@class='nav-item-login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[@class='btn btn-color-theme pl-3 pr-3 button-jual']")
    private WebElement btnJual;

  /*  @FindBy (xpath = "//a[@class='navbar-brand']")
    private WebElement navLinkHome;*/

    public void clickButtonLogin(){
        Keyword.tapElement(btnLogin);
    }

    public void addedProduct(){
        Keyword.tapElement(btnJual);
    }

    public void waitBtnAddProduct(){
        Keyword.waitElementToBeDisplayed(btnJual);
    }

}
