package ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AlertPage;
import steps.AlertPageSteps;

public class AlertPageTests extends TestConfig{

    private final AlertPage ALERT_PAGE = new AlertPage();
    private final AlertPageSteps ALERT_PAGE_STEPS = new AlertPageSteps();

    @BeforeClass
    public void setUp(){
        super.basicConfigs();
        Selenide.open(ALERT_PAGE.getBASE_URL());
        ALERT_PAGE.rejectCookies();
    }


    @Test(description = "Verify if the alert with OK button can be closed")
    public void verifyAlertOK(){
        ALERT_PAGE_STEPS.openAlertOK();
    }

}
