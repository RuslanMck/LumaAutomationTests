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
//        capabilities.setCapability("browserVersion", "104.0");

        // Create a regular map and populate it
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", true);

        // Set the capability to use the map
        capabilities.setCapability("selenoid:options", selenoidOptions);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        //This WebDriverRunner configuration is needed for Selenoid use the exact driver that we identified above
        WebDriverRunner.setWebDriver(driver);
    }
}
