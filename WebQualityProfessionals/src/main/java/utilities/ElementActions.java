package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ElementActions {

       public static void clickOnElement(WebDriver driver, By locator) {
           try {
               ScrollingActions.scrollToFindElement(driver,locator);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
        VerifyActions.isDisplayed(driver,locator);
        VerifyActions.isClickable(driver,locator);
        driver.findElement(locator).click();
    }
    public static void sendKeys(WebDriver driver, By locator, String keys) {
        try {
            ScrollingActions.scrollToFindElement(driver,locator);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        VerifyActions.isClickable(driver,locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(keys);
    }
    public static void clickOnEnter(WebDriver driver)
    {
        try{
            Thread.sleep(3000);
            Actions action=new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    public static void clickOnRight(WebDriver driver, By locator)
    {
        VerifyActions.isClickable(driver,locator);
        driver.findElement(locator).sendKeys(Keys.ARROW_RIGHT);
    }
    public static String getElemetText(WebDriver driver, By locator){
        VerifyActions.isDisplayed(driver,locator);
        return driver.findElement(locator).getText();
    }
    public static void clear(WebDriver driver, By locator){
        driver.findElement(locator).clear();
    }
    public static WebElement getElement(WebDriver driver, By locator){
       return driver.findElement(locator);
    }
    public static void searchInPopupAndSelect(WebDriver driver, By locator,By name, String ... values) throws InterruptedException {
        for (int i=0;i<values.length;i++) {
            sendKeys(driver,locator,values[i]);
            Thread.sleep(9000);
            if(!getElement(driver,name).isSelected()) {
                getElement(driver,name).click();
            }
            clear(driver,locator);
        }
    }

    public static void waitElement(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
