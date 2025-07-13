import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.hc.core5.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Specifications {

    public static RequestSpecification requestSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setRelaxedHTTPSValidation()
                .setContentType(JSON)
                .setAccept(JSON)
                .build();
    }
    public static ResponseSpecification responseSpecificationScOk() {
        return new ResponseSpecBuilder()
                .log(LogDetail.STATUS)
                .expectContentType(JSON)
                .expectStatusCode(HttpStatus.SC_OK)
                .expectResponseTime(lessThanOrEqualTo(5L), SECONDS)
                .build();
    }
}
