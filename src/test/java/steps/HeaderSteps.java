package steps;

import io.qameta.allure.Step;
import pages.BasicPageElements;

public class HeaderSteps {

    private final BasicPageElements BASIC_PAGE_ELEMENTS = new BasicPageElements();

    @Step("Click the user account button on header")
    public void navigateToLoginPage(){
        BASIC_PAGE_ELEMENTS.clickHeaderSignInButton();
    }

    @Step("Navigate to the '{categoryName}' top category")
    public void navigateToTopCategory(String categoryName){
        BASIC_PAGE_ELEMENTS.navigateToCategory(categoryName);
    }

    @Step("Open the mini cart block")
    public void openMiniCartBlock(){
        BASIC_PAGE_ELEMENTS.clickMiniCartButton();
    }

    @Step("Navigate to the checkout page from the mini cart")
    public void navigateToCheckout(){
        BASIC_PAGE_ELEMENTS.clickCheckoutButtonInMiniCart();
    }
}
