package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.HomePage;

public class HomePageSteps {

    private final HomePage HOME_PAGE = new HomePage();

    @Step("Verify that the Sign in button is clickable")
    public void clickSignInButton(){
        HOME_PAGE.clickSignInButton();
    }
    @Step("Verify that the Sign in button is visible")
    public boolean signInButtonIsVisible(){
        return HOME_PAGE.getSignInButton().is(Condition.visible);
    }
}
