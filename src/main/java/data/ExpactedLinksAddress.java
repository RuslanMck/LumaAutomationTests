package data;

public enum ExpactedLinksAddress {

    REGISTRATION_BUTTON("http://46.101.147.48/customer/account/create/");

    private final String value;

    ExpactedLinksAddress(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


