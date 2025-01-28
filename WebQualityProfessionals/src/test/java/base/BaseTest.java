package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.WebBrowsers;
import utilities.readers.PropertiesReader;


public class BaseTest {
    static WebDriver driver;

    @Parameters(value = {"browser"})
    @BeforeTest(description = "navigate to the website and maximize the widow")
    public void setUp(@Optional("Chrome") String browser) {
        driver = WebBrowsers.chooseBrowserDriver(browser, PropertiesReader.getValue("headless").equals("yes"));
        WebBrowsers.staticmaximizeWindow(driver);
        driver.navigate().to(PropertiesReader.getValue("PracticeAutomation"));
    }
    public static WebDriver getDriver() {
        return driver;
    }
    @AfterTest(description = "close all browser instance")
    public void tearDown() {
        if (driver != null) WebBrowsers.quitWindow(driver);
    }
}
