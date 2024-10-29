package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.ExpectedStrings;
import dataProvider.CredentialsDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import steps.*;

public class OrderPlacementTest {

    private final HomePageSteps HOME_PAGE_STEPS = new HomePageSteps();
    private final LoginPageSteps LOGIN_PAGE_STEPS = new LoginPageSteps();
    private final CategoryPageSteps CATEGORY_PAGE_STEPS = new CategoryPageSteps();
    private final ProductPageSteps PRODUCT_PAGE_STEPS = new ProductPageSteps();
    private final HeaderSteps HEADER_STEPS = new HeaderSteps();
    private final CheckoutPageSteps CHECKOUT_PAGE_STEPS = new CheckoutPageSteps();
    private final OrderConfirmationPageSteps ORDER_CONFIRMATION_PAGE_STEPS = new OrderConfirmationPageSteps();

    @BeforeClass
    public void setUp(){
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen=true;
        Selenide.open(new HomePage().getBASE_URL());
    }

    @Test(description = "Verify the order placement flow as a logged in user", dataProviderClass = CredentialsDataProvider.class, dataProvider = "loginValidData")
    public void placeOrderAsLoggedInUser(String email, String password, String firstName, String lastName){
        /**
         * Navigate to login page and verify the login block elements
         */
        HEADER_STEPS.navigateToLoginPage();
        String actualTitle = LOGIN_PAGE_STEPS.fetchLoginBlockTitleForVerification();
        String expectedTitle = ExpectedStrings.LOGIN_BLOCK_TITLE.getValue();
        Assert.assertEquals(actualTitle, expectedTitle, "Login block title doesn't match the designs.");

        boolean emailInputFieldVisibility = LOGIN_PAGE_STEPS.isEmailInputFieldVisible();
        Assert.assertTrue(emailInputFieldVisibility, "Email input field is not visible vor user");

        boolean passwordInputFieldVisibility = LOGIN_PAGE_STEPS.isPasswordInputFieldVisible();
        Assert.assertTrue(passwordInputFieldVisibility, "Password input field is not visible vor user");

        boolean loginButtonVisibility = LOGIN_PAGE_STEPS.isLoginButtonVisible();
        Assert.assertTrue(loginButtonVisibility, "Login button is not visible vor user");

        /**
         * Login to the use account and verify that the user is logged in to the correct page
         */
        LOGIN_PAGE_STEPS.login(email, password);


        HEADER_STEPS.navigateToTopCategory("Men");
        CATEGORY_PAGE_STEPS.clickOnProduct(1);
        PRODUCT_PAGE_STEPS.selectSize("XS");
        PRODUCT_PAGE_STEPS.selectColor("Gray");
        PRODUCT_PAGE_STEPS.clickAddToCart();
        PRODUCT_PAGE_STEPS.addToCartConfirmationIsDisplayed();
        HEADER_STEPS.openMiniCartBlock();
        HEADER_STEPS.navigateToCheckout();
        CHECKOUT_PAGE_STEPS.selectFreeShipping();
        CHECKOUT_PAGE_STEPS.proceedToPayment();
        CHECKOUT_PAGE_STEPS.placeAnOrder();

        String expectedPageTitle = ExpectedStrings.ORDER_CONFIRMATION_PAGE_TITLE.getValue();
        String actualPageTitle = ORDER_CONFIRMATION_PAGE_STEPS.fetchPageTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);

        ORDER_CONFIRMATION_PAGE_STEPS.proceedToShopping();

    }
}
