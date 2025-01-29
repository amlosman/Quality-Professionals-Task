package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ElementActions;
import utilities.VerifyActions;

import java.util.List;

public class HomePage {
    By locationIcon = By.id("com.graph.weather.forecast.channel:id/ivLocation");
    By temperature = By.id("com.graph.weather.forecast.channel:id/tgTemperature_setting");
    By timeFormat = By.id("com.graph.weather.forecast.channel:id/tg_format_time_setting");
    By doneBtn = By.id("com.graph.weather.forecast.channel:id/tvDone");
    By TempType = By.id("com.graph.weather.forecast.channel:id/tvTypeTemperature");
    By tvSummary = By.id("com.graph.weather.forecast.channel:id/tvSummary");
    By rainingIcon = By.id("com.graph.weather.forecast.channel:id/ivIconRainChance");
    By ivIconHourly = By.id("com.graph.weather.forecast.channel:id/ivIconHourly");
    By tvHourItem = By.id("com.graph.weather.forecast.channel:id/tvHourItem");
    By tvRainChanceValue = By.id("com.graph.weather.forecast.channel:id/tvRainChanceValue");
    By ivWeather = By.id("com.graph.weather.forecast.channel:id/ivWeather");
    AppiumDriver appiumDriver;

    public HomePage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void changeTemperatureToF() {
        ElementActions.clickOnElement(appiumDriver, temperature);
    }

    public void changeTemperatureTo12Hours() {
        String curruntTime = ElementActions.getElement(appiumDriver,timeFormat).getText();
        if(curruntTime.equals("24"))
        ElementActions.clickOnElement(appiumDriver, timeFormat);
    }

    public void clickOnDone() {
        ElementActions.waitElement(2000);
        ElementActions.clickOnElement(appiumDriver, doneBtn);
    }

    public void clickOnLocationIcon() {
        ElementActions.waitElement(500);
        ElementActions.clickOnElement(appiumDriver, locationIcon);
    }
    public boolean validateTempIsDisplayed() {
        ElementActions.waitElement(7000);
        return VerifyActions.isDisplayed(appiumDriver, TempType);
    }
    public String getTempTypeText(){
        return ElementActions.getElementText(appiumDriver,TempType);
    }
    public boolean validateSummeryIsDisplayed() {
        return VerifyActions.isDisplayed(appiumDriver, tvSummary);
    }
    public boolean validateRainingIconForEachHourIsDisplayed() {
        List<WebElement> rainingList = appiumDriver.findElements(rainingIcon);
        List<WebElement> tvHoursList = appiumDriver.findElements(tvHourItem);
        List<WebElement> ivIConList = appiumDriver.findElements(ivIconHourly);
        for(int i=0;i<ivIConList.size();i++){
         if (rainingList.get(i).isDisplayed()&&tvHoursList.get(i).isDisplayed()&&ivIConList.get(i).isDisplayed()){
             continue;
         }
         else return false;
        }
        return true;
    }
}
