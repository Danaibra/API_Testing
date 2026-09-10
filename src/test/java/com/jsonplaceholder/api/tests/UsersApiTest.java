package com.jsonplaceholder.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@Execution(ExecutionMode.CONCURRENT)
public class UsersApiTest extends BaseTest {
    private static final String USERS_ENDPOINT = "/users";
    private static final int EXPECTED_STATUS_CODE = 200;
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String EXPECTED_CONTENT_TYPE = "application/json; charset=utf-8";
    private static final int EXPECTED_USERS_COUNT = 10;

    @Test
    @DisplayName("GET /users response should return status code 200 OK")
    public void testStatusCode200(){
        given().when().get(USERS_ENDPOINT).then().statusCode(EXPECTED_STATUS_CODE);
    }

    @Test
    @DisplayName("GET /users response should include application/json Content-Type header")
    public void testContentTypeHeader(){
        given().when().get(USERS_ENDPOINT).then().header("Content-Type", equalTo(EXPECTED_CONTENT_TYPE));
    }

    @Test
    @DisplayName("GET /users response should contain an array of 10 users")
    public void testResponseBodyUserCount(){
        given().when().get(USERS_ENDPOINT).then().body("$", hasSize(EXPECTED_USERS_COUNT));
    }
}