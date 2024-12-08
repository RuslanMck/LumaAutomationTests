package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.Map;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public abstract class TestConfig {

    public void basicConfigs() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        //This configuration is needed to run tests from Jenkins using Selenoid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "104.0");

        // Uses default version if not specified

// Create a map for Selenoid-specific options
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);  // Enable VNC for viewing browser sessions
        selenoidOptions.put("enableVideo", true);  // Enable video recording

        capabilities.setCapability("selenoid:options", selenoidOptions);

// Create the RemoteWebDriver instance
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("http://172.18.0.3:4444/wd/hub").toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

// Set the WebDriver in Selenide
        WebDriverRunner.setWebDriver(driver);

// Example Test
        driver.get("https://example.com");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
