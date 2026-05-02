package APItesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
//import static org.hamcrest.Matchers.equalTo;

public class APIt02GetItems {
	 @Test
	    public void verifyGetItemsApi() {

	        // 🔹 Step 1: Login and capture session
	        Response loginResponse = given()
	                .baseUri("http://localhost:8000")
	                .contentType("application/x-www-form-urlencoded")
	                .formParam("usr", "Administrator")
	                .formParam("pwd", "admin")
	        .when()
	                .post("/api/method/login");

	        String sessionId = loginResponse.getCookie("sid");

	        System.out.println("Session ID: " + sessionId);

	        // 🔹 Step 2: Use session to call GET Items API
	        Response itemResponse = given()
	                .baseUri("http://localhost:8000")
	                .cookie("sid", sessionId)
	        .when()
	                .get("/api/resource/Item");

	        // 🔹 Step 3: Validate response
	        itemResponse.then().statusCode(200);

	        System.out.println(itemResponse.asPrettyString());
	    }
}