package ru.samedov.polyathlonbackend.controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import ru.samedov.polyathlonbackend.domain.Sportsman;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SportsmanControllerTest {

    @Test
    public void testDeSerialization() {
        Sportsman sportsman = RestAssured.get("http://localhost:8080/api/sportsman/list/0").as(Sportsman.class);

        assertEquals("Alex", sportsman.getFirstName());
        assertEquals("Ivanov", sportsman.getLastName());
        assertEquals(2000, sportsman.getYearOfBirth());
    }

    @Test
    public void testSerialization() {
        Response response;

        Sportsman sportsman = new Sportsman("Alex", "Ivanov", 1999, 22);

        response = RestAssured.given()
                .contentType("application/json")
                .body(sportsman)
                .when()
                .post("http://localhost:8080/api/sportsman/add-sportsman");

        assertTrue(response.getBody().asString().contains("Alex"));
    }

}
