package api;

import dataProvider.ApiRequestBodies;
import dto.AddUserRequestDto;
import dto.UserResponseDto;
import dto.UserResponseWrapperDto;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.apiSteps.AddUserSteps;


/**
 * <h>API tests workflow</h>
 * <br>
 * <p>
 *      <ol>
 *          <li>
 *              The <code>addNewUserAndGetToken()</code> test use the method
 *              <code>apiRequestBodies.getAddUserRequestBody()</code> to receive the user data for request body.
 *          </li>
 *          <li>
 *              Then we pass this user data into the {@link AddUserSteps#createUser(AddUserRequestDto)} method and
 *              parse the response of the {@link AddUserSteps#createUser(AddUserRequestDto)} method to a variable
 *              {@link #addUserAndReceiveTokenResponseBody}.
 *          </li>
 *          <li>
 *              Inside the {@link AddUserSteps#createUser(AddUserRequestDto)} we rebuild the user data received from
 *              the <code>apiRequestBodies.getAddUserRequestBody()</code> method to the <code>AddUserRequestDto</code>
 *              data type and parse this object to {@link service.UserService#addUser(AddUserRequestDto)} method.
 *          </li>
 *          <li>
 *              The {@link service.UserService#addUser(AddUserRequestDto)} method serialize the
 *              <code>AddUserRequestDto</code> object to JSON format and performs the API request execution.
 *          </li>
 *          <li>
 *              The response body of the request is deserialized from JSON into <code>AddUserResponseWrapperDto</code>
 *              format and returned as a value of the {@link #addUserAndReceiveTokenResponseBody} variable in the
 *              ContactListApiTests.class.
 *          </li>
 *      </ol>
 *  </p>
 * <p>
 * <p>
 */

public class ContactListApiTests {

    private String user_token;
    private ApiRequestBodies apiRequestBodies = new ApiRequestBodies();
    private final AddUserSteps addUserSteps = new AddUserSteps();
    private UserResponseWrapperDto addUserAndReceiveTokenResponseBody;
    private AddUserRequestDto userDataForRequestBody = apiRequestBodies.getAddUserRequestBody();


    @Test(description = "Verify that the user can be added to the contact list and user token can be received")
    public void addNewUserAndGetToken() {

        addUserAndReceiveTokenResponseBody = addUserSteps.createUser(userDataForRequestBody);

        Assert.assertNotNull(addUserAndReceiveTokenResponseBody.getUser().getUserId());

        user_token = addUserAndReceiveTokenResponseBody.getToken();
    }

    @Test(description = "Verify that the user is existed in the database using the user token", dependsOnMethods = {"addNewUserAndGetToken"})
    @Parameters({"user_token"})
    public void getUserData() {
        UserResponseDto getUserResponse = addUserSteps.receiveUserData(user_token);
        Assert.assertEquals(getUserResponse.getUserId(), addUserAndReceiveTokenResponseBody.getUser().getUserId());
        Assert.assertEquals(getUserResponse.getFirstName(), addUserAndReceiveTokenResponseBody.getUser().getFirstName());
        Assert.assertEquals(getUserResponse.getLastName(), addUserAndReceiveTokenResponseBody.getUser().getLastName());
        Assert.assertEquals(getUserResponse.getEmail(), addUserAndReceiveTokenResponseBody.getUser().getEmail());
    }

    @Test(description = "Verify that the user can be logged in", dependsOnMethods = {"addNewUserAndGetToken"})
    @Parameters({"email", "password"})
    public void loginUser(){
        String email = userDataForRequestBody.getEmail();
        String password = userDataForRequestBody.getPassword();

        UserResponseWrapperDto loginUserResponse = addUserSteps.loginUser(email, password);

        Assert.assertEquals(loginUserResponse.getUser().getFirstName(), userDataForRequestBody.getFirstName());
        Assert.assertEquals(loginUserResponse.getUser().getEmail(), userDataForRequestBody.getEmail());

    }

    //TODO Add tests for update user password, test for login with old password, login with new password, user deletion

}
