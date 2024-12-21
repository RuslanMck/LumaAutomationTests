package ui.registration;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import data.ExpactedLinksAddress;
import data.ExpectedStrings;
import dataProvider.CredentialsDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CreateAccountPage;
import pages.CustomerAccountPage;
import steps.CreateAccountPageSteps;
import steps.HeaderSteps;
import ui.TestConfig;

public class AccountRegistrationTest extends TestConfig {

    private final CreateAccountPage createAccountPage = new CreateAccountPage();
    private final CreateAccountPageSteps CREATE_ACCOUNT_PAGE_STEPS = new CreateAccountPageSteps();
    private final CreateAccountPage CREATE_ACCOUNT_PAGE = new CreateAccountPage();
    private final CustomerAccountPage CUSTOMER_ACCOUNT_PAGE = new CustomerAccountPage();
    private final HeaderSteps HEADER_STEPS = new HeaderSteps();


    @BeforeClass
    public void setUp() {
        super.basicConfigs();
        Selenide.open(CREATE_ACCOUNT_PAGE.getPageUrl());
    }


    @Test( invocationCount = 1, description = "Verify that user can register an account", dataProviderClass = CredentialsDataProvider.class, dataProvider = "registrationValidData")
    public void accountRegistration(String firstName, String lastName, String email, String password) {
        System.out.println("------------------------------> Start of accountRegistration");
        Assert.assertEquals(createAccountPage.getPageTitle(), "Create New Customer Account");
        CREATE_ACCOUNT_PAGE_STEPS.enterFirstName(firstName);
        CREATE_ACCOUNT_PAGE_STEPS.enterLastName(lastName);
        CREATE_ACCOUNT_PAGE_STEPS.enterEmail(email);
        CREATE_ACCOUNT_PAGE_STEPS.enterPassword(password);
        CREATE_ACCOUNT_PAGE_STEPS.enterPasswordConfirmation(password);
        CREATE_ACCOUNT_PAGE_STEPS.clickCreateAccountButton();
//        WebDriverRunner.getWebDriver().wait(1000);

        String expectedUrl = ExpactedLinksAddress.CUSTOMER_ACCOUNT_PAGE.getValue();
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        System.out.println("------------------------------> Assert 1");
        Assert.assertEquals(actualUrl, expectedUrl, "Customer account page URL does not match the expected value");

        String expectedConfirmationMessage = ExpectedStrings.REGISTRATION_CONFIRMATION_MESSAGE.getValue();
        String actualConfirmationMessage = CUSTOMER_ACCOUNT_PAGE.getRegistrationConfirmationMessageText();
        System.out.println("------------------------------> Assert 2");
        Assert.assertEquals(actualConfirmationMessage,expectedConfirmationMessage, "The registration confirmation message does not match the expected results");


        String expectedWelcomeMessage = ExpectedStrings.HEADER_WELCOME_MESSAGE.getValue();
        String actualWelcomeMessage = CUSTOMER_ACCOUNT_PAGE.getWelcomeMessageText();
        System.out.println("------------------------------> Assert 3");
        Assert.assertEquals(actualWelcomeMessage,expectedWelcomeMessage + " " + firstName + " " + lastName + "!", "Header welcome message does not match the expected result");

        HEADER_STEPS.checkIfUserLoggedInAndLogout();
        Selenide.open(CREATE_ACCOUNT_PAGE.getPageUrl());
    }

    @AfterClass
    public void tierDown() {
        System.out.println("------------------------------> tierDown()");
        HEADER_STEPS.checkIfUserLoggedInAndLogout();
    }
}
