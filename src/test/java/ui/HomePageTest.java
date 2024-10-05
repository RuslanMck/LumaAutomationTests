package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import steps.HomePageSteps;

public class HomePageTest {

    private final HomePage HOME_PAGE = new HomePage();
    private final HomePageSteps HOME_PAGE_STEPS = new HomePageSteps();
    private final LoginPage LOGIN_PAGE = new LoginPage();

    @BeforeClass
    public void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen =true;
        Selenide.open(HOME_PAGE.getBASE_URL());
    }

    @Test(description = "Verify the sign in page opening process")
    public void signInCheck(){
        boolean signInButtonIsVisible = HOME_PAGE_STEPS.signInButtonIsVisible();
        Assert.assertTrue(signInButtonIsVisible);
        HOME_PAGE_STEPS.clickSignInButton();
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedUrl = new LoginPage().baseUrl;
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
