package steps;

import pages.CategoryPage;

public class CategoryPageSteps {

    private final CategoryPage CATEGORY_PAGE = new CategoryPage();

    public void clickOnProduct(int position){
        CATEGORY_PAGE.clickProduct(0);
    }
}
