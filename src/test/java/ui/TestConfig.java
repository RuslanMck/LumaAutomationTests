package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Map;

import java.net.MalformedURLException;
import java.util.HashMap;


public abstract class TestConfig {

    public void basicConfigs() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "latest");
            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", selenoidOptions);

            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://selenoid:4444/wd/hub"), capabilities);

            // Log to check if the WebDriver has successful initialization
            System.out.println("WebDriver initialized successfully.");

            WebDriverRunner.setWebDriver(driver);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.err.println("MalformedURLException occurred: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An error occurred during WebDriver setup: " + e.getMessage());
        }
    }
}
