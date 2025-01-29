package bastTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.Assert;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.net.URL;


public class BaseTest {

    public AppiumDriver driver;

    @BeforeClass(description = "Set Up Appium Driver")
    public void setUp() throws Exception {

        MutableCapabilities capabilities = new UiAutomator2Options();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "R5CR1207J0E");
        capabilities.setCapability("version", "13");
        capabilities.setCapability("app","D:\\WebQualityProfessionals\\MobileAutomation\\Weather forecast_82.01_APKPure.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass(description = "Tear Down Appium Driver", alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
