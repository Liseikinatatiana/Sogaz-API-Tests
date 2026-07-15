package tests;

import base.BaseApiTest;
import client.PolicyClient;
import dto.PolicyResponse;
import dto.PolicyRequest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.LoginDataProvider;

import static org.testng.Assert.*;


@Epic("СОГАЗ API")
@Feature("Поиск полиса")
public class PolicyApiTest extends BaseApiTest {

    @Test(dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class)
    @Story("Поиск существующего полиса")
    @Severity(SeverityLevel.CRITICAL)
    public void testFindPolicy(String email, String password) {
        String token = getToken(email, password);
        PolicyRequest request = PolicyRequest.builder()
                .policyNumber("123456789")
                .userId("user123")
                .build();
        PolicyResponse response = PolicyClient.searchPolicy(token, request)
                .as(PolicyResponse.class);

        assertTrue(response.isFound());
        assertNotNull(response.getPolicyNumber());
    }

    @Test(dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class)
    @Story("Поиск несуществующего полиса")
    @Severity(SeverityLevel.NORMAL)
    public void testFindNonExistentPolicy(String email, String password) {
        String token = getToken(email, password);
        PolicyRequest request = PolicyRequest.builder()
                .policyNumber("000000000")
                .userId("user123")
                .build();
        PolicyResponse response = PolicyClient.searchPolicy(token, request)
                .as(PolicyResponse.class);

        assertFalse(response.isFound());
        assertEquals(response.getMessage(), "Полис не найден");
    }
}
