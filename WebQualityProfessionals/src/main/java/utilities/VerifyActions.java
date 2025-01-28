package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class VerifyActions {


    public static boolean isDisplayed(WebDriver driver, By locator) {
        return new WebDriverWait(driver,100).until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
    }
    public static boolean isClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(locator)).isEnabled();
    }
}
