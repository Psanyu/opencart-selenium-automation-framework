package APItesting;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class APIt03CreateSalesOrder {

    @Test
    public void verifyCreateSalesOrderApi() {

        Response loginResponse = given()
                .baseUri("http://localhost:8000")
                .contentType("application/x-www-form-urlencoded")
                .formParam("usr", "Administrator")
                .formParam("pwd", "admin")
        .when()
                .post("/api/method/login");

        String sessionId = loginResponse.getCookie("sid");

        System.out.println("Login Status Code: " + loginResponse.statusCode());
        System.out.println("Session ID: " + sessionId);

        String payload = """
                {
                  "data": {
                    "customer": "Grant Plastics Ltd.",
                    "company": "XXXX (Demo)",
                    "transaction_date": "2026-04-23",
                    "delivery_date": "2026-04-25",
                    "items": [
                      {
                        "item_code": "SKU001",
                        "qty": 1,
                        "rate": 500,
                        "warehouse": "Stores - XD",
                        "delivery_date": "2026-04-25"
                      }
                    ]
                  }
                }
                """;

        Response salesOrderResponse = given()
                .baseUri("http://localhost:8000")
                .cookie("sid", sessionId)
                .contentType("application/json")
                .body(payload)
        .when()
                .post("/api/resource/Sales Order");

        System.out.println("Sales Order Status Code: " + salesOrderResponse.statusCode());
        System.out.println("Sales Order Response Body:");
        System.out.println(salesOrderResponse.asPrettyString());

        salesOrderResponse.then()
                .statusCode(200)
                .body("data.name", notNullValue())
                .body("data.customer", equalTo("Grant Plastics Ltd."));

        String orderId = salesOrderResponse.jsonPath().getString("data.name");
        System.out.println("Created Order: " + orderId);

        given()
                .baseUri("http://localhost:8000")
                .cookie("sid", sessionId)
        .when()
                .get("/api/resource/Sales Order/" + orderId)
        .then()
                .statusCode(200)
                .body("data.name", equalTo(orderId))
                .body("data.customer", equalTo("Grant Plastics Ltd."));
    }
}
