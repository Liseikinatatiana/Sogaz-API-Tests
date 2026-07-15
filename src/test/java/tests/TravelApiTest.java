package tests;

import base.BaseApiTest;
import client.TravelClient;
import dto.TravelRequest;
import dto.TravelResponse;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Epic("СОГАЗ API")
@Feature("Страхование путешествий")
public class TravelApiTest extends BaseApiTest {

    @Test
    @Story("Расчёт страховки для Турции")
    @Severity(SeverityLevel.NORMAL)
    public void testTravelInsuranceTurkey() {
        TravelRequest request = TravelRequest.builder()
                .country("ТУРЦИЯ")
                .age(40)
                .build();

        TravelResponse response = TravelClient.calculateTravel(request)
                .as(TravelResponse.class);

        assertTrue(response.isSuccess());
        assertTrue(response.getPremium() > 0);
        assertNotNull(response.getInsuranceUrl());
    }

    @Test
    @Story("Расчёт страховки для Китая")
    @Severity(SeverityLevel.NORMAL)
    public void testTravelInsuranceChina() {
        TravelRequest request = TravelRequest.builder()
                .country("КИТАЙ")
                .age(25)
                .build();

        TravelResponse response = TravelClient.calculateTravel(request)
                .as(TravelResponse.class);

        assertTrue(response.isSuccess());
        assertTrue(response.getPremium() > 0);
    }
}
