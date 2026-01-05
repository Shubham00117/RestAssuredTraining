package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LoggingDemo {

    @Test
    void loggingMethodsDemo() {

        given()
           

        .when()
            .get("https://www.google.com/")

        .then()
        // -------- REQUEST LOGGING --------
//        .log().all()                 // logs full request (headers, params, body)
            // -------- RESPONSE LOGGING --------
            .log().status()              // logs HTTP status line
//            .log().headers()             // logs all response headers
//            .log().body()                // logs response body
//            .log().cookies()             // logs response cookies

            // -------- CONDITIONAL LOGGING --------
            .log().ifValidationFails();  // logs response only if assertion fails
    }
}