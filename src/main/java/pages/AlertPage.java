package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class AlertPage {

    private final String BASE_URL = "https://demo.automationtesting.in/Alerts.html";
    private SelenideElement RejectCookiesButton = Selenide.$x("//button[@aria-label='Do not consent']");
    private SelenideElement AlertOKSwitch = Selenide.$x("//a[text()='Alert with OK ']");
    private SelenideElement AlertOKButton = Selenide.
            $x("//button[normalize-space(text())='click the button to display an alert box:']");
    private SelenideElement AlertOKAndCancelSwitch = Selenide.$x("//a[text()='Alert with OK & Cancel ']");
    private SelenideElement AlertOKAndCancelButton = Selenide.
            $x("//button[normalize-space(text())='click the button to display a confirm box']");
    private SelenideElement AlertTextboxSwitch = Selenide.$x("//a[text()='Alert with Textbox ']");
    private SelenideElement AlertTextboxButton = Selenide.
            $x("//button[normalize-space(text())='click the button to demonstrate the prompt box']");

    public void rejectCookies(){
        RejectCookiesButton.shouldBe(Condition.visible);
        RejectCookiesButton.click();
    }

    public void clickAlertWithOkSwitch(){
        AlertOKSwitch.shouldBe(Condition.visible);
        AlertOKSwitch.click();
    }
    public void clickAlertWithOkButton(){
        AlertOKButton.shouldBe(Condition.visible);
        AlertOKButton.click();
    }

    public void clickAlertOKAndCancelSwitch(){
        AlertOKAndCancelSwitch.shouldBe(Condition.visible);
        AlertOKAndCancelSwitch.click();
    }

    public void clickAlertOKAndCancelButton(){
        AlertOKAndCancelButton.shouldBe(Condition.visible);
        AlertOKAndCancelButton.click();
    }

    public void clickAlertTextboxSwitch(){
        AlertTextboxSwitch.shouldBe(Condition.visible);
        AlertTextboxSwitch.click();
    }

    public void clickAlertTextboxButton(){
        AlertTextboxButton.shouldBe(Condition.visible);
        AlertTextboxButton.click();
    }
}
