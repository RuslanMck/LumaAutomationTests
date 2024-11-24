package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AlertPage;

import java.time.Duration;

public class AlertPageSteps {

    private final AlertPage ALERT_PAGE = new AlertPage();

    @Step("Open the browser alert")
    public void openAlert(){
        ALERT_PAGE.clickAlertWithOkSwitch();
        ALERT_PAGE.clickAlertWithOkButton();
    }

    @Step("Open the browser confirm alert")
    public void openConfirmAlert(){
        ALERT_PAGE.clickAlertOKAndCancelSwitch();
        ALERT_PAGE.clickAlertOKAndCancelButton();
    }

    @Step("Open the browser prompt alert")
    public void openPromptAlert(){
        ALERT_PAGE.clickAlertTextboxSwitch();
        ALERT_PAGE.clickAlertTextboxButton();
    }

    @Step("Get the status of alert popup visibility")
    public boolean isAlertDisplayed(){
        return ALERT_PAGE.isAlertDisplayed();
    }

    /**
     * Verifying the absence of the browser alert by using WebDriverWait (Selenium utility that helps in explicit waits). <br>
     * try Block: <br>
     * - Attempts to wait for the alert to appear using ExpectedConditions.alertIsPresent(). <br>
     * - If an alert is found, the method returns false because it confirms that the alert is displayed. <br>
     * catch Block: <br>
     * - If no alert appears within the specified timeout (1 second), until throws a TimeoutException. <br>
     * - This exception is caught in the catch block, and the method returns true to indicate that the alert is not present.
     * @param waitingTime the time method will wait for alert to appear
     * @return false if the alert is displayed. True - if the alert is not displayed
     */
    @Step("Verify if alert is not displayed")
    public boolean isAlertNotDisplayed(int waitingTime) {
        try {
            new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(waitingTime))
                    .until(ExpectedConditions.alertIsPresent());
            return false;
        } catch (TimeoutException e) {
            return true;
        }
    }


    @Step("Get the text from the alert popup")
    public String getAlertPopupText(){
        return ALERT_PAGE.getAlertText();
    }

    @Step("Click the OK button on the alert popup")
    public void clickOkButton(){
        ALERT_PAGE.acceptAlert();
    }

    @Step("Get result text after interacting with confirmation alert")
    public String getConfirmationMessage(){
        return ALERT_PAGE.getConfirmResultText();
    }

    @Step("Get result text after interacting with prompt alert")
    public String getPromptMessage(){
        return ALERT_PAGE.getPromptResultText();
    }

    @Step("Click the Cancel button on alert popup")
    public void clickCancelButton(){
        ALERT_PAGE.dismissAlert();
    }

    @Step("Populate the text into the input field in alert popup")
    public void populateTextField(String text){
        ALERT_PAGE.populateTextToAlert(text);
    }
}
