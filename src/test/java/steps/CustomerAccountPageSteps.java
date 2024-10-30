package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.CustomerAccountPage;

public class CustomerAccountPageSteps {

    private final CustomerAccountPage CUSTOMER_ACCOUNT_PAGE = new CustomerAccountPage();

    @Step("Fetch the registration confirmation message")
    public String fetchRegistrationConfirmationMessage(){
       return CUSTOMER_ACCOUNT_PAGE.getRegistrationConfirmationMessageText();
    }

    @Step("Fetch the welcome message from the header")
    public String fetchWelcomeMessage(){
        return CUSTOMER_ACCOUNT_PAGE.getWelcomeMessageText();
    }

    @Step("Expand the customer account menu on the header")
    public void clickCustomerAccountButton(){
        CUSTOMER_ACCOUNT_PAGE.clickHeaderCustomerAccountButton();
    }

    @Step("Click the Sign Out button")
    public void loggOutFormAccount(){
        CUSTOMER_ACCOUNT_PAGE.clickSignOutButton();
    }

    @Step("Verify if the customer first and last name matches the expected value")
    public boolean checkCustomerName(String expectedFirstName, String expectedLestName){
        return CUSTOMER_ACCOUNT_PAGE.getContactBlockText(expectedFirstName, expectedLestName);
    }
}
