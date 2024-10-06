package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import data.ExpactedLinksAddress;
import data.ExpectedStrings;
import dataProvider.CredentialsDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.CustomerAccountPage;
import steps.CreateAccountPageSteps;

public class AccountRegistrationTest {

    private final CreateAccountPageSteps CREATE_ACCOUNT_PAGE_STEPS = new CreateAccountPageSteps();
    private final CreateAccountPage CREATE_ACCOUNT_PAGE = new CreateAccountPage();
    private final CustomerAccountPage CUSTOMER_ACCOUNT_PAGE = new CustomerAccountPage();

    @BeforeClass
    public void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open(CREATE_ACCOUNT_PAGE.getPageUrl());
    }

    @Test(description = "Verify that user can register an account",
            dataProviderClass = CredentialsDataProvider.class, dataProvider = "registrationValidData")
    public void accountRegistration(String firstName, String lastName, String email, String password){
        CREATE_ACCOUNT_PAGE_STEPS.enterFirstName(firstName);
        CREATE_ACCOUNT_PAGE_STEPS.enterLastName(lastName);
        CREATE_ACCOUNT_PAGE_STEPS.enterEmail(email);
        CREATE_ACCOUNT_PAGE_STEPS.enterPassword(password);
        CREATE_ACCOUNT_PAGE_STEPS.enterPasswordConfirmation(password);
        CREATE_ACCOUNT_PAGE_STEPS.clickCreateAccountButton();

        String expectedUrl = ExpactedLinksAddress.CUSTOMER_ACCOUNT_PAGE.getValue();
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        String expectedConfirmationMessage = "Thank you for registering with Main Website Store.";
//        String expectedConfirmationMessage = ExpectedStrings.REGISTRATION_CONFIRMATION_MESSAGE.getValue();
        System.out.println(expectedConfirmationMessage);
        String actualConfirmationMessage = CUSTOMER_ACCOUNT_PAGE.getRegistrationConfirmationMessageText();
        Assert.assertEquals(expectedConfirmationMessage, actualConfirmationMessage);


    }
}
