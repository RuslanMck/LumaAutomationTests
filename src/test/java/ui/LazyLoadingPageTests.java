package ui;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LazyLoadingPage;
import steps.LazyLoadingPageSteps;

public class LazyLoadingPageTests extends TestConfig{
    //Espresso Machine works for this test
    String searchTerm = "Espresso Machine";
    private final LazyLoadingPage LAZY_LOADING_PAGE = new LazyLoadingPage(searchTerm);
    private final LazyLoadingPageSteps LAZY_LOADING_PAGE_STEPS = new LazyLoadingPageSteps(LAZY_LOADING_PAGE);

    @BeforeClass
    public void setUp(){
        super.basicConfigs();
        Selenide.open(LAZY_LOADING_PAGE.getBASE_URL());
        LAZY_LOADING_PAGE.acceptCookies();
    }

    @Test
    public void verifyLazyLoadingTest(){
        boolean isBlockExists = LAZY_LOADING_PAGE_STEPS.isProductFrameBlockExistsOnPage();
        Assert.assertFalse(isBlockExists);

        LAZY_LOADING_PAGE_STEPS.scrollToLoadElement();
        isBlockExists = LAZY_LOADING_PAGE_STEPS.isProductFrameBlockExistsOnPage();
        Assert.assertTrue(isBlockExists);

    }

}
