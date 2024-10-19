package steps;

import io.qameta.allure.Step;
import pages.ProductPage;

public class ProductPageSteps {

    private final ProductPage PRODUCT_PAGE = new ProductPage();

    @Step
    public void clickAddToCart(){
        PRODUCT_PAGE.clickAddToCartButton();
    }

    @Step
    public void selectSize(String size){
        PRODUCT_PAGE.selectSize(size);
    }

    @Step
    public void selectColor(String color){
        PRODUCT_PAGE.selectColor(color);
    }
}
