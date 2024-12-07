package steps;

import io.qameta.allure.Step;
import pages.LazyLoadingPage;

public class LazyLoadingPageSteps {
    private final LazyLoadingPage LAZY_LOADING_PAGE;

    /**
     * We crate a parametrized constructor for LazyLoadingPageSteps.class to prevent situation of using the empty constructor
     * of LazyLoadingPage.class. If it happens the productFrame SelenideElement from the LazyLoadingPage.class will have
     * null as an object locator witch leads to a test fail. So we parse already created lazyLoadingPage to
     * LazyLoadingPageSteps.class
     * @param lazyLoadingPage object of the LazyLoadingPage.class that has initialized productFrame SelenideElement
     *                        with correct object locator
     */
    public LazyLoadingPageSteps(LazyLoadingPage lazyLoadingPage) {
        this.LAZY_LOADING_PAGE = lazyLoadingPage;
    }

    @Step("Check if marketing block is visible")
    public boolean isProductFrameBlockExistsOnPage() {
        return LAZY_LOADING_PAGE.productFrameIsExists();
    }

    @Step("Scroll page to load element by search term")
    public void scrollToLoadElement() {
        LAZY_LOADING_PAGE.scrollToProductFrame();
    }

}
