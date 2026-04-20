package api_testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_CustomForms {
	
	@Test 

	public void CustomForms() {
		String Token = "BzDJbRo4JDj24K1Iho3QkRi4tS+HqbQ4oHmXmGBdKwc+im3Wppt/OuuhOseABTTTYp2Ma4uiMXZCbtKYTfKg0w==";
		RestAssured.baseURI ="https://rf2-api.tst-34.aws.agilent.com";
		
		Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + Token)
                .header("Content-Type", "application/json")
                .when()
                .get("/v1/cores/22/service_requests/67598/custom_forms");
		
		System.out.println("Status Code: " + response.getStatusCode());
        response.prettyPrint();

	}

}
