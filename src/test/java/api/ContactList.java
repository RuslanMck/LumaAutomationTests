package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dataProvider.ApiRequestBodies;
import dto.AddUserRequestDto;
import dto.AddUserResponseWrapperDto;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactList {

    public static final String BASE_URL = "https://thinking-tester-contact-list.herokuapp.com";
    private String user_token;
    private ApiRequestBodies apiRequestBodies = new ApiRequestBodies();
    private RequestSpecification requestSpecification;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeClass
    public void setup(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Test
    @SneakyThrows
    public void addUserAndGetToken(){

        AddUserRequestDto requestUserDto = apiRequestBodies.getAddUserRequestBody();

        String responseBody = RestAssured
                .given()
                .spec(requestSpecification)
                .body(objectMapper.writeValueAsString(requestUserDto))
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .body()
                .asString();

        AddUserResponseWrapperDto responseDto = objectMapper.readValue(responseBody, AddUserResponseWrapperDto.class);

        Assertions
                .assertThat(responseDto.getUser())
                .usingRecursiveComparison()
                .ignoringFields("_id", "token")
                .isEqualTo(requestUserDto);

        Assert.assertNotNull(responseDto.getToken(), "Token should not be null");
        Assert.assertFalse(responseDto.getToken().isEmpty(), "Token should not be empty");

        user_token = responseDto.getToken();

    }
}
