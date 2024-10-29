package steps;

import io.qameta.allure.Step;
import pages.CategoryPage;

public class CategoryPageSteps {

    private final CategoryPage CATEGORY_PAGE = new CategoryPage();

    /**
     *
     * @param position should be > 0
     */
    @Step("Click the product")
    public void clickOnProduct(int position){
        CATEGORY_PAGE.clickProduct(position);
    }
}
