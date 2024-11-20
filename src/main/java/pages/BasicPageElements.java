package pages;

import com.codeborne.selenide.*;
import lombok.Getter;
import lombok.SneakyThrows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class BasicPageElements {

    private SelenideElement headerAccountButton = Selenide.$(".customer-welcome");
    private SelenideElement headerWelcomeMessage = Selenide.$(".logged-in");
    private SelenideElement headerSignOutButton = Selenide.$x("//div[@class='customer-menu']//a[normalize-space(text())='Sign Out']");
    private SelenideElement navigationBlock = Selenide.$(".navigation");
    private SelenideElement signInButton = Selenide.$x("//header//ul[@class='header links']//a[text()[normalize-space() = 'Sign In']]");
    private ElementsCollection navigationBlockCategories = Selenide.$$x("//li[contains(@class, 'level-top')]");
    private SelenideElement miniCartButton = Selenide.$("[data-block='minicart']");
    private SelenideElement miniCartCheckoutButton = Selenide.$("#top-cart-btn-checkout");


    public String getWelcomeMessageText(){
        headerWelcomeMessage.shouldBe(Condition.visible, Duration.ofSeconds(5));
        return headerWelcomeMessage.text();
    }

    public boolean getCustomerAccountButtonVisibility(){
        return headerAccountButton.isDisplayed();
    }

    public void clickMiniCartButton(){
        miniCartButton.shouldBe(Condition.visible);
        miniCartButton.click();
    }

    public void clickCheckoutButtonInMiniCart(){
        miniCartCheckoutButton.shouldBe(Condition.visible, Duration.ofSeconds(5));
        miniCartCheckoutButton.click();
    }


    public boolean customerAccountHeaderButtonIsVisible(){
        headerAccountButton.shouldBe(Condition.visible);
        return headerAccountButton.is(Condition.visible);
    }

    public void clickHeaderCustomerAccountButton(){
        headerAccountButton.shouldBe(Condition.visible);
        headerAccountButton.click();
    }

    public void clickHeaderSignInButton(){
        signInButton.shouldBe(Condition.visible);
        signInButton.click();
    }

    public void clickSignOutButton(){
        headerAccountButton.shouldBe(Condition.visible);
        headerAccountButton.click();
        headerSignOutButton.shouldBe(Condition.visible);
        headerSignOutButton.click();
        headerAccountButton.shouldBe(Condition.disappear, Duration.ofSeconds(6));
    }

    public List<String> getNavigationBlockCategoriesTitles(){
        List<String> categoriesNames = new ArrayList<>();
        for (SelenideElement element : navigationBlockCategories){
            String category = element.getText();
            categoriesNames.add(category);
        }
        return categoriesNames;
    }

    public void navigateToCategory(String categoryName){
        for (SelenideElement element : navigationBlockCategories){
            if (element.getText().equals(categoryName)){
                element.click();
                break;
            }
        }
    }


}
