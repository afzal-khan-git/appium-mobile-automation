package appium.mobile.automation.tests;

import org.testng.annotations.Test;

import appium.mobile.automation.driver.DriverManager;
import io.appium.java_client.AppiumDriver;

public class InitialTest extends BaseTest {

    @Test
    public void checkBtn(){
        AppiumDriver driver = DriverManager.getDriver();

    }

}
