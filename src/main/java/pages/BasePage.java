package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Environment;

public class BasePage extends Environment {

    public void quitBrowser() {
        getDriver().quit();
    }

    public static void explicitWait(AndroidDriver androidDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void
    explicitWait(AndroidDriver androidDriver) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
