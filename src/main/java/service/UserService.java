package service;

import config.ApiConfig;
import dto.AddUserRequestDto;
import dto.LoginUserRequestDto;
import dto.UserResponseDto;
import dto.UserResponseWrapperDto;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


/**
 * <p>
 *     <ul>
 *         <li>The {@link #addUser(AddUserRequestDto)} method sends an HTTP POST request using RestAssured.</li>
 *         <li>RestAssured handles the serialization of the request body (AddUserRequestDto) into JSON and
 *         deserialization of the API response into a Java object.</li>
 *         <li>The <code>.as(AddUserResponseWrapperDto.class)</code> method at the end of the API request extracts
 *         the API response and converts (deserializes) it into an object of type <code>AddUserResponseWrapperDto</code>.</li>
 *         <li>After deserialization, the <code>addUser()</code> method directly returns the deserialized
 *         <code>AddUserResponseWrapperDto</code> object to the caller (<code>AddUserSteps.class</code>).</li>
 *     </ul>
 * </p>
 */
public class UserService {


    private static final String ADD_USER_ENDPOINT = "/users";
    private static final String GET_USER_ENDPOINT = "/users/me";
    private static final String LOGIN_USER_ENDPOINT = "/users/login";

    private final static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(ApiConfig.BASE_URL)
            .addHeader("Content-Type", "application/json")
            .build()
            .filter(new AllureRestAssured());

    public UserResponseWrapperDto addUser(AddUserRequestDto requestDto) {
        return RestAssured
                .given()
                .spec(requestSpecification)
                .body(requestDto)
                .when()
                .post(ADD_USER_ENDPOINT)
                .then()
                .statusCode(201)
                .extract()
                .as(UserResponseWrapperDto.class);
    }

    public UserResponseDto getUser(String token) {
        return RestAssured
                .given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(GET_USER_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .as(UserResponseDto.class);
    }

    public UserResponseWrapperDto loginUser(LoginUserRequestDto loginUserRequestDto){
        return RestAssured
                .given()
                .spec(requestSpecification)
                .body(loginUserRequestDto)
                .when()
                .post(LOGIN_USER_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .as(UserResponseWrapperDto.class);
    }


}
