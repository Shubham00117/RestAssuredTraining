package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class HeadersDemo 
{
	@Test
	void testHeaders()
	{
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws")
//		.log().all();
		.log().headers();//only prints headers
	}

}
