package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.LoginPage;

import java.util.Objects;

public class LoginPageSteps {

    private final LoginPage LOGIN_PAGE = new LoginPage();

    public void login(String email, String password){
        LOGIN_PAGE.enterEmail(email);
        LOGIN_PAGE.enterPassword(password);
        LOGIN_PAGE.clickLoginButton();
    }

    @Step("Fetch the page title and ensure it is visible")
    public String fetchPageTitleForVerification(){
        LOGIN_PAGE.getPageTitle().shouldBe(Condition.visible);
        return LOGIN_PAGE.getPageTitleText();
    }

    @Step("Fetch the registration block visibility")
    public boolean isRegistrationBlockVisible(){
        return LOGIN_PAGE.getRegistrationBlock().is(Condition.visible);
    }

    @Step("Fetch the registration block title and ensure it is visible")
    public String fetchRegistrationBlockTitleForVerification(){
        LOGIN_PAGE.getRegistrationBlockTitle().shouldBe(Condition.visible);
        return LOGIN_PAGE.getRegistrationBlockTitleText();
    }

    @Step("Fetch the login block visibility")
    public boolean isLoginBlockVisible(){
        return LOGIN_PAGE.getLoginBlock().is(Condition.visible);
    }

    @Step("Fetch the login block title and ensure it is visible")
    public String fetchLoginBlockTitleForVerification(){
        LOGIN_PAGE.getLoginBlockTitle().shouldBe(Condition.visible);
        return LOGIN_PAGE.getLoginBlockTitleText();
    }

    @Step("Fetch the registration button visibility")
    public boolean isRegistrationButtonVisible(){
        return LOGIN_PAGE.getRegistrationButton().is(Condition.visible);
    }

    @Step("Fetch the Registration button text for verification")
    public String fetchRegistrationButtonTextForVerification(){
        LOGIN_PAGE.getRegistrationButton().shouldBe(Condition.visible);
        return LOGIN_PAGE.getRegistrationButtonText();
    }

    @Step("Fetch the Registration button link for verification")
    public String fetchRegistrationButtonLinkForVerification(){
        LOGIN_PAGE.getRegistrationButton().shouldBe(Condition.visible);
        return LOGIN_PAGE.getRegistrationButtonLink();
    }

    @Step("Fetch the email input field visibility")
    public boolean isEmailInputFieldVisible(){
        return LOGIN_PAGE.getEmailInputField().is(Condition.visible);
    }

    @Step("Fetch the password input field visibility")
    public boolean isPasswordInputFieldVisible(){
        return LOGIN_PAGE.getPasswordInputField().is(Condition.visible);
    }

    @Step("Fetch the login button visibility")
    public boolean isLoginButtonVisible(){
        return LOGIN_PAGE.getLoginButton().is(Condition.visible);
    }

    @Step("Fetch the forgot password button visibility")
    public boolean isForgotPasswordButtonVisible(){
        return LOGIN_PAGE.getForgotPasswordButton().is(Condition.visible);
    }

    @Step("Fetch the email input field isRequired status")
    public boolean isEmailInputFieldRequired(){
        return Objects.requireNonNull(LOGIN_PAGE.getEmailInputField().getAttribute("data-validate"))
                .equals("{required:true, 'validate-email':true}");
    }

    @Step("Fetch the password input field isRequired status")
    public boolean isPasswordInputFieldRequired(){
        return Objects.requireNonNull(LOGIN_PAGE.getPasswordInputField().getAttribute("data-validate"))
                .equals("{required:true}");
    }

    @Step("Fetch the Email validation message text for verification")
    public String fetchEmailValidationMessageText(){
        LOGIN_PAGE.getEmailValidationMessage().shouldBe(Condition.visible);
        return LOGIN_PAGE.getEmailValidationMessageText();
    }

    @Step("Fetch the Password validation message text for verification")
    public String fetchEPasswordValidationMessageText(){
        LOGIN_PAGE.getPasswordValidationMessage().shouldBe(Condition.visible);
        return LOGIN_PAGE.getPasswordValidationMessageText();
    }

    @Step("Interact with login button by click")
    public void clickLoginButton(){
        LOGIN_PAGE.clickLoginButton();
    }

    @Step("Populate email field with {email}")
    public void enterEmail(String email){
        LOGIN_PAGE.enterEmail(email);
    }

    @Step("Populate password field with {password}")
    public void enterPassword(String password){
        LOGIN_PAGE.enterPassword(password);
    }

}
