package day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;//equalTo compare method needed this import to perform action

public class ParsingXMLResponse

{
	@Test(priority = 1)
	void testXMLResponse() {
		// Approach1
		given()

				.when().get("https://www.google.com/")

				.then().statusCode(200).header("Content-Type", "application/xml;charset=utf-8")
				.body("TravelerinformationResponse.page", equalTo("1"))
				.body("TravelerinformationResponse.travelers.travelerinformation[0].name", equalTo("Vijay Bharath"));

		// Approach2
		Response res = given()

				.when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

		Assert.assertEquals(res.getStatusCode(), 200);

		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");

		String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");

		String travalName = res.xmlPath().get("TravelerinformationResponse.page.travelerinformation[0].name")
				.toString();
		Assert.assertEquals(travalName, "abc def");

	}

	void testXMLResponseBody() {
		Response res = given()

				.when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

		XmlPath xmlobj = new XmlPath(res.asString());

		// Verify Total Numbers Travelers
		List<String> traveler_names = xmlobj.getList("TravelerinformationResponse.page.travelerinformation.name");
		Assert.assertEquals(traveler_names.size(), 10);

		// Verify traveler names present in response
		List<String> traveler_names_verify = xmlobj
				.getList("TravelerinformationResponse.page.travelerinformation.name");

		boolean status = false;
		for (String name : traveler_names_verify) {
			if (name.equals("abc def")) {
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);

	}

}
