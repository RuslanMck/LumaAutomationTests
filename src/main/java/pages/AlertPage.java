package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

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
    private SelenideElement ConfirmResult = Selenide.$("#demo");
    private SelenideElement PromptResult = Selenide.$("#demo1");

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

    public String getConfirmResultText(){
        return ConfirmResult.text();
    }

    public String getPromptResultText(){
        return PromptResult.text();
    }

    public void acceptAlert(){
        if(waitForAlert(5000)){
        Selenide.switchTo().alert().accept();}
        else {
            System.out.println("Alert did not appear within the timeout.");
        }
    }

    public void dismissAlert(){
        if (waitForAlert(5000)){
            Selenide.switchTo().alert().dismiss();
        } else {
            System.out.println("Alert did not appear within the timeout.");
        }
    }

    public void populateTextToAlert(String text){
        if (waitForAlert(5000)){
            Selenide.switchTo().alert().sendKeys(text);
        } else {
            System.out.println("Alert did not appear within the timeout.");
        }
    }

    public String getAlertText(){
        if (waitForAlert(5000)){
            return Selenide.switchTo().alert().getText();
        } else {
            return "No text is displayed in the alert popup";
        }
    }

    public boolean isAlertDisplayed(){
        return waitForAlert(500);
    }

    /**
     * This method will wait for browser alert to be displayed. Waiting time can be set up using timeoutMillis param.
     * @param timeoutMillis setting up the waiting time for alert to be displayed.
     * @return if alert is displayed - returns true, other ways - returns false.
     */
    @SneakyThrows
    public static boolean waitForAlert(long timeoutMillis){
        long waitingEndTime = System.currentTimeMillis() + timeoutMillis;
        while (System.currentTimeMillis() < waitingEndTime){
            try{
                Selenide.switchTo().alert();
                return true;
            } catch (org.openqa.selenium.NoAlertPresentException e){
                System.out.println("Alert is not displayed");
                sleep(200);
            }
        }
        return false;
    }

    public void goBack(){
        Selenide.switchTo().defaultContent();
    }

}
