package appium.mobile.automation.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;

import appium.mobile.automation.driver.DriverFactory;
import io.appium.java_client.AppiumDriver;

import appium.mobile.automation.driver.DriverManager;

public class BaseTest {

    @BeforeMethod
    public void setup() throws MalformedURLException{
        String platform = System.getProperty("platform","ios");
        AppiumDriver driver = DriverFactory.createDriver(platform);
        DriverManager.setDriver(driver);
    }

    public void tearDown(){
        DriverManager.quitDriver();;
    }

}
