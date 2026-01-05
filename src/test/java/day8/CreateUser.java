package day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class CreateUser 
{
	
	@Test()
	void testcreateUser(ITestContext context)
	{
		Faker faker= new Faker();
		
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("email", faker.internet().safeEmailAddress());
		data.put("course", faker.educator().course());
		
	String id=	given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
//		.jsonPath().getInt("id");// Integer id captured
		
		.then()
		.extract().path("id");   // <-- String id captured		
		
		
		System.out.println("Id is:"+id);
//		context.setAttribute("user_id",id);//available for test level
		context.getSuite().setAttribute("user_id",id);//available for suit level
		
		System.out.println("User Crated");
		
		
		
		
		
		
		
	}

}
