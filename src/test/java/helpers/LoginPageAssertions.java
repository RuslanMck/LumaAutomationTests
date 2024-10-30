package helpers;

import data.ExpactedLinksAddress;
import data.ExpectedStrings;
import org.testng.Assert;
import steps.LoginPageSteps;

public class LoginPageAssertions {

    public void assertLoginBlockTitle(LoginPageSteps loginPageSteps) {
        String actualTitle = loginPageSteps.fetchLoginBlockTitleForVerification();
        String expectedTitle = ExpectedStrings.LOGIN_BLOCK_TITLE.getValue();
        Assert.assertEquals(actualTitle, expectedTitle, "Login block title doesn't match the designs.");
    }

    public void assertEmailInputVisibility(LoginPageSteps loginPageSteps) {
        boolean emailInputFieldVisibility = loginPageSteps.isEmailInputFieldVisible();
        Assert.assertTrue(emailInputFieldVisibility, "Email input field is not visible vor user");
    }

    public void assertPasswordInputVisibility(LoginPageSteps loginPageSteps) {
        boolean passwordInputFieldVisibility = loginPageSteps.isPasswordInputFieldVisible();
        Assert.assertTrue(passwordInputFieldVisibility, "Password input field is not visible vor user");
    }

    public void assertLoginButtonVisibility(LoginPageSteps loginPageSteps) {
        boolean loginButtonVisibility = loginPageSteps.isLoginButtonVisible();
        Assert.assertTrue(loginButtonVisibility, "Login button is not visible vor user");
    }

    public void assertRegistrationBlockVisibility(LoginPageSteps loginPageSteps) {
        boolean registrationBlockVisibility = loginPageSteps.isRegistrationBlockVisible();
        Assert.assertTrue(registrationBlockVisibility, "Registration block is not visible for user.");
    }

    public void assertRegistrationButtonVisibility(LoginPageSteps loginPageSteps) {
        boolean registrationButtonVisibility = loginPageSteps.isRegistrationButtonVisible();
        Assert.assertTrue(registrationButtonVisibility, "Registration button is not visible for user.");
    }

    public void assertRegistrationButtonLink(LoginPageSteps loginPageSteps) {
        String actualButtonLink = loginPageSteps.fetchRegistrationButtonLinkForVerification();
        String expectedButtonLink = ExpactedLinksAddress.REGISTRATION_BUTTON.getValue();
        Assert.assertEquals(actualButtonLink, expectedButtonLink, "Incorrect registration button link.");
    }


}
