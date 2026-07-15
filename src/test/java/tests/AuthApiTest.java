package tests;

import base.BaseApiTest;
import client.AuthClient;
import dto.AuthRequest;
import dto.AuthResponse;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.LoginDataProvider;

import static org.testng.Assert.*;

@Epic("СОГАЗ API")
@Feature("Авторизация")
public class AuthApiTest extends BaseApiTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    @Story("Проверка сценариев логина")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginScenarios(String email, String password, String expectedResult, String expectedMessage) {
        AuthRequest request = AuthRequest.builder()
                .email(email)
                .password(password)
                .build();

        AuthResponse response = AuthClient.login(request)
                .as(AuthResponse.class);

        if (expectedResult.equals("success")) {
            assertTrue(response.isSuccess());
            assertNotNull(response.getToken());
        } else {
            assertFalse(response.isSuccess());
            assertNull(response.getToken());
        }
    }
}
