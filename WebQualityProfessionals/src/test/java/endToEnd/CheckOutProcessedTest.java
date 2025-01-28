package endToEnd;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.BillingDetailsPage;
import pages.HomePage;
import utilities.readers.JsonReader;

public class CheckOutProcessedTest extends BaseTest {
    JsonReader jsonReader = new JsonReader("src/test/resources/data/UserData.json");
    HomePage homePage;
    BasketPage basketPage;
    BillingDetailsPage billingDetailsPage;

    @Test(description = "Validate Automation Practice site displayed successfully")
    public void AutomationPracticeSiteDisplayedDSuccessfully() {
        homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.checkHeaderIdItemsIsDisplayed());
    }

    @Test(description = "Validate user can add item to shopping card", dependsOnMethods = "AutomationPracticeSiteDisplayedDSuccessfully")
    public void validateUserCanAddItemToShoppingCard() {
        homePage.scrollToItemsList(jsonReader.getValueOfNode("itemKey"));
        Assert.assertEquals(homePage.getItemText(jsonReader.getValueOfNode("itemKey")), jsonReader.getValueOfNode("itemKey"));
        homePage.clickOnAddToCard();
    }

    @Test(description = "Validate user can see added items in shopping card", dependsOnMethods = "validateUserCanAddItemToShoppingCard")
    public void validateUserCanSeeItemsOnShoppingCard() {
        basketPage = new BasketPage(getDriver());
        homePage.clickShoppingCard();
        Assert.assertEquals(basketPage.getProductName(), jsonReader.getValueOfNode("productName"));
        Assert.assertEquals(basketPage.getProductPrice(), jsonReader.getValueOfNode("productPrice"));
        Assert.assertEquals(basketPage.getProductQTY(), jsonReader.getValueOfNode("productQTY"));
        Assert.assertEquals(basketPage.getProductTotalPrice(), jsonReader.getValueOfNode("productTotalPrice"));
    }

    @Test(description = "Validate user can processed to check out", dependsOnMethods = "validateUserCanSeeItemsOnShoppingCard")
    public void validateUserCanProcessedToCheck() {
        billingDetailsPage = new BillingDetailsPage(getDriver());
        basketPage.clickOnCheckOutBtn();
    }

    @Test(description = "Validate user can't processed without fill billing detail", dependsOnMethods = "validateUserCanProcessedToCheck")
    public void validateUserCannotProcessedTWithoutFillBillingDetails() {
        billingDetailsPage.clickOnPlaceOrder();
        Assert.assertTrue(billingDetailsPage.validateErrorIsDisplayed());
    }

    @Test(description = "Validate user can fill billing details", dependsOnMethods = "validateUserCannotProcessedTWithoutFillBillingDetails")
    public void fillBillingDetails() {
        billingDetailsPage.fillBillingDetails(jsonReader.getValueOfNode("BillingDetails/firstName"), jsonReader.getValueOfNode("BillingDetails/lastName"), jsonReader.getValueOfNode("BillingDetails/companyName"), jsonReader.getValueOfNode("BillingDetails/emailAddress"), jsonReader.getValueOfNode("BillingDetails/phone"), jsonReader.getValueOfNode("BillingDetails/country"), jsonReader.getValueOfNode("BillingDetails/town"), jsonReader.getValueOfNode("BillingDetails/address"), jsonReader.getValueOfNode("BillingDetails/Zip"));
    }

    @Test(description = "Validate user can select Payment Method", dependsOnMethods = "fillBillingDetails")
    public void validateUserSelectPaymentMethod() {
        billingDetailsPage.selectPaymentMethod();
    }

    @Test(description = "Validate user see thank you message with order date", dependsOnMethods = "validateUserSelectPaymentMethod")
    public void validateUserSeeThankYouMgsWithOrderDate() {
        billingDetailsPage.clickOnPlaceOrder();
        Assert.assertEquals(billingDetailsPage.getThankYouMgs(), jsonReader.getValueOfNode("ThankYouMgs"));
    }

}
