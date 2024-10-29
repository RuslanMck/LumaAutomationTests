package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class CustomerAccountPage extends BasicPageElements {

    private final String PAGE_URL = "http://46.101.147.48/customer/account/";

//    private SelenideElement registrationConfirmationMessage = Selenide.$("[role='alert']");
    private SelenideElement registrationConfirmationMessage = Selenide.$("[data-ui-id='message-success']");

    public String getRegistrationConfirmationMessageText(){
        registrationConfirmationMessage.shouldBe(Condition.visible);
        return registrationConfirmationMessage.text();
    }
}
