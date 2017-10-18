package basic;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetRequestDemo {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        RestAssured.basePath = "/maps/api";
    }

    @Test(enabled = false)
    public void statusCodeVerification() {
        given()
                .param("units", "imperial")
                .param("origins", "Washington,DC")
                .param("destinations", "New+York+City,NY")
                .param("key", "AIzaSyDOWQYlfBnlR76rGzkspK6UWdmxLZoWFb0")
                .when()
                .get("/distancematrix/json")
                .then()
                .statusCode(200);
    }
    @Test
    public void getResponeBody() {
        Response res =
                given()
                        .param("units", "imperial")
                        .param("origins", "Washington,DC")
                        .param("destinations", "New+York+City,NY")
                        .param("key", "AIzaSyDOWQYlfBnlR76rGzkspK6UWdmxLZoWFb0")
                        .when()
                        .get("/distancematrix/json");
        System.out.println(res.body().prettyPrint()); // System.out.printlin(res.body().asString());

    }
}
