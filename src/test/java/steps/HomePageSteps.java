package steps;

import io.qameta.allure.Step;
import pages.HomePage;

public class HomePageSteps {

    private final HomePage HOME_PAGE = new HomePage();

    @Step("Verify that the Sign in button is clickable")
    public void clickSignInButton(){
        HOME_PAGE.clickSignInButton();
    }
}
