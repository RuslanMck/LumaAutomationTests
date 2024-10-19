package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class BasicPageElements {

    private SelenideElement headerAccountButton = Selenide.$(".customer-welcome");
    private SelenideElement headerWelcomeMessage = Selenide.$(".logged-in");
    private SelenideElement headerSignOutButton = Selenide.$x("//div[@class='customer-menu']//a[normalize-space(text())='Sign Out']");

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


}
