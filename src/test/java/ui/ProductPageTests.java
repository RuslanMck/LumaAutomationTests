package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProductPage;
import steps.ProductPageSteps;

public class ProductPageTests extends TestConfig{

    private final ProductPage PRODUCT_PAGE = new ProductPage();
    private final ProductPageSteps PRODUCT_PAGE_STEPS = new ProductPageSteps();

    @BeforeClass
    public void SetUp() {
        super.basicConfigs();
        Selenide.open(PRODUCT_PAGE.getBASE_URL());
    }

    @Test(description = "Verify that the user can add product to the cart")
    public void addProductToTheCert(){
        PRODUCT_PAGE_STEPS.selectSize("XS");
        PRODUCT_PAGE_STEPS.selectColor("Gray");
        PRODUCT_PAGE_STEPS.clickAddToCart();
    }
}
