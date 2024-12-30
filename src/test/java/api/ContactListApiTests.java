package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.ApiConfig;
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
import steps.api.AddUserSteps;

public class ContactListApiTests {

    private String baseUrl = ApiConfig.BASE_URL;
    private String user_token;
    private ApiRequestBodies apiRequestBodies = new ApiRequestBodies();
    private RequestSpecification requestSpecification;
    private ObjectMapper objectMapper = new ObjectMapper();
    private final AddUserSteps addUserSteps = new AddUserSteps();

    @BeforeClass
    public void setup(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Test
    public void addNewUserAndGetToken(){
        AddUserResponseWrapperDto response = addUserSteps.createUser(apiRequestBodies.getAddUserRequestBody());

        Assert.assertNotNull(response.getUser().getUserId());

        user_token = response.getToken();

        System.out.println("Response body: ");
        System.out.println(response);
        System.out.println("User token = " + user_token);
        System.out.println("User first name = " + response.getUser().getFirstName());
        System.out.println("User last name = " + response.getUser().getLastName());
        System.out.println("User email = " + response.getUser().getEmail());
        System.out.println("User id = " + response.getUser().getUserId());
    }


//    @Test
//    @SneakyThrows
//    public void addUserAndGetToken(){
//
//        AddUserRequestDto requestUserDto = apiRequestBodies.getAddUserRequestBody();
//
//        String responseBody = RestAssured
//                .given()
//                .spec(requestSpecification)
//                .body(objectMapper.writeValueAsString(requestUserDto))
//                .when()
//                .post("/users")
//                .then()
//                .statusCode(201)
//                .extract()
//                .body()
//                .asString();
//
//        AddUserResponseWrapperDto responseDto = objectMapper.readValue(responseBody, AddUserResponseWrapperDto.class);
//
//        Assertions
//                .assertThat(responseDto.getUser())
//                .usingRecursiveComparison()
//                .ignoringFields("_id", "token")
//                .isEqualTo(requestUserDto);
//
//        Assert.assertNotNull(responseDto.getToken(), "Token should not be null");
//        Assert.assertFalse(responseDto.getToken().isEmpty(), "Token should not be empty");
//
//        user_token = responseDto.getToken();
//
//    }
}
