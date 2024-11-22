package ui;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IFramePage;
import steps.IFrameSteps;

public class IFrameTest extends TestConfig {

    private final IFramePage IFRAME_PAGE = new IFramePage();
    private final IFrameSteps IFRAME_STEPS = new IFrameSteps();

    @BeforeClass
    public void setUp(){
        super.basicConfigs();
        Selenide.open(IFRAME_PAGE.getBASE_URL());
    }

    @Test(description = "Verify if the text could be populated into the input field in the iFrame")
    public void inputTextToIframe(){
        IFRAME_STEPS.insertText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nec sollicitudin magna." +
                " Duis dictum, purus non vulputate cursus, purus enim tincidunt mauris, a scelerisque ex libero sed " +
                "magna. Etiam a arcu vestibulum, pretium nisl vel, consequat nisl. Sed scelerisque tempor turpis. " +
                "Sed tincidunt dui ex, at finibus dui accumsan id. Duis a risus nisi.");

    }

    @Test(description = "Validate the newsletter subscription by populating the email address and clicking the " +
            "subscription button")
    public void validateNewsletterSubscription(){
        IFRAME_STEPS.insertEmail("test@test.com");
        IFRAME_STEPS.clickSubscriptionButton();
        Assert.assertTrue(IFRAME_STEPS.verifySubscription());
    }

}
