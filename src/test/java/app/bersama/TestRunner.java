package app.bersama;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

/**
 * @author regiewby on 02/12/22
 * @project java-cucumber-learning
 */

@CucumberOptions(features = "features/OrderPasha.feature:5",
        glue = "app.bersama.steps",
        plugin = {
                "pretty",
                "html:reports/cucumber-reports.html",
                "json:reports/cucumber-reports.json"
}, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod
    public void setupBrowser() {
        WebDriver webDriver = new BrowserFactory().launchBrowser("headless chrome");
        webDriver.manage().window().fullscreen();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        DriverManager.getInstance().setDriver(webDriver);
    }

    @AfterMethod
    public void teardownBrowser() {
        DriverManager.getInstance().getDriver().close();
    }
}
