package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class BasicPageElements {

    private SelenideElement headerAccountButton = Selenide.$(".customer-welcome");
    private SelenideElement headerWelcomeMessage = Selenide.$(".logged-in");
    private SelenideElement headerSignOutButton = Selenide.$x("//div[@class='customer-menu']//a[normalize-space(text())='Sign Out']");
    private SelenideElement navigationBlock = Selenide.$(".navigation");
    private ElementsCollection navigationBlockCategories = Selenide.$$x("//li[contains(@class, 'level-top')]");


    public String getWelcomeMessageText(){
        headerWelcomeMessage.shouldBe(Condition.visible);
        return headerWelcomeMessage.text();
    }

    public boolean customerAccountHeaderButtonIsVisible(){
        headerAccountButton.shouldBe(Condition.visible);
        return headerAccountButton.is(Condition.visible);
    }

    public void clickHeaderCustomerAccountButton(){
        headerAccountButton.shouldBe(Condition.visible);
        headerAccountButton.click();
    }

    public void clickSignOutButton(){
        headerSignOutButton.shouldBe(Condition.visible);
        headerSignOutButton.click();
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
