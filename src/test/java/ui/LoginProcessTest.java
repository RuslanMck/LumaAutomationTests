package ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.ExpectedStrings;
import dataProvider.CredentialsDataProvider;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasicPageElements;
import pages.LoginPage;
import steps.LoginPageSteps;

public class LoginProcessTest {

    private final LoginPage LOGIN_PAGE = new LoginPage();
    private final LoginPageSteps LOGIN_PAGE_STEPS = new LoginPageSteps();
    private final BasicPageElements BASIC_PAGE_ELEMENTS = new BasicPageElements();

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open(LOGIN_PAGE.getBaseUrl());
    }

    @Test(description = "Verify that user can login to an existed account", dataProviderClass = CredentialsDataProvider.class, dataProvider = "loginValidData")
    public void checkUserLogin(String email, String password, String firstName, String lastName) {
        LOGIN_PAGE_STEPS.login(email, password);

        String expectedWelcomeMessage = ExpectedStrings.HEADER_WELCOME_MESSAGE.getValue();
        String actualWelcomeMessage = BASIC_PAGE_ELEMENTS.getWelcomeMessageText();
        Assert.assertEquals(actualWelcomeMessage,expectedWelcomeMessage + " " + firstName + " " + lastName + "!", "Header welcome message does not match the expected result");

    }




}
