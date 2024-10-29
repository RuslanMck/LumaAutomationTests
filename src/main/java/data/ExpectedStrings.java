package data;

import lombok.Getter;

@Getter
public enum ExpectedStrings {
    LOGIN_PAGE_TITLE("Customer Login"),
    REGISTRATION_BLOCK_TITLE("New Customers"),
    REGISTRATION_BUTTON_TEXT("Create an Account"),
    REGISTRATION_CONFIRMATION_MESSAGE("Thank you for registering with Main Website Store."),
    LOGIN_BLOCK_TITLE("Registered Customers"),
    HEADER_WELCOME_MESSAGE("Welcome,"),
    FIELD_IS_REQUIRED("This is a required field."),
    ORDER_CONFIRMATION_PAGE_TITLE("Thank you for your purchase!"),
    EMAIL_VALIDATION_MESSAGE("Please enter a valid email address (Ex: johndoe@domain.com).");


    private final String value;

    ExpectedStrings(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
