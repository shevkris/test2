import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v134.fetch.model.AuthChallengeResponse;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstRestAssuredTest {
    @Test
    public void testGetUser() {
        given().
                baseUri("https://reqres.in").
        when().
                get("api/users/3").
        then().assertThat().
                statusCode(200).body("data.id", Matchers.equalTo(3)).body("data.first_name", Matchers.equalTo("Emma"));

    }
   @Test
    public void testGetUser2() {
        given().
                when().
                get("https://reqres.in/api/users/3").
                then().
                statusCode(200).body("data.id", Matchers.equalTo(3)).body("data.first_name", Matchers.equalTo("Emma"));

    }

    @Test
    public void createUser() {
        String requestBody = "{\"username\":\"Kris\",\"email\":\"kris@test.com\", \"password\":\"qwerty12345\"}";
        given()
                .body(requestBody)
        .when()
                .post("https://reqres.in/api/register")
        .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("token", notNullValue());
    }
}
