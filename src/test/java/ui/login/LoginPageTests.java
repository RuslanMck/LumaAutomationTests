package ui.login;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.ExpactedLinksAddress;
import data.ExpectedStrings;
import helpers.LoginPageAssertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.HeaderSteps;
import steps.LoginPageSteps;

public class LoginPageTests {

    private final LoginPageAssertions LOGIN_PAGE_ASSERTIONS = new LoginPageAssertions();
    private final LoginPageSteps LOGIN_PAGE_STEPS = new LoginPageSteps();
    private final LoginPage LOGIN_PAGE = new LoginPage();
    private final HeaderSteps HEADER_STEPS = new HeaderSteps();

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open(LOGIN_PAGE.getBaseUrl());
        HEADER_STEPS.checkIfUserLoggedInAndLogout();
    }

    public void login(String email, String password) {

    }

    @Test(description = "Verify page hero title text")
    public void checkPageTitle() {
        String actualTitle = LOGIN_PAGE_STEPS.fetchPageTitleForVerification();
        String expectedTitle = ExpectedStrings.LOGIN_PAGE_TITLE.getValue();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Verify registration block")
    public void checkRegistrationBlock() {

        LOGIN_PAGE_ASSERTIONS.assertRegistrationBlockVisibility(LOGIN_PAGE_STEPS);
        LOGIN_PAGE_ASSERTIONS.assertLoginBlockTitle(LOGIN_PAGE_STEPS);
        LOGIN_PAGE_ASSERTIONS.assertEmailInputVisibility(LOGIN_PAGE_STEPS);
        LOGIN_PAGE_ASSERTIONS.assertRegistrationButtonVisibility(LOGIN_PAGE_STEPS);
        LOGIN_PAGE_ASSERTIONS.assertRegistrationButtonLink(LOGIN_PAGE_STEPS);
    }

    @Test(description = "Verify login block")
    public void checkLoginBlock() {
        boolean loginBlockVisibility = LOGIN_PAGE_STEPS.isLoginBlockVisible();
        Assert.assertTrue(loginBlockVisibility, "Login block is not visible for user.");

        String actualTitle = LOGIN_PAGE_STEPS.fetchLoginBlockTitleForVerification();
        String expectedTitle = ExpectedStrings.LOGIN_BLOCK_TITLE.getValue();
        Assert.assertEquals(actualTitle, expectedTitle, "Login block title doesn't match the designs.");

        boolean emailInputFieldVisibility = LOGIN_PAGE_STEPS.isEmailInputFieldVisible();
        Assert.assertTrue(emailInputFieldVisibility, "Email input field is not visible vor user");

        boolean passwordInputFieldVisibility = LOGIN_PAGE_STEPS.isPasswordInputFieldVisible();
        Assert.assertTrue(passwordInputFieldVisibility, "Password input field is not visible vor user");

        boolean loginButtonVisibility = LOGIN_PAGE_STEPS.isLoginButtonVisible();
        Assert.assertTrue(loginButtonVisibility, "Login button is not visible vor user");

        boolean forgotPasswordButtonVisibility = LOGIN_PAGE_STEPS.isForgotPasswordButtonVisible();
        Assert.assertTrue(forgotPasswordButtonVisibility, "Forgot password button is not visible vor user");

        boolean emailIsMandatory = LOGIN_PAGE_STEPS.isEmailInputFieldRequired();
        Assert.assertTrue(emailIsMandatory, "Email input field is not mandatory");

        boolean passwordIsMandatory = LOGIN_PAGE_STEPS.isPasswordInputFieldRequired();
        Assert.assertTrue(passwordIsMandatory, "Password input field is not mandatory");
    }

    @Test(description = "Verify login input fields validation")
    public void checkLoginFieldsValidation() {

        new LoginPage().getEmailInputField().click();
        LOGIN_PAGE_STEPS.clickLoginButton();
        String actualEmailValidationMessageText = LOGIN_PAGE_STEPS.fetchEmailValidationMessageText();
        String expectedValidationMessageText = ExpectedStrings.FIELD_IS_REQUIRED.getValue();
        Assert.assertEquals(actualEmailValidationMessageText, expectedValidationMessageText, "Email input fields validation message does not match the designs");

        String actualPasswordValidationMessageText = LOGIN_PAGE_STEPS.fetchEPasswordValidationMessageText();
        String expectedPasswordValidationMessageText = ExpectedStrings.FIELD_IS_REQUIRED.getValue();
        Assert.assertEquals(actualPasswordValidationMessageText, expectedPasswordValidationMessageText, "Password input fields validation message does not match the designs");

        //TODO Add Steps and tests for email input field validation error message.
        // The expected text already added to ExpectedStrings ENUM.
    }


}
