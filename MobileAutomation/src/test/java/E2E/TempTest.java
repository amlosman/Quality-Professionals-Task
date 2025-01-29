package E2E;

import bastTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TempTest extends BaseTest {
    HomePage homePage;

    @Test(description = "Validate user can set his location")
    public void ValidateTemperaturePage()
    {
        homePage = new HomePage(driver);
        homePage.changeTemperatureToF();
        homePage.changeTemperatureTo12Hours();
        homePage.clickOnDone();
        homePage.clickOnLocationIcon();
    }
    @Test(description = "Validate user can see Temperature details", dependsOnMethods = "ValidateTemperaturePage")
    public void validateUserCanSeeTemperatureDetails(){
        Assert.assertTrue(homePage.validateTempIsDisplayed());
        Assert.assertEquals(homePage.getTempTypeText(),"F");
        Assert.assertTrue(homePage.validateSummeryIsDisplayed());
        Assert.assertTrue(homePage.validateRainingIconForEachHourIsDisplayed());
    }
}
