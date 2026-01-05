package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathAndQueryParamters 
{
	
	@Test(priority = 1)
	void testQueryAndPathParameter()
	{
		given()
		.pathParam("mypath","students")
		.queryParam("id", "")
		
		
		.when()
		.get("http://localhost:3000/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
