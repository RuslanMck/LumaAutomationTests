package steps;

import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;
import pages.CheckoutPage;

public class CheckoutPageSteps {

    private final CheckoutPage CHECKOUT_PAGE = new CheckoutPage();

    @Step("Select the free shipping option")
    public void selectFreeShipping(){
        CHECKOUT_PAGE.clickFreeShippingMethod();
    }

    @Step
    public void proceedToPayment(){
        CHECKOUT_PAGE.clickTheNextButton();
    }

    @Step
    public void placeAnOrder(){
        CHECKOUT_PAGE.clickTheCheckoutButton();
    }
}
