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

    @Step("Click the 'Next' button to proceed to the next checkout step")
    public void proceedToPayment(){
        CHECKOUT_PAGE.clickTheNextButton();
    }

    @Step("Click the 'Place an order button' to finish the order process")
    public void placeAnOrder(){
        CHECKOUT_PAGE.clickTheCheckoutButton();
    }

    @Step("Fetch the name of the single product in the cart")
    public String fetchSingleProductName(){
        return CHECKOUT_PAGE.getProductName();
    }


}
