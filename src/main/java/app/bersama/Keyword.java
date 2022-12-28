package app.bersama;

import app.bersama.enums.FileType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

import static org.apache.commons.io.FileUtils.waitFor;

/**
 * @author regiewby on 07/12/22
 * @project java-cucumber-learning
 */
public class Keyword {

    public static void navigateToUrl(String url) {
        DriverManager.getInstance().getDriver().get(url);
    }

    public static void tapElement(WebElement webElement) {
        waitElementToBeDisplayed(webElement);
        webElement.click();
    }

    public static void inputText(WebElement webElement, String value) {
        waitElementToBeDisplayed(webElement);
        webElement.sendKeys(value);
    }

    public static void validateElementIsVisibleAndEnabled(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webElement));

        if (!webElement.isDisplayed() || !webElement.isEnabled()) {
            System.out.println("element not visible or enabled");
            throw new ElementNotInteractableException(webElement.toString());
        }
    }

    public static void waitElementToBeDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollIntoView(WebElement target) throws InterruptedException {
        JavascriptExecutor je = (JavascriptExecutor) DriverManager.getInstance().getDriver();
        je.executeScript("arguments[0].scrollIntoView(true);", target);
        Thread.sleep(800);
    }

    public static void waitUntilElementIsClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void takeScreenshot() {
        try {
            TakesScreenshot screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver());
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destionationFile = new File("reports/screenshot");

            FileUtils.copyFile(sourceFile, destionationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertCurrentUrl(String expectedUrl) {
        String actualUrl = DriverManager.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    public static void takeScreenshot(String fileName) {
        try {
            TakesScreenshot screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver());
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("reports/screenshots" + File.separator + fileName + "." + FileType.PNG.name());

            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void alertHandler(boolean isAccepted){
        if (isAccepted){
            DriverManager.getInstance().getDriver().switchTo().alert().accept();
        } else {
            DriverManager.getInstance().getDriver().switchTo().alert().dismiss();
        }
    }

    public static String getTextAllert () {
        return  DriverManager.getInstance().getDriver().switchTo().alert().getText();
    }
}
