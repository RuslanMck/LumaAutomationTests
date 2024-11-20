package ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CategoryPage;
import steps.CategoryPageSteps;

public class CategoryPageTests extends TestConfig {

    private final CategoryPage CATEGORY_PAGE = new CategoryPage();
    private final CategoryPageSteps CATEGORY_PAGE_STEPS = new CategoryPageSteps();

    @BeforeClass
    public void setUp() {
        super.basicConfigs();
        Selenide.open(CATEGORY_PAGE.getBASE_URL());
    }

    @Test(description = "Verify that the user can navigate to the PDP")
    public void verifyNavigationToPDP(){
        CATEGORY_PAGE_STEPS.clickOnProduct(1);
    }
}
