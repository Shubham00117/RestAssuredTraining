package day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test()
	void testGetUser(ITestContext context)
	{
//		String id=(String) context.getAttribute("user_id");//this comes form create user request and test level
		String id=(String) context.getSuite().getAttribute("user_id");//this comes form create user request and suite level
		given()
		.pathParam("id",id)
		.when()
		.get("http://localhost:3000/students/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		System.out.println("Get User");
		
	}

}
