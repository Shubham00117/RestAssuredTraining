package day6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
public class XMLSchemaValidation 
{
	
	@Test
	void xmlSchemaValidation()
	{
		given()
		
		.when()
		.get("https://mocktarget.apigee.net/xml")
		
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlSchemaValidation.xml"));
	}
}
