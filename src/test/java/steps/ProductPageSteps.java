package steps;

import io.qameta.allure.Step;
import pages.ProductPage;

public class ProductPageSteps {

    private final ProductPage PRODUCT_PAGE = new ProductPage();

    @Step("Click add to cart button")
    public void clickAddToCart(){
        PRODUCT_PAGE.clickAddToCartButton();
    }

    @Step("Select the size of the product")
    public void selectSize(String size){
        PRODUCT_PAGE.selectSize(size);
    }

    @Step("Select the color of the product")
    public void selectColor(String color){
        PRODUCT_PAGE.selectColor(color);
    }

    @Step("Verify that the add to cart confirmation is displayed")
    public boolean addToCartConfirmationIsDisplayed(){
        return PRODUCT_PAGE.addToCartConfirmationVisible();
    }

    @Step("Fetch the product name")
    public String fetchProductName(){
        return PRODUCT_PAGE.getProductName();
    }
}
