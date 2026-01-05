package day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import day2.PojoPostRequest;

/*
   Different ways to create POST request body
1) Post request body using Hashmap
2) Post request body creation using using Org.JSON
3) Post request body creation using POJO class
4) Post request using external json file data
*/

// Json Data Type
//{
//    "name": "xyza",
//    "course": ".dNet",
//    "email": "xyez@gmail.com",
//    "id": "22e9"
//}
public class DiffWaysToCreatePostRequestBody 
{
	
	String id;
	
	//post body request using HashMap
//	@Test(priority = 1)
	void testPostUsingHashMap() 
	{
		HashMap<String, String> data=new HashMap<String, String>();
		data.put("name", "Scott");
		data.put("course", "Java");
		data.put("email", "abc@gmail.com");
		
//		String arrtype[]= {"C#","C++"}; post request of array
//		data.put("courses", arrtype);
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("course", equalTo("Java"))
		.body("email",equalTo("abc@gmail.com"))
		.header("Content-Type", "application/json")
		.extract().path("id"); // String id captured
		
		
	}
	
//	Post request body creation using using Org.JSON
//	@Test(priority = 2)
	void testPostUsingJsonLibrary() 
	{
		JSONObject data=new JSONObject();
		data.put("name", "Scott");
		data.put("course", "Java");
		data.put("email", "abc@gmail.com");
		
		id=given()
		.contentType("application/json")
		.body(data.toString())//👉 Always convert JSONObject to String
		
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("course", equalTo("Java"))
		.body("email",equalTo("abc@gmail.com"))
		.header("Content-Type", "application/json")
		.extract().path("id"); // String id captured
		
		
	}
	
	
//	Post request body creation using POJO class
//	@Test(priority = 3)
	void testPostUsingPojoClass() 
	{
		PojoPostRequest data= new PojoPostRequest();
		data.setName("Scott");
		data.setCourse("RestAssured");
		data.setEmail("abc@gmail.com");
		
		
		id=given()
				.contentType("application/json")
				.body(data)
				
				
				.when()
				.post("http://localhost:3000/students")
				
				.then()
				.statusCode(201)
				.body("name",equalTo("Scott"))
				.body("course", equalTo("RestAssured"))
				.body("email",equalTo("abc@gmail.com"))
				.header("Content-Type", "application/json")
				.extract().path("id"); // String id captured
		
	}
	
//	Post request using external json file data
	@Test(priority = 4)
	void testPostUsingExternalJSON() throws FileNotFoundException 
	{
		
		File f = new File("/Users/shubham_infinity/Desktop/test1/RestAssuredTraining/body.json");// Creates a File object pointing to the JSON file (request body) from the project directory
		FileReader fr = new FileReader(f);// Reads the content of the JSON file character by character
		JSONTokener jt = new JSONTokener(fr);// Parses the JSON text read from the file into token
		JSONObject data = new JSONObject(jt);// Converts the parsed JSON tokens into a JSONObject that can be used as a request body
		
		
		id=given()
				.contentType("application/json")
				.body(data.toString())//👉 Always convert JSONObject to String
				
				
				.when()
				.post("http://localhost:3000/students")
				
				.then()
				.statusCode(201)
				.body("name",equalTo("Scott"))
				.body("course", equalTo("RestAssured"))
				.body("email",equalTo("abc@gmail.com"))
				.header("Content-Type", "application/json")
				.extract().path("id"); // String id captured
		
	}

	
	
	
	//deleting student record
	@Test(priority = 5)
	void testDeleteRequest()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/students/"+id)
		
		.then()
		.statusCode(200);
		
		
	}
	

}
