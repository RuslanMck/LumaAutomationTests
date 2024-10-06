package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.ExpactedLinksAddress;
import lombok.Getter;

@Getter
public class CreateAccountPage {

    private final String pageUrl = ExpactedLinksAddress.CREATE_ACCOUNT_PAGE.getValue();

    private final SelenideElement firstNameInputField = Selenide.$("#firstname");
    private final SelenideElement lastNameInputField = Selenide.$("#lastname");
    private final SelenideElement emailInputField = Selenide.$("#email_address");
    private final SelenideElement passwordInputField = Selenide.$("#password");
    private final SelenideElement passwordConfirmationInputField = Selenide.$("#password-confirmation");
    private final SelenideElement createAccountButton = Selenide.$(".primary .submit");

    public void populateFirstNameInputField(String firstName){
        firstNameInputField.shouldBe(Condition.visible);
        firstNameInputField.setValue(firstName);
    }

    public void populateLastNameInputField(String lastName){
        lastNameInputField.shouldBe(Condition.visible);
        lastNameInputField.setValue(lastName);
    }

    public void populateEmailInputField(String email){
        emailInputField.shouldBe(Condition.visible);
        emailInputField.setValue(email);
    }

    public void populatePasswordInputField(String password){
        passwordInputField.shouldBe(Condition.visible);
        passwordInputField.setValue(password);
    }

    public void populatePasswordConfirmationInputField(String passwordConfirmation){
        passwordConfirmationInputField.shouldBe(Condition.visible);
        passwordConfirmationInputField.setValue(passwordConfirmation);
    }

    public void clickCreateAccountButton(){
        createAccountButton.shouldBe(Condition.visible);
        createAccountButton.click();
    }

    public String getFirstNameInputFieldValue (){
        firstNameInputField.shouldBe(Condition.visible);
        return firstNameInputField.getValue();
    }

    public String getLastNameInputFieldValue (){
        lastNameInputField.shouldBe(Condition.visible);
        return lastNameInputField.getValue();
    }

    public String getEmailInputFieldValue (){
        emailInputField.shouldBe(Condition.visible);
        return emailInputField.getValue();
    }

    public String getPasswordInputFieldType(){
        passwordInputField.shouldBe(Condition.visible);
        return passwordInputField.getAttribute("type");
    }

    public String getPasswordConfirmationInputFieldType(){
        passwordConfirmationInputField.shouldBe(Condition.visible);
        return passwordConfirmationInputField.getAttribute("type");
    }


}
