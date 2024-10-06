package pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.ExpactedLinksAddress;
import lombok.Getter;

@Getter
public class LoginPage {

    private String baseUrl = ExpactedLinksAddress.LOGIN_PAGE_URL.getValue();

    private SelenideElement pageTitle = Selenide.$("[data-ui-id='page-title-wrapper']");
    private SelenideElement loginBlock = Selenide.$(".login-container .block-customer-login");
    private SelenideElement registrationBlock = Selenide.$(".login-container .block-new-customer");
    private SelenideElement loginBlockTitle = Selenide.$("#block-customer-login-heading");
    private SelenideElement registrationBlockTitle = Selenide.$("#block-new-customer-heading");
    private SelenideElement registrationButton = Selenide.$(".primary .create");
    private SelenideElement emailInputField = Selenide.$("#email");
    private SelenideElement passwordInputField = Selenide.$("#pass");
    private SelenideElement loginButton = Selenide.$("#send2");
    private SelenideElement forgotPasswordButton = Selenide.$(".remind");
    private SelenideElement emailValidationMessage = Selenide.$("#email-error");
    private SelenideElement passwordValidationMessage = Selenide.$("#pass-error");




    public String getPageTitleText() {
        return pageTitle.getText();
    }

    public String getLoginBlockTitleText() {
        return loginBlockTitle.getText();
    }

    public String getRegistrationBlockTitleText() {
        return registrationBlockTitle.getText();
    }

    public String getRegistrationButtonText(){
        return registrationButton.text();
    }

    public String getRegistrationButtonLink(){
        return registrationButton.getAttribute("href");
    }

    public String getEmailValidationMessageText(){
        return emailValidationMessage.text();
    }

    public String getPasswordValidationMessageText(){
        return passwordValidationMessage.text();
    }

    public void clickLoginButton(){
        loginButton.click();
    }


}
