package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyActions {


    public static boolean isDisplayed(AppiumDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofMillis(100)).until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
    }

    public static boolean isClickable(AppiumDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(locator)).isEnabled();
    }
}
