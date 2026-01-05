package day8;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	void testUpdateUser(ITestContext context) {
		
//		String id=(String) context.getAttribute("user_id");//this comes form create user request and test level
		String id=(String) context.getSuite().getAttribute("user_id");//this comes form create user request and suite level
		Faker faker = new Faker();

		JSONObject data = new JSONObject();

		data.put("name", faker.name().fullName());
		data.put("email", faker.internet().safeEmailAddress());
		data.put("course", faker.educator().course());
		
		given()
		.contentType("application/json")
		.pathParam("id", id)
		.body(data.toString())
		
		
		.when()
		.put("http://localhost:3000/students/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		System.out.println("Update User");
		
		
	}

}
