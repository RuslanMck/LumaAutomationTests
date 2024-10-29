package steps;

import io.qameta.allure.Step;
import pages.OrderConfirmationPage;

public class OrderConfirmationPageSteps {

    private final OrderConfirmationPage ORDER_CONFIRMATION_PAGE = new OrderConfirmationPage();

    @Step
    public String fetchPageTitle(){
        ORDER_CONFIRMATION_PAGE.waitForPageLoading();
        return ORDER_CONFIRMATION_PAGE.getPageTitle();
    }

    @Step
    public void proceedToShopping(){
        ORDER_CONFIRMATION_PAGE.clickContinueButton();
    }
}
