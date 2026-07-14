package client;

import config.ApiConfig;
import dto.PolicyRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PolicyClient {
    public static Response searchPolicy(String token, PolicyRequest request) {
        return given()
                .spec(ApiConfig.getAuthRequestSpec(token))
                .body(request)
                .when()
                .post("/policy/search")
                .then()
                .extract()
                .response();
    }

    public static boolean isPolicyFound(String token, String policyNumber, String userId) {
        PolicyRequest request = PolicyRequest.builder()
                .policyNumber(policyNumber)
                .userId(userId)
                .build();
        return searchPolicy(token, request).path("found");
    }
}
