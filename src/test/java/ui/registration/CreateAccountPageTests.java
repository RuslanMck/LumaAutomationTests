package ui.registration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import dataProvider.CredentialsDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import steps.CreateAccountPageSteps;

public class CreateAccountPageTests {

    private final CreateAccountPageSteps CREATE_ACCOUNT_PAGE_STEPS = new CreateAccountPageSteps();
    private final CreateAccountPage CREATE_ACCOUNT_PAGE = new CreateAccountPage();

    @BeforeClass
    public void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open(CREATE_ACCOUNT_PAGE.getPageUrl());
    }

    @Test(description = "Verify that required input fields are populated correctly",
            dataProviderClass = CredentialsDataProvider.class, dataProvider = "registrationValidData")
    public void shouldPopulateEmailField(String firstName, String lastName, String email, String password){
        String expectedEmail = email;
        String expectedFirstName = firstName;
        String expectedLastName = lastName;

        CREATE_ACCOUNT_PAGE_STEPS.enterFirstName(firstName);
        CREATE_ACCOUNT_PAGE_STEPS.enterLastName(lastName);
        CREATE_ACCOUNT_PAGE_STEPS.enterEmail(email);
        CREATE_ACCOUNT_PAGE_STEPS.enterPassword(password);
        CREATE_ACCOUNT_PAGE_STEPS.enterPasswordConfirmation(password);

        String actualEmail = CREATE_ACCOUNT_PAGE.getEmailInputFieldValue();
        String actualFirstName = CREATE_ACCOUNT_PAGE.getFirstNameInputFieldValue();
        String actualLastName = CREATE_ACCOUNT_PAGE.getLastNameInputFieldValue();

        Assert.assertEquals(actualFirstName, expectedFirstName);
        Assert.assertEquals(actualLastName, expectedLastName);
        Assert.assertEquals(actualEmail, expectedEmail);

    }


}
