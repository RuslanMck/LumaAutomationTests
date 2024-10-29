package data;

public enum ExpactedLinksAddress {

    REGISTRATION_BUTTON("http://46.101.147.48/customer/account/create/"),
    LOGIN_PAGE_URL("http://46.101.147.48/customer/account/login/referer/aHR0cDovLzQ2LjEwMS4xNDcuNDgv/"),
    HOMEPAGE_URL("http://46.101.147.48/"),
    CREATE_ACCOUNT_PAGE("http://46.101.147.48/customer/account/create/"),
    CATEGORY_PAGE("http://46.101.147.48/men.html"),
    PRODUCT_PAGE("http://46.101.147.48/hero-hoodie.html"),
    CUSTOMER_ACCOUNT_PAGE("http://46.101.147.48/customer/account/"),
    ORDER_CONFIRMATION_PAGE("http://46.101.147.48/checkout/onepage/success/"),
    CHECKOUT_PAGE("http://46.101.147.48/checkout");

    private final String value;

    ExpactedLinksAddress(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


