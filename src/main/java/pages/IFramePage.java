package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.PageNavigationHelper;
import lombok.Getter;

@Getter
public class IFramePage {

    private final String BASE_URL = "https://practice.expandtesting.com/iframe";
    private SelenideElement iFrameEditor = Selenide.$("iframe#mce_0_ifr");
    private SelenideElement iFrameSubscription = Selenide.$("iframe#email-subscribe");
    private SelenideElement iFrameEditorInput = Selenide.$("#tinymce");
    private SelenideElement iFrameSubscriptionEmailInput = Selenide.$("#email");
    private SelenideElement iFrameSubscriptionSubscribeButton = Selenide.$("#btn-subscribe");
    private SelenideElement subscriptionConfirmationMessage = Selenide.$("#success-message");


    private void switchToEditorIframe() {
        iFrameEditor.shouldBe(Condition.visible);
        Selenide.switchTo().frame(iFrameEditor.toWebElement());
    }

    private void switchToSubscriptionIframe() {
        iFrameSubscription.shouldBe(Condition.visible);
        Selenide.switchTo().frame(iFrameSubscription.toWebElement());
    }

    private void switchToMainContent(){
        Selenide.switchTo().defaultContent();
    }

    public void inputText(String text) {
        PageNavigationHelper.ScrollPageToElement(iFrameEditor);
        switchToEditorIframe();
        iFrameEditorInput.shouldBe(Condition.visible);
        iFrameEditorInput.setValue(text);
        switchToMainContent();
    }

    public void inputEmail(String email) {
        PageNavigationHelper.ScrollPageToElement(iFrameSubscription);
        switchToSubscriptionIframe();
        iFrameSubscriptionEmailInput.shouldBe(Condition.visible);
        iFrameSubscriptionEmailInput.setValue(email);
        switchToMainContent();
    }

    public void clickSubscriptionButton() {
        PageNavigationHelper.ScrollPageToElement(iFrameSubscription);
        switchToSubscriptionIframe();
        iFrameSubscriptionSubscribeButton.shouldBe(Condition.visible);
        iFrameSubscriptionSubscribeButton.shouldBe(Condition.interactable);
        iFrameSubscriptionSubscribeButton.click();
        switchToMainContent();
    }

    public boolean isSubscribed(){
        switchToSubscriptionIframe();
        subscriptionConfirmationMessage.shouldBe(Condition.visible);
        return subscriptionConfirmationMessage.is(Condition.visible)
                && subscriptionConfirmationMessage.text().equals("You are now subscribed!");
    }


}
