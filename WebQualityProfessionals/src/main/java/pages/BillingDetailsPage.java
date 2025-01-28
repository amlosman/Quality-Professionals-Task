package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;
import utilities.ScrollingActions;
import utilities.VerifyActions;

public class BillingDetailsPage {
    WebDriver driver;
    By firstName = By.id("billing_first_name");
    By lastName = By.id("billing_last_name");
    By companyName = By.id("billing_company");
    By emailAddress = By.id("billing_email");
    By phone = By.id("billing_phone");
    By country = By.id("billing_company");
    By town = By.id("billing_city");
    By address = By.id("billing_address_1");
    By state = By.id("billing_state");
    By Zip = By.id("billing_postcode");
    By paymentMethod = By.id("payment_method_cod");
    By placeOrder = By.id("place_order");
    By billingErrorMgs = By.className("woocommerce-error");
    By thankYouMgs = By.className("woocommerce-thankyou-order-received");

    public BillingDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillBillingDetails(String fName, String sName, String CName, String Eaddress, String phoneNumer, String Country, String Town, String addess1, String zIP) {
        ElementActions.sendKeys(driver, firstName, fName);
        ElementActions.sendKeys(driver, lastName, sName);
        ElementActions.sendKeys(driver, companyName, CName);
        ElementActions.sendKeys(driver, emailAddress, Eaddress);
        ElementActions.sendKeys(driver, phone, phoneNumer);
        ElementActions.sendKeys(driver, country, Country);
        ElementActions.sendKeys(driver, address, addess1);
        ElementActions.sendKeys(driver, town, Town);
        ElementActions.sendKeys(driver, Zip, zIP);
    }

    public void selectPaymentMethod() {

        ElementActions.clickOnElement(driver, paymentMethod);
    }

    public void clickOnPlaceOrder() {
        try {
            ScrollingActions.scrollToFindElement(driver, placeOrder);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ElementActions.clickOnElement(driver, placeOrder);
    }

    public Boolean validateErrorIsDisplayed() {
        return VerifyActions.isDisplayed(driver, billingErrorMgs);
    }

    public String getThankYouMgs() {
        return ElementActions.getElemetText(driver, thankYouMgs);
    }
}
