package APItesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
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

        String payload = """
                {
                  "data": {
                    "customer": "OpenCart Test Customer",
                    "transaction_date": "2026-04-23",
                    "delivery_date": "2026-04-25",
                    "items": [
                      {
                        "item_code": "MacBook-Test",
                        "qty": 1,
                        "rate": 500
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

        salesOrderResponse.then()
        .statusCode(200)
        .body("data.name", notNullValue())
        .body("data.customer", notNullValue());

        System.out.println(salesOrderResponse.asPrettyString());
    }
}