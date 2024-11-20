package ui.login;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.ExpectedStrings;
import dataProvider.CredentialsDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasicPageElements;
import pages.LoginPage;
import steps.HeaderSteps;
import steps.LoginPageSteps;
import ui.TestConfig;

public class LoginProcessTest extends TestConfig {

    private final LoginPage LOGIN_PAGE = new LoginPage();
    private final LoginPageSteps LOGIN_PAGE_STEPS = new LoginPageSteps();
    private final BasicPageElements BASIC_PAGE_ELEMENTS = new BasicPageElements();
    private final HeaderSteps HEADER_STEPS = new HeaderSteps();

    @BeforeClass
    public void setUp() {
        super.basicConfigs();
        Selenide.open(LOGIN_PAGE.getBaseUrl());
        HEADER_STEPS.checkIfUserLoggedInAndLogout();
    }

    @Test(description = "Verify that user can login to an existed account", dataProviderClass = CredentialsDataProvider.class, dataProvider = "loginValidData")
    public void checkUserLogin(String email, String password, String firstName, String lastName) {
        LOGIN_PAGE_STEPS.login(email, password);

        String expectedWelcomeMessage = ExpectedStrings.HEADER_WELCOME_MESSAGE.getValue();
        String actualWelcomeMessage = BASIC_PAGE_ELEMENTS.getWelcomeMessageText();
        Assert.assertEquals(actualWelcomeMessage,expectedWelcomeMessage + " " + firstName + " " + lastName + "!", "Header welcome message does not match the expected result");

    }




}
