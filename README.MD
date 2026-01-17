# Appium Mobile Automation

A comprehensive Java-based mobile test automation framework using Appium for testing iOS and Android applications.

## Overview

This project provides a robust automation framework for testing mobile applications on both iOS and Android platforms. It leverages Appium, a popular cross-platform automation tool, and is built with Java and Maven for dependency management and build orchestration.

## Features

- **Cross-Platform Support**: Seamlessly automate tests for both iOS and Android devices
- **Page Object Model**: Well-organized page object structure for maintainable test code
- **Driver Management**: Centralized driver factory pattern for managing AppiumDriver instances
- **TestNG Integration**: Comprehensive testing framework with TestNG for flexible test execution
- **Resource Management**: Organized structure for test apps and resources
- **Configuration-Driven**: Flexible configuration management for different test environments

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java JDK 21+**: [Download Java](https://www.oracle.com/java/technologies/downloads/)
- **Maven 3.6+**: [Download Maven](https://maven.apache.org/download.cgi)
- **Appium Server**: Install via npm
  ```bash
  npm install -g appium
  ```
- **iOS Requirements** (for iOS testing):
  - Xcode installed on macOS
  - iOS Simulator or real device
  
- **Android Requirements** (for Android testing):
  - Android SDK installed
  - Android Emulator or real device
  - ANDROID_HOME environment variable configured

## Project Structure

```
appium-mobile-automation/
├── src/
│   ├── main/java/appium/mobile/automation/
│   │   ├── App.java                    # Main application class
│   │   ├── config/                     # Configuration management
│   │   ├── driver/                     # Driver factory and management
│   │   │   ├── DriverFactory.java      # Creates Appium drivers
│   │   │   └── DriverManager.java      # Manages driver lifecycle
│   │   ├── pages/                      # Page Object Model classes
│   │   │   └── HomePage.java
│   │   └── utils/                      # Utility classes
│   └── test/java/appium/mobile/automation/
│       ├── resources/
│       │   └── apps/                   # Test application binaries
│       │       ├── android/            # Android APK files
│       │       └── ios/                # iOS .app files
│       └── tests/                      # Test classes
│           ├── BaseTest.java           # Base test class with setup/teardown
│           ├── HomePageTest.java       # HomePage test cases
│           └── InitialTest.java        # Initial test demonstrations
├── pom.xml                             # Maven configuration
└── README.md                           # This file
```

## Key Components

### DriverFactory
The `DriverFactory` class handles the creation of platform-specific drivers:
- **Android Driver**: Uses UiAutomator2 for automation
- **iOS Driver**: Uses XCUITest for automation
- Supports configuration through options objects

### DriverManager
Manages the AppiumDriver lifecycle:
- Stores and retrieves driver instances in thread-local storage
- Handles driver cleanup and teardown

### BaseTest
Provides common test setup and teardown functionality:
- Initializes drivers before each test method
- Cleans up resources after test execution
- Supports platform selection via system properties

## Dependencies

Key dependencies managed via Maven:

- **Appium Java Client** (v10.0.0): Java client library for Appium
- **TestNG** (v7.11.0): Testing framework for test organization and execution

## Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd appium-mobile-automation
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Start Appium Server
```bash
appium
```

The server will start on `http://127.0.0.1:4723` by default.

### 4. Run Tests

**Run all tests:**
```bash
mvn test
```

**Run tests for a specific platform:**
```bash
# iOS tests
mvn test -Dplatform=ios

# Android tests
mvn test -Dplatform=android
```

**Run a specific test class:**
```bash
mvn test -Dtest=HomePageTest
```

**Run a specific test method:**
```bash
mvn test -Dtest=HomePageTest#testSpecificMethod
```

## Configuration

### Platform Selection
Set the platform via system property:
```bash
mvn test -Dplatform=ios      # Default is iOS
mvn test -Dplatform=android
```

### Device Configuration
Edit `DriverFactory.java` to configure:
- Device name
- Platform version
- Automation engine
- App path
- Desired capabilities

Example Android configuration:
```java
options.setPlatformName("Android");
options.setDeviceName("Pixel_10");
options.setAutomationName("UiAutomator2");
```

Example iOS configuration:
```java
options.setPlatformName("ios");
options.setDeviceName("iPhone 15");
options.setAutomationName("XCUITest");
```

## Writing Tests

### Creating a New Page Object

Create a new page object class in `src/main/java/appium/mobile/automation/pages/`:

```java
package appium.mobile.automation.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyPage {
    private AppiumDriver driver;

    public MyPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private By myElement = By.id("element_id");

    public void clickMyElement() {
        driver.findElement(myElement).click();
    }
}
```

### Creating a New Test

Create a new test class in `src/test/java/appium/mobile/automation/tests/`:

```java
package appium.mobile.automation.tests;

import org.testng.annotations.Test;
import appium.mobile.automation.driver.DriverManager;
import appium.mobile.automation.pages.MyPage;
import io.appium.java_client.AppiumDriver;

public class MyPageTest extends BaseTest {

    @Test
    public void testMyFeature() {
        AppiumDriver driver = DriverManager.getDriver();
        MyPage myPage = new MyPage(driver);
        myPage.clickMyElement();
    }
}
```

## Troubleshooting

### Common Issues

1. **Appium Server Connection Error**
   - Ensure Appium server is running: `appium`
   - Check that the server URL matches in `DriverFactory` (default: `http://127.0.0.1:4723`)

2. **Device Not Found**
   - For Android: Run `adb devices` to verify device connection
   - For iOS: Check that simulator is running or device is connected

3. **App Not Found**
   - Verify app path in `DriverFactory` is correct
   - Ensure app file exists at specified location

4. **Element Not Found**
   - Use Appium Inspector to identify correct locators
   - Ensure element is visible before interacting

## Best Practices

1. **Use Page Object Model**: Keep tests clean and maintainable
2. **Wait for Elements**: Implement explicit waits for element visibility
3. **Handle Exceptions**: Implement proper error handling and logging
4. **Test Independence**: Ensure tests don't depend on execution order
5. **Clean Resources**: Always clean up driver instances in teardown
6. **Use Meaningful Assertions**: Write clear and descriptive assertions

## Contributing

1. Create a feature branch: `git checkout -b feature/your-feature`
2. Commit changes: `git commit -m 'Add your feature'`
3. Push to branch: `git push origin feature/your-feature`
4. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Resources

- [Appium Documentation](http://appium.io/)
- [Appium Java Client](https://github.com/appium/java-client)
- [Selenium WebDriver](https://www.selenium.dev/)
- [TestNG Documentation](https://testng.org/)
- [Maven Documentation](https://maven.apache.org/)

## Support

For issues or questions, please open an issue in the repository or contact the development team.
