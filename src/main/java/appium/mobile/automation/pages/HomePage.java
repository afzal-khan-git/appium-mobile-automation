package appium.mobile.automation.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class HomePage {
    private AppiumDriver driver; 

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    private By activityIndicator = AppiumBy.accessibilityId("Activity Indicators");
    private By alertViews = AppiumBy.accessibilityId("Alert Views");
    private By buttons = AppiumBy.accessibilityId("Buttons");
    private By backButton = AppiumBy.accessibilityId("BackButton");

    public void clickActivityIndicator() {
        driver.findElement(activityIndicator).click();
    }
    public void clickAlertViews() {
        driver.findElement(alertViews).click();
    }
    public void clickButtons() {
        driver.findElement(buttons).click();  
    }
    public void clickBackButton() {
        driver.findElement(backButton).click();  
    }








}
