package client;

import config.ApiConfig;
import dto.AuthRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthClient {
    public static Response login(AuthRequest request) {
        return given()
                .spec(ApiConfig.getRequestSpec())
                .body(request)
                .when()
                .post("/auth/login")
                .then()
                .extract()
                .response();
    }

    public static String getToken(String email, String password) {
        AuthRequest request = AuthRequest.builder()
                .email(email)
                .password(password)
                .build();
        return login(request).path("token");
    }

    public static boolean isLoginSuccessful(String email, String password) {
        AuthRequest request = AuthRequest.builder()
                .email(email)
                .password(password)
                .build();
        return login(request).path("success");
    }
}
