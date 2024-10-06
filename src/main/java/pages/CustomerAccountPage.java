package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class CustomerAccountPage {

    private final String PAGE_URL = "http://46.101.147.48/customer/account/";

    private SelenideElement registrationConfirmationMessage = Selenide.$("[role='alert']");

    public String getRegistrationConfirmationMessageText(){
        registrationConfirmationMessage.shouldBe(Condition.visible);
        return registrationConfirmationMessage.text();
    }
}
