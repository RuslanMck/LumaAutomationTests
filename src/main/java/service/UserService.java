package service;

import config.ApiConfig;
import dto.AddUserRequestDto;
import dto.AddUserResponseWrapperDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


/**
 * <p>
 *     <ul>
 *         <li>The {@link UserService#addUser(AddUserRequestDto)} method sends an HTTP POST request using RestAssured.</li>
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

    public AddUserResponseWrapperDto addUser (AddUserRequestDto requestDto){
        return RestAssured
                .given()
                .baseUri(ApiConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post(ADD_USER_ENDPOINT)
                .then()
                .statusCode(201)
                .extract()
                .as(AddUserResponseWrapperDto.class);
    }
}
