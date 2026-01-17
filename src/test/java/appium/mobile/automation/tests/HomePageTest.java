package appium.mobile.automation.tests;

import org.testng.annotations.Test;

import appium.mobile.automation.driver.DriverManager;
import appium.mobile.automation.pages.HomePage;
import io.appium.java_client.AppiumDriver;

public class HomePageTest extends BaseTest{


    @Test
    public void testHomePage() {
        AppiumDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);

        homePage.clickActivityIndicator();
        driver.navigate().back();

        homePage.clickAlertViews();
        driver.navigate().back();

        homePage.clickButtons();
        driver.navigate().back();
        
    }




}
