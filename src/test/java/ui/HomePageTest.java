package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import steps.HomePageSteps;

public class HomePageTest {

    private final HomePage HOME_PAGE = new HomePage();
    private final HomePageSteps HOME_PAGE_STEPS = new HomePageSteps();

    @BeforeClass
    public void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen =true;
        Selenide.open(HOME_PAGE.getBASE_URL());
    }

    @Test(description = "Verify the sign in process")
    public void signInCheck(){
        HOME_PAGE_STEPS.clickSignInButton();
    }
}
