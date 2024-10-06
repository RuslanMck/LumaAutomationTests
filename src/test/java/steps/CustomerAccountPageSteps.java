package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.CustomerAccountPage;

public class CustomerAccountPageSteps {

    private final CustomerAccountPage CUSTOMER_ACCOUNT_PAGE = new CustomerAccountPage();

    @Step("Fetch the registration confirmation message and ensure it is visible")
    public String fetchRegistrationConfirmationMessage(){
        CUSTOMER_ACCOUNT_PAGE.getRegistrationConfirmationMessage().shouldBe(Condition.visible);
       return CUSTOMER_ACCOUNT_PAGE.getRegistrationConfirmationMessageText();
    }
}
