package service;

import config.ApiConfig;
import dto.AddUserRequestDto;
import dto.AddUserResponseDto;
import dto.AddUserResponseWrapperDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserService {

    private static final String ADD_USER_ENDPOINT = "/users";

    public AddUserResponseWrapperDto addUser (AddUserRequestDto responseDto){
        return RestAssured
                .given()
                .baseUri(ApiConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .body(responseDto)
                .when()
                .post(ADD_USER_ENDPOINT)
                .then()
                .statusCode(201)
                .extract()
                .as(AddUserResponseWrapperDto.class);
    }
}
