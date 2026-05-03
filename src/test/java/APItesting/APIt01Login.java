package APItesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
//import static org.hamcrest.Matchers.equalTo;

public class APIt01Login {
	@Test
    public void verifyLoginApi() {

        Response response = given()
                .baseUri("http://localhost:8000")
                .contentType("application/x-www-form-urlencoded")
                .formParam("usr", "Administrator")
                .formParam("pwd", "admin")
        .when()
                .post("/api/method/login");

        response.then().statusCode(200);

        String sessionId = response.getCookie("sid");

        System.out.println("Session ID: " + sessionId);
    }
}
