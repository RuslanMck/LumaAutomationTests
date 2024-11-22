package steps;

import io.qameta.allure.Step;
import pages.IFramePage;

public class IFrameSteps {

    private final IFramePage IFRAME_PAGE = new IFramePage();

    @Step("Populate the text into the input field in iFrame")
    public void insertText(String text){
        IFRAME_PAGE.inputText(text);
    }

    @Step("Populate the email input field")
    public void insertEmail(String email){
        IFRAME_PAGE.inputEmail(email);
    }

    @Step("Click the email subscription button")
    public void clickSubscriptionButton(){
        IFRAME_PAGE.clickSubscriptionButton();
    }

    public boolean verifySubscription(){
        return IFRAME_PAGE.isSubscribed();
    }

}
