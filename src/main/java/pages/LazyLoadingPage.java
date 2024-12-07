package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.PageNavigationHelper;
import lombok.Getter;

import java.time.Duration;

@Getter
public class LazyLoadingPage {

    private SelenideElement productFrame;

    public LazyLoadingPage() {
    }

    /**
     * This class constructor needs to initialize the productFrame SelenideElement.
     * Without this constructor the productFrame elements will have null as an element locator. Inside constructor,
     * we call the LazyLoadingPage inner class getSelectorBySearchTerm() that will create Xpath based on searchTerm
     * and return this Xpath. Then we use this new Xpath as locator for productFrame SelenideElement.
     * @param searchTerm string that should be presented in the searched product title
     */
    public LazyLoadingPage(String searchTerm) {
        productFrame = Selenide.$x(getSelectorBySearchTerm(searchTerm));
    }

    private final String BASE_URL = "https://www.marktplaats.nl/cp/537/witgoed-en-apparatuur/";

    private SelenideElement cookieContainer = Selenide.$(".message-container");
    private SelenideElement acceptCookieButton = Selenide.$x("//button[@title='Accepteren']");
    private SelenideElement cookieIFrame = Selenide.$("#sp_message_iframe_1202018");

    public boolean productFrameIsExists() {
        return productFrame.exists();
    }

    /**
     *  This method take the searchTerm string, adds it to another string using format specifier "%s".
     *  The resulted string will be used as a Xpath value for the search product element
     * @param searchTerm string that should be presented in the searched product title
     * @return Xpath value in the String format
     */
    public String getSelectorBySearchTerm(String searchTerm) {
        String lowerCaseSearchTerm = searchTerm.toLowerCase();
        String xpath = String.format("//span[@class='hz-Listing-title' and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]", lowerCaseSearchTerm);

        return (xpath);
    }

    public void acceptCookies() {
        Selenide.switchTo().frame(cookieIFrame);
        cookieContainer.shouldBe(Condition.visible, Duration.ofSeconds(5));
        acceptCookieButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        acceptCookieButton.click();
    }

    public void scrollToProductFrame() {
        while (!productFrame.exists()) {
            PageNavigationHelper.ScrollPageToLoadElement(productFrame, 500);
        }
    }
}
