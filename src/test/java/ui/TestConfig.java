package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.URL;
import java.util.Map;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public abstract class TestConfig {

    public void basicConfigs() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "104.0");
            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", selenoidOptions);

            // Log the capabilities being used
            System.out.println("Capabilities: " + capabilities);

            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://172.18.0.3:4444/wd/hub"), capabilities);


            // Log successful WebDriver initialization
            System.out.println("WebDriver initialized successfully.");

            WebDriverRunner.setWebDriver(driver);

            // Open the URL
//            String testUrl = "https://www.marktplaats.nl/cp/537/witgoed-en-apparatuur/";
//            driver.get(testUrl);
//            Assert.assertEquals(driver.getCurrentUrl(), "https://www.marktplaats.nl/cp/537/witgoed-en-apparatuur/", "URL did not match!");
//
//            // Log the URL being opened
//            System.out.println("Opened URL: " + testUrl);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.err.println("MalformedURLException occurred: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An error occurred during WebDriver setup: " + e.getMessage());
        }


    }
}
