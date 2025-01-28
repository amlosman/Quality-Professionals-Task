package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;
import utilities.ScrollingActions;
import utilities.VerifyActions;

public class HomePage {
    By headerId = By.id("header");
    String itemKeyXPath = "//h3[.='%s']";
    By AddToCardXpath = By.xpath("//li[@class='post-163 product type-product status-publish has-post-thumbnail product_cat-html product_tag-html has-post-title no-post-date has-post-category has-post-tag has-post-comment has-post-author first instock sale downloadable taxable shipping-taxable purchasable product-type-simple']/a[.='Add to basket']");
    By shoppingCard = By.className("wpmenucart-icon-shopping-cart-0");
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkHeaderIdItemsIsDisplayed() {
        try {
            ScrollingActions.scrollToFindElement(driver, headerId);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return VerifyActions.isDisplayed(driver, headerId);
    }

    public void scrollToItemsList(String searchKey) {
        try {
            ScrollingActions.scrollToFindElement(driver, By.xpath(String.format(itemKeyXPath, searchKey)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getItemText(String searchKey) {
        return ElementActions.getElemetText(driver, By.xpath(String.format(itemKeyXPath, searchKey)));
    }

    public void clickOnAddToCard() {
        ElementActions.clickOnElement(driver, AddToCardXpath);
    }

    public void clickShoppingCard() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ElementActions.clickOnElement(driver, shoppingCard);
    }
}