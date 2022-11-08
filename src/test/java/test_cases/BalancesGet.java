package test_cases;


import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BalancesGet extends BaseTest{
ResponseSpecification positiveStatusCode;
ResponseSpecification negativeStatusCode;
     @Test
    void getPingPositiveTest(){
         positiveStatusCode = positiveResponseSpecification
            .expect().body("success", equalTo(true));
        given()
                .baseUri(host)
                .log()
                .all()
                .body("{\n" +
                        "    \"service_id\": 500,\n" +
                        "    \"method\": \"balances.get\",\n" +
                        "    \"params\": {}\n" +
                        "}")
                .when()
                .post("")
                .prettyPeek()
                .then();

    }
    @Test
    void getPingNegativeTest(){
         negativeStatusCode = negativeResponseSpecification;

        given()
                .baseUri(host)
                .log()
                .all()
                .body("{\n" +
                        "    \"service_id\": 501,\n" +
                        "    \"method\": \"balances.get\",\n" +
                        "    \"params\": {}\n" +
                        "}")
                .when()
                .post("")
                .prettyPeek()
                .then();
    }

}
