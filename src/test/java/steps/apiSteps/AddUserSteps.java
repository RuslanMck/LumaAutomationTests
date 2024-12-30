package steps.apiSteps;

import dto.AddUserRequestDto;
import dto.LoginUserRequestDto;
import dto.UserResponseDto;
import dto.UserResponseWrapperDto;
import io.qameta.allure.Step;
import service.UserService;

public class AddUserSteps {
    private final UserService userService = new UserService();

    /**
     * <p>Using the <code>.builder()</code> method create an object of <code>AddUserRequestDto</code>.
     * This object contains the data that will be sent as the request body for the API call in the
     * <code>return userService.addUser(requestDto)</code></p>
     * <br>
     * <p>The <code>.builder()</code> allows to set each field of the object individually.</p>
     * <p>The <code>.build()</code> method creates an instance of the <code>AddUserRequestDto</code> class using the
     * values set in the builder.</p>
     *
     * <p><b>Note:</b></p>
     * <p>The <code>createUser()</code> method rebuilds the <code>userRequestDto</code> object from the
     * <code>AddUserRequestDto</code> to the same <code>AddUserRequestDto</code> data type.<p/>
     * <br>
     * <p>The reasons of this implementation are
     * <ul>
     *     <li>The <code>createUser()</code> method currently acts as a middle layer between the test
     *     (addNewUserAndGetToken) and the service layer (UserService.addUser()).</li>
     *     <li>The user data for the request body (firstName, lastName etc.) received from the
     *     <code>ApiRequestBodies.getAddUserRequestBody()</code></li>
     *     <li>If we replace <code>ApiRequestBodies.getAddUserRequestBody()</code> with a JSON file or another
     *     data source, the <code>createUser()</code> method can adapt the new input format into
     *     the expected AddUserRequestDto.</li>
     * </ul>
     *  </p>
     *
     * @param userRequestDto
     * @return
     */
    @Step("Add user to the contact list and receive token")
    public UserResponseWrapperDto createUser(AddUserRequestDto userRequestDto) {

        AddUserRequestDto requestDto = AddUserRequestDto.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .build();

        return userService.addUser(requestDto);
    }

    @Step("Receive user data using token")
    public UserResponseDto receiveUserData(String token) {
        return userService.getUser(token);
    }

    @Step("Login user")
    public UserResponseWrapperDto loginUser(String email, String password){

        LoginUserRequestDto requestDto = LoginUserRequestDto
                .builder()
                .email(email)
                .password(password)
                .build();

        return userService.loginUser(requestDto);
    }

}
