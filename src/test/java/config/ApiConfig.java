package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

public class ApiConfig {
    public static final String BASE_URL = "https://api.sogaz.ru";
    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    public static RequestSpecification getAuthRequestSpec(String token) {
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .setAccept("application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}
