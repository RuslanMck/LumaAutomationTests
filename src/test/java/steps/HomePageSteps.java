package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.HomePage;

import java.util.List;

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

    @Step("Fetch the navigation manu category names")
    public List<String> fetchNavigationManuCategoriesNames(){
        return HOME_PAGE.getNavigationBlockCategoriesTitles();
    }




}
