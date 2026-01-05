package day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo
{
//	@Test(priority = 1)
	void testCookies() 
	{
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC", "AaJma5uSqtaPABhrlhQlW6S5FFhmiUlG_BDkD5jfl9OOMqs6xsj0Zjqk114")
		.log().all();
	}
	
	@Test(priority = 2)
	void getCookiesInfo()
	{
		
		Response res=given()
		
		.when()
		.get("https://www.google.com/");
		
		//get single cookies info
//		String cookiesvalue=res.getCookie("AEC");
//		System.out.println("The Value of Cookies is ====>"+cookiesvalue);
		
		//get all cookies
		Map<String, String> allcookies=res.cookies();
//		System.out.println(allcookies.keySet());
		
		for (String k : allcookies.keySet()) 
		{
			String value=res.getCookie(k);
			System.out.println(k+"             "+value);
			
		}
	}

}
