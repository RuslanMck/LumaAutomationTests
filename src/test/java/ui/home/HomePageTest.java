package ui.home;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import steps.HomePageSteps;
import ui.TestConfig;

import java.util.Arrays;
import java.util.List;

public class HomePageTest extends TestConfig {

    private final HomePage HOME_PAGE = new HomePage();
    private final HomePageSteps HOME_PAGE_STEPS = new HomePageSteps();
    private final LoginPage LOGIN_PAGE = new LoginPage();

    @BeforeClass
    public void setUp(){
        super.basicConfigs();
        Selenide.open(HOME_PAGE.getBASE_URL());
    }

    @Test(description = "Verify the sign in page opening process")
    public void signInCheck(){
        boolean signInButtonIsVisible = HOME_PAGE_STEPS.signInButtonIsVisible();
        Assert.assertTrue(signInButtonIsVisible);
        HOME_PAGE_STEPS.clickSignInButton();
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedUrl = LOGIN_PAGE.getBaseUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Sign in page URL does not match the expected value");
    }

    @Test(description = "Verify that the top level categories names matches the expected values")
    public void checkNavigationManu(){
        List<String> expectedCategoriesNames = Arrays.asList("Women", "Men", "Gear", "Training", "Sale", "Test");
        List<String> actualCategoriesNames = HOME_PAGE_STEPS.fetchNavigationManuCategoriesNames();
        Assert.assertEquals(expectedCategoriesNames, actualCategoriesNames);
    }

}
