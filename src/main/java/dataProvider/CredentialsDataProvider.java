package dataProvider;

import helpers.EmailIncrementHelper;
import org.testng.annotations.DataProvider;

public class CredentialsDataProvider {
    private final String INVALID_EMAIL = "test.email.com";
    private final String INVALID_PASSWORD = "1";
    private final String INVALID_FIRSTNAME = "1";
    private final String INVALID_LASTNAME = "1";
    private final String VALID_FIRSTNAME = "Kalzedd";
    private final String VALID_LASTNAME = "Earthhammer";
    private final String VALID_LOGIN_EMAIL = "uthertester@gmail.com";
    private int emailAddressIncrement = EmailIncrementHelper.readEmailIncrement();
    private String validRegistrationEmail = "uthertester+luma" + emailAddressIncrement + "@gmail.com";
    private final String VALID_PASSWORD = "passWORD1!";


    @DataProvider(name = "registrationInvalidData")
    public Object[][] registrationInvalidData() {
        return new Object[][]{{INVALID_EMAIL, INVALID_PASSWORD, INVALID_FIRSTNAME, INVALID_LASTNAME}};
    }

    @DataProvider(name = "registrationValidData")
    public Object[][] registrationValidData() {
        emailAddressIncrement++;
        EmailIncrementHelper.writeEmailIncrement(emailAddressIncrement);
        return new Object[][]{{VALID_FIRSTNAME, VALID_LASTNAME, validRegistrationEmail, VALID_PASSWORD}};
    }

    @DataProvider(name = "loginInvalidData")
    public Object[][] loginInvalidData() {
        return new Object[][]{{INVALID_EMAIL, INVALID_PASSWORD}};
    }

    @DataProvider(name = "loginValidData")
    public Object[][] loginValidData(){
        return new Object[][]{{VALID_LOGIN_EMAIL, VALID_PASSWORD, VALID_FIRSTNAME, VALID_LASTNAME}};
    }

}
