import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v134.fetch.model.AuthChallengeResponse;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstRestAssuredTest {
    @Test
    public void getUL() {
        given()
                .param("tin","4221020838")
                .header("Authorization", "eyJraWQiOiJkZmU2Zjk5Mi05ZDRiLTRiMTktOTAyNC04OWU2MTc0NmE2NjQiLCJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ2dGI0MTEyOTA4QHRlc3QudnRiLnJ1IiwibmFtZSI6IkpvaG4gRG9lIiwiY2hhbm5lbCI6ImludGVybmFsIiwic2NvcGUiOiJFQ01fVVNFUiIsImlhdCI6MTUxNjIzOTAyMiwiZXhwIjoxNjE3MDEwODU0LCJpc3MiOiJPQUMiLCJqdGkiOiI5Mjk4ZDNlNy03YWVkLTQyNjMtOTY4Yy02ZTgzNjlkOGY1ZTUifQ.7juOYAwlLWcAMn8rjLQ8JW19vAvOUsX8LOlVX-VCtEQ").
        when().
                get("https://if-vzss.test.vtb.ru/vzss/api-gateway/api/v1/89bd8ba5-5026-429e-bdf1-64ebd087525f/legal-entity").
        then().
                statusCode(200);

    }

    @Test
    public void checkGetRequest() {
        given()
                .spec(Specifications.requestSpecification()).
                when()
                .get("/api/users/3").
                then()
                .spec(Specifications.responseSpecificationScOk())
                .assertThat()
                .body("data.id", Matchers.equalTo(3))
                .body("data.first_name", Matchers.equalTo("Emma"));

    }

    @Test
    public void checkPostRequest(){
        given()
                .spec(Specifications.requestSpecification())
                .body(new UserDTO("kris", "test@mqil.com","qwerty12345")).
        when()
                .post("/api/register").
                then()
                .statusCode(201)
                .assertThat()
                .body("id", notNullValue())
                .body("token", notNullValue());

    }
}

