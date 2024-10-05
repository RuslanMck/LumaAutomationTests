package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

@Data
public class HomePage {

    private final String BASE_URL = "http://46.101.147.48/";

    private SelenideElement signInButton = Selenide.$x("//header//ul[@class='header links']//a[text()[normalize-space() = 'Sign In']]");


    public void clickSignInButton(){
        signInButton.shouldBe(Condition.visible);
        signInButton.click();
    }
}
