package base;

import client.AuthClient;
import config.ApiConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {
    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = ApiConfig.BASE_URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public String getToken(String email, String password) {
        return AuthClient.getToken(email, password);
    }
}
