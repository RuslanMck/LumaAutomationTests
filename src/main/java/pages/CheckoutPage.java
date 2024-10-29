package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.ExpactedLinksAddress;
import lombok.Getter;

import java.time.Duration;

@Getter
public class CheckoutPage {

    private final String BASE_URL = ExpactedLinksAddress.CHECKOUT_PAGE.getValue();
    private final SelenideElement FREE_SHIPPING_METHOD = Selenide.$("#label_method_bestway_tablerate");
    private SelenideElement nextButton = Selenide.$(".continue");
    private SelenideElement checkoutButton = Selenide.$(".checkout");

    public void clickFreeShippingMethod(){
        FREE_SHIPPING_METHOD.shouldBe(Condition.visible, Duration.ofSeconds(5));
        FREE_SHIPPING_METHOD.click();
    }

    public void clickTheNextButton(){
        nextButton.shouldBe(Condition.visible);
        nextButton.click();
    }

    public void clickTheCheckoutButton(){
        checkoutButton.shouldBe(Condition.visible);
        checkoutButton.click();
    }
}
