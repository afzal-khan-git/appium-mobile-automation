package appium.mobile.automation.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class DriverFactory {

    public static AppiumDriver createDriver(String platformName) throws MalformedURLException {
        AppiumDriver driver;

        switch (platformName.toLowerCase()) {
            case "android":
                driver = createAndroidDriver();
                break;

            case "ios":
                driver = createIOSDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid platform : " + platformName);
        }

        return driver;
    }

    private static AppiumDriver createAndroidDriver() throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Pixe_10");
        options.setApp(System.getProperty("user.dir")+"/src/test/java/appium/mobile/automation/resources/apps/android");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(false);

        URL serverURL = URI.create("http://127.0.0.1:4723").toURL();

        return new AndroidDriver(serverURL, options);
    }

    private static AppiumDriver createIOSDriver() throws MalformedURLException{
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("ios");
        options.setDeviceName("iPhone Air");
        options.setApp(System.getProperty("user.dir")+"/src/test/java/appium/mobile/automation/resources/apps/ios/UIKitCatalog.app");
        options.setAutomationName("XCUITest");
        options.setNoReset(false);
        // iPhone 17 Pro (92A4C00B-923F-4DE2-B80E-262B414FA3A9) (Booted)
        // iPhone 16 Pro 68E39B77-D201-4FD5-A530-2C9AF7361EFD

        URL serverURL = URI.create("http://127.0.0.1:4723").toURL();

        return new IOSDriver(serverURL, options);
    }

}
