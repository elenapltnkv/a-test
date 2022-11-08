package test_cases;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class BaseTest {

    static Properties properties= new Properties();
    static RequestSpecification requestSpecification;
    static ResponseSpecification positiveResponseSpecification;
    static ResponseSpecification negativeResponseSpecification;
    static String host;
    //static String XDataHash;

    @BeforeAll
    static void beforeAll() throws IOException {
        requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .addHeader("X-Data-Application-Id", "1")
                .addHeader("X-Data-Hash", "fd72b07e5574a98f98d64adef7826693f9cc821bd85eab7ac0f0f3e34512221e6c0ebe3c1281edd2c2052be181d7073fa9659259ed96d3dccc216abe54cb40a6")
                .build();
        positiveResponseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
        negativeResponseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();


        properties = new Properties();
        properties.load(Files.newInputStream(Path.of("src/test/application.properties")));
        host=properties.getProperty("host");

        RestAssured.baseURI = host;
        RestAssured.filters(new AllureRestAssured());
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification =positiveResponseSpecification;
        RestAssured.responseSpecification = negativeResponseSpecification;
        //RestAssured.responseSpecification = positiveResponseSpecification;

    }
}
