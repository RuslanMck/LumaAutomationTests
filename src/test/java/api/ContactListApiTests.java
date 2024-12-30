package api;

import dataProvider.ApiRequestBodies;
import dto.AddUserRequestDto;
import dto.AddUserResponseWrapperDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.api.AddUserSteps;

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
    private AddUserResponseWrapperDto addUserAndReceiveTokenResponseBody;

    @Test(description = "Verify that the user can be added to the contact list and user token can be received")
    public void addNewUserAndGetToken() {
        AddUserRequestDto userDataForRequestBody = apiRequestBodies.getAddUserRequestBody();

        addUserAndReceiveTokenResponseBody = addUserSteps.createUser(userDataForRequestBody);

        Assert.assertNotNull(addUserAndReceiveTokenResponseBody.getUser().getUserId());

        user_token = addUserAndReceiveTokenResponseBody.getToken();

        System.out.println("Response body: ");
        System.out.println(addUserAndReceiveTokenResponseBody);
        System.out.println("User token = " + user_token);
        System.out.println("User first name = " + addUserAndReceiveTokenResponseBody.getUser().getFirstName());
        System.out.println("User last name = " + addUserAndReceiveTokenResponseBody.getUser().getLastName());
        System.out.println("User email = " + addUserAndReceiveTokenResponseBody.getUser().getEmail());
        System.out.println("User id = " + addUserAndReceiveTokenResponseBody.getUser().getUserId());
    }
}
