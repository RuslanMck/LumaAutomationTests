package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import pages.BasicPageElements;

import java.sql.Driver;

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

    @Step("Fetch logged in user welcome message")
    public String fetchLoginWelcomeMessage(){
        return BASIC_PAGE_ELEMENTS.getWelcomeMessageText();
    }

    @Step("Sign out from the customer account")
    public void signOutFromAccount(){
        BASIC_PAGE_ELEMENTS.clickSignOutButton();
    }

    @Step("Verify if the user account button is visible")
    public boolean isUserLoggedIn(){
        return BASIC_PAGE_ELEMENTS.getCustomerAccountButtonVisibility();
    }

    public void checkIfUserLoggedInAndLogout(){
        if (BASIC_PAGE_ELEMENTS.getCustomerAccountButtonVisibility()){
            BASIC_PAGE_ELEMENTS.clickSignOutButton();
        }
    }
}
