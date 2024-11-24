package ui;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
    public void verifyAlert(){
        ALERT_PAGE_STEPS.openAlert();
        Assert.assertTrue(ALERT_PAGE_STEPS.isAlertDisplayed());
        Assert.assertEquals(ALERT_PAGE_STEPS.getAlertPopupText(),"I am an alert box!");
        ALERT_PAGE_STEPS.clickOkButton();
        Assert.assertTrue(ALERT_PAGE_STEPS.isAlertNotDisplayed(1), "Alert should not be displayed " +
                "after clicking OK!");
    }

    @Test(description = "Verify the interactions with the confirmation alert popup")
    public void verifyConfirmAlert(){
        ALERT_PAGE_STEPS.openConfirmAlert();
        Assert.assertTrue(ALERT_PAGE_STEPS.isAlertDisplayed());
        Assert.assertEquals(ALERT_PAGE_STEPS.getAlertPopupText(), "Press a Button !");
        ALERT_PAGE_STEPS.clickOkButton();
        Assert.assertTrue(ALERT_PAGE_STEPS.isAlertNotDisplayed(1), "Alert should not be displayed " +
                "after clicking OK!");
        Assert.assertEquals(ALERT_PAGE_STEPS.getConfirmationMessage(), "You pressed Ok");

        ALERT_PAGE_STEPS.openConfirmAlert();
        Assert.assertTrue(ALERT_PAGE_STEPS.isAlertDisplayed());
        Assert.assertEquals(ALERT_PAGE_STEPS.getAlertPopupText(), "Press a Button !");
        ALERT_PAGE_STEPS.clickCancelButton();
        Assert.assertTrue(ALERT_PAGE_STEPS.isAlertNotDisplayed(1), "Alert should not be displayed " +
                "after clicking Cancel");
        Assert.assertEquals(ALERT_PAGE_STEPS.getConfirmationMessage(), "You Pressed Cancel");
    }

    @Test(description = "Verify the interactions with the prompt alert popup")
    public void verifyPromptAlert(){
        ALERT_PAGE_STEPS.openPromptAlert();
        Assert.assertTrue(ALERT_PAGE.isAlertDisplayed());
        ALERT_PAGE_STEPS.clickCancelButton();
        Assert.assertTrue(ALERT_PAGE_STEPS.isAlertNotDisplayed(1), "Alert should not be displayed " +
                "after clicking Cancel");
        String sampleText = "Hello World!";
        ALERT_PAGE_STEPS.openPromptAlert();
        ALERT_PAGE_STEPS.populateTextField(sampleText);
        ALERT_PAGE_STEPS.clickOkButton();
        Assert.assertEquals(ALERT_PAGE_STEPS.getPromptMessage(), "Hello " + sampleText + " How are you today");
    }

}
