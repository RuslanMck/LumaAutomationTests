package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.CreateAccountPage;

public class CreateAccountPageSteps {

    private final CreateAccountPage CREATE_ACCOUNT_PAGE = new CreateAccountPage();

    @Step("Populate first name field with {firstName}")
    public void enterFirstName(String firstName){
        CREATE_ACCOUNT_PAGE.populateFirstNameInputField(firstName);
    }

    @Step("Populate last name field with {lastName}")
    public void enterLastName(String lastName){
        CREATE_ACCOUNT_PAGE.populateLastNameInputField(lastName);
    }

    @Step("Populate email field with {email}")
    public void enterEmail(String email){
        CREATE_ACCOUNT_PAGE.populateEmailInputField(email);
    }

    @Step("Populate password field with {password}")
    public void enterPassword(String password){
        CREATE_ACCOUNT_PAGE.populatePasswordInputField(password);
    }

    @Step("Populate password confirmation field with {password}")
    public void enterPasswordConfirmation(String password){
        CREATE_ACCOUNT_PAGE.populatePasswordConfirmationInputField(password);
    }

    @Step("Click the Create account button")
    public void clickCreateAccountButton(){
        CREATE_ACCOUNT_PAGE.getCreateAccountButton().shouldBe(Condition.visible);
        CREATE_ACCOUNT_PAGE.clickCreateAccountButton();
    }


}
