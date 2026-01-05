package day2;


// Used to send HTTP requests (GET, POST, PUT, DELETE) and control request flow
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.HashMap;

import org.testng.annotations.Test;

/*
 
given()
content type, set cookies, add auth, add param, set headers info etc....

when()
get, post, put, delete

then()
validate status code, extract response, extract headers cookies & response body....

given() → setup
when()  → action
then()  → validation

*/



public class HTTPRequests {
	
	String id;
	String URL="http://localhost:3000/students/";
	
	@Test(priority = 1)
	void getUsers() {
//		given()

		when().get(URL)

				.then().statusCode(200).log().all();

	}
	
	@Test(priority = 2)
	void createUser()
	{
		HashMap<String, String> data= new HashMap<>();
		data.put("name", "xyz");
		data.put("email", "xyz@gmail.com");
		data.put("course", ".Net");
		
		
		
	id=	given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post(URL)
//		.jsonPath().getInt("id");// Integer id captured
		
		.then()
	    .statusCode(201)
	    .log().all()
	    .extract().path("id");   // <-- String id captured		
	}
	
	@Test(priority = 3)
	void updateUser()
	{
		HashMap<String, String> data= new HashMap<>();
		data.put("name", "xyza");
		data.put("email", "xyez@gmail.com");
		data.put("course", ".dNet");
		
		
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.put(URL+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(priority = 4)
	void deleteUser()
	{
		
		when()
		.delete(URL+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	

}
