package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import data.ExpactedLinksAddress;

import java.time.Duration;

public class OrderConfirmationPage {

    private final String BASE_URL = ExpactedLinksAddress.ORDER_CONFIRMATION_PAGE.getValue();
    private SelenideElement pageTitle = Selenide.$(".page-title");
    private SelenideElement continueShoppingButton = Selenide.$(".continue");

    public String getPageTitle(){
        pageTitle.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return pageTitle.text();
    }

    public void clickContinueButton(){
        continueShoppingButton.shouldBe(Condition.visible);
        continueShoppingButton.click();
    }

    public void waitForPageLoading() {
        continueShoppingButton.shouldBe(Condition.visible);
    }

}
