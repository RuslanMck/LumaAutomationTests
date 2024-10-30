package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.ExpectedStrings;
import dataProvider.CredentialsDataProvider;
import helpers.LoginPageAssertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import steps.*;

public class OrderPlacementTest {

    private final LoginPageAssertions LOGIN_PAGE_ASSERTIONS = new LoginPageAssertions();
    private final CustomerAccountPageSteps CUSTOMER_ACCOUNT_PAGE_STEPS = new CustomerAccountPageSteps();
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
        HEADER_STEPS.checkIfUserLoggedInAndLogout();
    }

    @Test(description = "Verify the order placement flow as a logged in user", dataProviderClass = CredentialsDataProvider.class, dataProvider = "loginValidData")
    public void placeOrderAsLoggedInUser(String email, String password, String firstName, String lastName){
        /**
         * Navigate to login page and verify the login block elements
         */
        HEADER_STEPS.navigateToLoginPage();
        LOGIN_PAGE_ASSERTIONS.assertLoginBlockTitle(LOGIN_PAGE_STEPS);
        LOGIN_PAGE_ASSERTIONS.assertEmailInputVisibility(LOGIN_PAGE_STEPS);
        LOGIN_PAGE_ASSERTIONS.assertPasswordInputVisibility(LOGIN_PAGE_STEPS);
        LOGIN_PAGE_ASSERTIONS.assertLoginButtonVisibility(LOGIN_PAGE_STEPS);
        /**
         * Login to the use account and verify that the user is logged in to the correct page
         */
        LOGIN_PAGE_STEPS.login(email, password);
        Assert.assertTrue(CUSTOMER_ACCOUNT_PAGE_STEPS.checkCustomerName(firstName, lastName));

        HEADER_STEPS.navigateToTopCategory("Men");
        CATEGORY_PAGE_STEPS.clickOnProduct(1);
        String expectedProductName = PRODUCT_PAGE_STEPS.fetchProductName();
        PRODUCT_PAGE_STEPS.selectSize("XS");
        PRODUCT_PAGE_STEPS.selectColor("Gray");
        PRODUCT_PAGE_STEPS.clickAddToCart();
        PRODUCT_PAGE_STEPS.addToCartConfirmationIsDisplayed();
        HEADER_STEPS.openMiniCartBlock();
        HEADER_STEPS.navigateToCheckout();
        CHECKOUT_PAGE_STEPS.selectFreeShipping();
        String actualProductName = CHECKOUT_PAGE_STEPS.fetchSingleProductName();
        Assert.assertEquals(actualProductName, expectedProductName);

        CHECKOUT_PAGE_STEPS.proceedToPayment();
        CHECKOUT_PAGE_STEPS.placeAnOrder();

        String expectedPageTitle = ExpectedStrings.ORDER_CONFIRMATION_PAGE_TITLE.getValue();
        String actualPageTitle = ORDER_CONFIRMATION_PAGE_STEPS.fetchPageTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);

        ORDER_CONFIRMATION_PAGE_STEPS.proceedToShopping();

    }
}
