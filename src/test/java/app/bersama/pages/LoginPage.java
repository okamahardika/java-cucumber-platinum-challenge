package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

/**
 * @author regiewby on 02/12/22
 * @project java-cucumber-learning
 */
public class LoginPage {

    protected WebDriver webDriver;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='exampleInputEmail1']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='exampleInputPassword1 ']")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary w-100']")
    private WebElement btnLogin;

    @FindBy (xpath = "//button[@id='notification']")
    private WebElement btnNotification;

    public void userLogin(String email, String password) {
        Keyword.inputText(txtEmail, email);
        Keyword.inputText(txtPassword, password);
        Keyword.tapElement(btnLogin);
        Keyword.waitElementToBeDisplayed(btnNotification);
    }
}
