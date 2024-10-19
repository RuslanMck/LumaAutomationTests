package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CategoryPage;
import steps.CategoryPageSteps;

public class CategoryPageTests {

    private final CategoryPage CATEGORY_PAGE = new CategoryPage();
    private final CategoryPageSteps CATEGORY_PAGE_STEPS = new CategoryPageSteps();

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.open(CATEGORY_PAGE.getBASE_URL());
    }

    @Test
    public void verifyNavigationToPDP(){
        CATEGORY_PAGE_STEPS.clickOnProduct(0);
    }
}
