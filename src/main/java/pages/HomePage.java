package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.ExpactedLinksAddress;
import lombok.Data;

@Data
public class HomePage extends BasicPageElements {

    private final String BASE_URL = ExpactedLinksAddress.HOMEPAGE_URL.getValue();

    private SelenideElement signInButton = Selenide.$x("//header//ul[@class='header links']//a[text()[normalize-space() = 'Sign In']]");

    public void clickSignInButton(){
        signInButton.shouldBe(Condition.visible);
        signInButton.click();
    }
}
