package steps;

import io.qameta.allure.Step;
import pages.AlertPage;

public class AlertPageSteps {

    private final AlertPage ALERT_PAGE = new AlertPage();

    @Step("Open the browser alert with OK button")
    public void openAlertOK(){
        ALERT_PAGE.clickAlertWithOkSwitch();
        ALERT_PAGE.clickAlertWithOkButton();
    }

    @Step("Open the browser alert with OK and Cancel buttons")
    public void openAlertOKAndCancel(){
        ALERT_PAGE.clickAlertOKAndCancelSwitch();
        ALERT_PAGE.clickAlertOKAndCancelButton();
    }

    @Step("Open the browser alert with text input")
    public void openAlertTextbox(){
        ALERT_PAGE.clickAlertTextboxSwitch();
        ALERT_PAGE.clickAlertTextboxButton();
    }
}
