package day6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation 

{
	@Test(priority = 1)
	void validateJsonSchema()
	{
		given()
		
		.when()
		.get("http://localhost:3000/students")
		
		.then()
		// Validate the API response body against the JSON schema file present in classpath (src/test/resources)
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchemaValidation.json"));
	}

}
