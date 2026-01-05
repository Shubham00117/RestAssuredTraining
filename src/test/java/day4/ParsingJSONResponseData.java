package day4;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponseData {

    @Test(priority = 1)
    void testResponseData() {
    	
    	//Approach 1

//        given()
//            .contentType(ContentType.JSON)//contentType tells what type of data is being sent or received (JSON, XML, etc.) 
//            							 //so the server and client can understand each other correctly.
//            
//        .when()
//            .get("http://localhost:3000/students")
//            
//        .then()
//            .statusCode(200)
//            .contentType(ContentType.JSON)
//            .body("[9].course", equalTo("Spring Boot"))//validate using json path
//            .body("course", hasItem("Spring Boot"));  //validate using hasItem
        
        //Approach 2
      Response res=  given()
        .contentType(ContentType.JSON)
        
        .when()
        .get("http://localhost:3000/students");
        
        assertEquals(res.getStatusCode(), 200);//Validate using TestNG
        assertEquals(res.header("Content-Type"), "application/json");//Validate using TestNG
        
        String courseName = res.jsonPath().get("[9].course").toString();
        
        Assert.assertEquals(courseName, "Spring Boot");
        
        //Approach 1 if json key is present
//        //Using Json object class
//        JSONObject jo=new JSONObject(res.asString());//converting response to JSON Object
//        
//        //print all title of the book
//        for(int i=0;i<jo.getJSONArray("students").length();i++)
//        {
//        	String courseTitle=jo.getJSONArray("students").getJSONObject(i).get("course").toString();
//        	System.out.println(courseTitle);
//        }
        
        //approach 2 with json key
     // Convert response string into JSON Array
        JSONArray ja = new JSONArray(res.asString());

        // Print all course names
        for (int i = 0; i < ja.length(); i++) {
            JSONObject obj = ja.getJSONObject(i);
            String courseTitle = obj.getString("course");
            System.out.println(courseTitle);
        }
        
        //validate course is present or not
        boolean status=false;
        for(int i=0;i<ja.length();i++)
        {
        	JSONObject obj = ja.getJSONObject(i);
            String courseTitle = obj.getString("course");
            if(courseName.equals("Spring Boot"))
            {
            	status=true;
            	break;
            	
            }
        }
        Assert.assertEquals(status, true);
        
        //total price of course
        double price=0;
        for(int i=0;i<ja.length();i++)
        {
        	JSONObject obj = ja.getJSONObject(i);
            String courseprice = obj.getString("price");
            if(courseName.equals("Spring Boot"))
            {
            	
            	price=price+Double.parseDouble(courseprice);
            }
        }
        System.out.println("Total Price of book is:"+price);
        Assert.assertEquals(price, 599);
        
        	
        
        
    }
    
    
}