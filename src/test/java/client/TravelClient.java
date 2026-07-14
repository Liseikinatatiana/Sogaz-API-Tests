package client;

import config.ApiConfig;
import dto.TravelRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TravelClient {
    public static Response calculateTravel(TravelRequest request) {
        return given()
                .spec(ApiConfig.getRequestSpec())
                .body(request)
                .when()
                .post("/travel/calculate")
                .then()
                .extract()
                .response();
    }

    public static double getPremium(String country, int age) {
        TravelRequest request = TravelRequest.builder()
                .country(country)
                .age(age)
                .build();
        return calculateTravel(request).path("premium");
    }
}
