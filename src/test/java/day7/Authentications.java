package day7;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

//Basic Authentication
//Basic Authentication sends the username and password with each request in the HTTP Authorization header after Base64 encoding. It is simple to implement but less secure, so it is commonly used with HTTPS.

//Digest Authentication
//Digest Authentication improves security by sending a hashed version of the credentials instead of the plain password. It follows a challenge–response mechanism and works only if the server supports digest authentication.

//Preemptive Basic Authentication
//Preemptive Authentication sends the authentication credentials along with the initial request without waiting for a server challenge. This reduces request latency and improves performance.


public class Authentications 
{
	@Test(priority = 1)
	void testbasicAuthentication()
	{
		given()
		// Passing login credentials (username and password) for API authentication
		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	
	@Test(priority = 2)
	void testDigestAuthentication()
	{
		given()
		// Authenticate request using Digest Authentication (hashed credentials)
		.auth().digest("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	
	@Test(priority = 3)
	void testPreemtiveAuthentication()
	{
		given()
		// Send Basic Authentication credentials preemptively without waiting for server challenge
		.auth().preemptive().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	
	@Test(priority = 4)
	void testBarerTokenAuthentication() 
	{
		String bearer="Paste your git key";
		
		given()
		.headers("Authorization","Bearer "+bearer)// Send Bearer token in the Authorization header for API authentication
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	void testOAuth1Authentication()
	{
		given()
		// Authenticate request using OAuth 1.0 with consumer key, secret, access token, and token secret
		.auth().oauth("consumerkey", "consumerSecret", "accessToken", "tokenSecret")
		.when()
		.get("URL")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	void testOAuth2Authentication()
	{
		given()
		//Authenticate request using OAuth 2.0 by passing the access token
		.auth().oauth2("Paste your git key")
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	void testApiKeyAuthentication()
	{
		//Method 1:
		given()
		// Add query parameter 'appid' (API key) to authenticate/authorize the request
		.queryParam("appid", "dnfjkj4j5454kkk45JJJjgjjfljKJKHKHIHIOJopenweathermap")
		
		.when()
		.get("https://google.com")
		
		.then()
		.statusCode(200)
		.log().all();
		
		// Method 2:
//		 API Key Authentication using Path & Query Parameters
		given()
		    .queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
		    .pathParam("mypath", "data/2.5/forecast/daily")
		    .queryParam("q", "Delhi")
		    .queryParam("units", "metric")
		    .queryParam("cnt", 7)

		.when()
		    .get("https://api.openweathermap.org/{mypath}")

		.then()
		    .statusCode(200)
		    .log().all();
	}
}
