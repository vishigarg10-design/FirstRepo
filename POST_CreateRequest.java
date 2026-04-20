package api_testing;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class POST_CreateRequest {

	@Test 
	
	public void  CreateRequert() {
	


		String Token = "BzDJbRo4JDj24K1Iho3QkRi4tS+HqbQ4oHmXmGBdKwc+im3Wppt/OuuhOseABTTTYp2Ma4uiMXZCbtKYTfKg0w==";
		RestAssured.baseURI ="https://rf2-api.tst-34.aws.agilent.com";
		
		String requestBody = "{\n" +
                "  \"service_request\": {\n" +
                "    \"owner_email\": \"admin@ilabx.com\",\n" +
                "    \"state\": \"completed\"\n" +
                "  }\n" +
                "}";

        Response response =
                given()
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + Token)
                    
                    .body(requestBody)
                .when()
                    .post("/v1/cores/22/service_requests") // replace endpoint
                .then()
                    .statusCode(200)  // change if API returns 201
                    .log().all()
                    .extract().response();

        System.out.println("Response: " + response.asString());
        response.prettyPrint();
		
	}

}
