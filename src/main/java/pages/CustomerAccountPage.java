package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class CustomerAccountPage extends BasicPageElements {

    private final String PAGE_URL = "http://46.101.147.48/customer/account/";
    private SelenideElement registrationConfirmationMessage = Selenide.$("[data-ui-id='message-success']");
    private SelenideElement contactInformationBlock = Selenide.$(".box-information");

    public String getRegistrationConfirmationMessageText(){
        registrationConfirmationMessage.shouldBe(Condition.visible);
        return registrationConfirmationMessage.text();
    }

    public boolean getContactBlockText(String expectedFirstName, String expectedLestName){
        contactInformationBlock.shouldBe(Condition.visible);
        return contactInformationBlock.text().contains(expectedFirstName + " " + expectedLestName);
    }
}
