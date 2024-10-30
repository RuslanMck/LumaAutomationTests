package ui.registration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import data.ExpactedLinksAddress;
import data.ExpectedStrings;
import dataProvider.CredentialsDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.CustomerAccountPage;
import steps.CreateAccountPageSteps;
import steps.HeaderSteps;

public class AccountRegistrationTest {

    private final CreateAccountPageSteps CREATE_ACCOUNT_PAGE_STEPS = new CreateAccountPageSteps();
    private final CreateAccountPage CREATE_ACCOUNT_PAGE = new CreateAccountPage();
    private final CustomerAccountPage CUSTOMER_ACCOUNT_PAGE = new CustomerAccountPage();
    private final HeaderSteps HEADER_STEPS = new HeaderSteps();


    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open(CREATE_ACCOUNT_PAGE.getPageUrl());
    }

    @Test(description = "Verify that user can register an account", dataProviderClass = CredentialsDataProvider.class, dataProvider = "registrationValidData")
    public void accountRegistration(String firstName, String lastName, String email, String password) throws InterruptedException {
        CREATE_ACCOUNT_PAGE_STEPS.enterFirstName(firstName);
        CREATE_ACCOUNT_PAGE_STEPS.enterLastName(lastName);
        CREATE_ACCOUNT_PAGE_STEPS.enterEmail(email);
        CREATE_ACCOUNT_PAGE_STEPS.enterPassword(password);
        CREATE_ACCOUNT_PAGE_STEPS.enterPasswordConfirmation(password);
        CREATE_ACCOUNT_PAGE_STEPS.clickCreateAccountButton();
//        WebDriverRunner.getWebDriver().wait(1000);

        String expectedUrl = ExpactedLinksAddress.CUSTOMER_ACCOUNT_PAGE.getValue();
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Customer account page URL does not match the expected value");

        String expectedConfirmationMessage = ExpectedStrings.REGISTRATION_CONFIRMATION_MESSAGE.getValue();
        String actualConfirmationMessage = CUSTOMER_ACCOUNT_PAGE.getRegistrationConfirmationMessageText();
        Assert.assertEquals(actualConfirmationMessage,expectedConfirmationMessage, "The registration confirmation message does not match the expected results");


        String expectedWelcomeMessage = ExpectedStrings.HEADER_WELCOME_MESSAGE.getValue();
        String actualWelcomeMessage = CUSTOMER_ACCOUNT_PAGE.getWelcomeMessageText();
        Assert.assertEquals(actualWelcomeMessage,expectedWelcomeMessage + " " + firstName + " " + lastName + "!", "Header welcome message does not match the expected result");
    }

    @AfterClass
    public void tierDown(){
        HEADER_STEPS.checkIfUserLoggedInAndLogout();
    }
}
