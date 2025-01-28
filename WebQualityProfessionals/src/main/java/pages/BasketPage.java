package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;
import utilities.ScrollingActions;

public class BasketPage {
    By productName = By.cssSelector("[data-title='Product']");
    By productPrice = By.cssSelector("[data-title='Price'] >.woocommerce-Price-amount");
    By productQuantity = By.cssSelector(".qty");
    By productTotalPrice = By.cssSelector("td:nth-of-type(6) > .woocommerce-Price-amount");
    By checkoutButton = By.cssSelector(".checkout-button");
    WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return ElementActions.getElemetText(driver, productName);
    }

    public String getProductPrice() {
        return ElementActions.getElemetText(driver, productPrice);
    }

    public String getProductQTY() {
        return ElementActions.getElement(driver, productQuantity).getAttribute("value");
    }

    public String getProductTotalPrice() {
        return ElementActions.getElemetText(driver, productTotalPrice);
    }

   public void clickOnCheckOutBtn()
   {
       ElementActions.clickOnElement(driver,checkoutButton);
   }

}
