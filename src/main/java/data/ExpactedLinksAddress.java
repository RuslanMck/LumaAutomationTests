package data;

public enum ExpactedLinksAddress {

    REGISTRATION_BUTTON("http://46.101.147.48/customer/account/create/"),
    LOGIN_PAGE_URL("http://46.101.147.48/customer/account/login/referer/aHR0cDovLzQ2LjEwMS4xNDcuNDgv/"),
    HOMEPAGE_URL("http://46.101.147.48/"),
    CREATE_ACCOUNT_PAGE("http://46.101.147.48/customer/account/create/"),
    CUSTOMER_ACCOUNT_PAGE("http://46.101.147.48/customer/account/");

    private final String value;

    ExpactedLinksAddress(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


