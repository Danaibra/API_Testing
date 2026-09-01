package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class UsersApiTest extends BaseTest {
    private static final String USERS_ENDPOINT = "/users";

    @Test
    @DisplayName("checking the status 200 ok")
    public void testStatusCode200(){
        given().when().get(USERS_ENDPOINT).then().statusCode(200);
    }

    @Test
    @DisplayName("checking content type header")
    public void testContentTypeHeader(){
        given().when().get(USERS_ENDPOINT).then().header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    @DisplayName("checking response body: an array of 10 users")
    public void testResponseBodyUserCount(){
        given().when().get(USERS_ENDPOINT).then().body("$", hasSize(10));
    }
}
