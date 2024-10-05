package data;

public enum ExpectedStrings {
    LOGIN_PAGE_TITLE("Customer Login"),
    REGISTRATION_BLOCK_TITLE("New Customers"),
    REGISTRATION_BUTTON_TEXT("Create an Account"),
    LOGIN_BLOCK_TITLE("Registered Customers"),
    FIELD_IS_REQUIRED("This is a required field."),
    EMAIL_VALIDATION_MESSAGE("Please enter a valid email address (Ex: johndoe@domain.com).");

    private final String value;

    ExpectedStrings(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
