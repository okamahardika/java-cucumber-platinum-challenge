package app.bersama.pages;

import app.bersama.Keyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author regiewby on 02/12/22
 * @project java-cucumber-learning
 */
public class HomePage {

    protected WebDriver webDriver;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//li[@class='nav-item-login']")
    private WebElement btnLogin;

    public void clickButtonLogin(){
        Keyword.tapElement(btnLogin);
    }

}
