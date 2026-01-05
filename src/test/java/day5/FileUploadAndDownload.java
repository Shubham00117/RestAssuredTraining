package day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FileUploadAndDownload 
{
	
	//Single File Upload
	@Test(priority = 1)
	void singleFileUpload()
	{
		File myfile=new File("/Users/shubham_infinity/Desktop/test1/RestAssuredTraining/fileUpload");
		
		given()
		.multiPart("file",myfile)// Attach file as multipart form data with key name "file"
		.contentType("multipart/form-data")// Set request type for file upload
		
		.when()
		.post("http://localhost:8080/uploadFile")
		
		.then()
		.statusCode(200)
		.body("fileName", equalTo("Test1.txt"))
		.log().all();
		
	}
	//Multiple File Upload
	@Test(priority = 2)
	void MultiFileUpload()
	{
		File myfile1=new File("/Users/shubham_infinity/Desktop/test1/RestAssuredTraining/fileUpload");
		File myfile2=new File("/Users/shubham_infinity/Desktop/test1/RestAssuredTraining/fileUpload");
		
		given()
		.multiPart("files",myfile1)// Attach file as multipart form data with key name "file"
		.multiPart("files",myfile2)// Attach file as multipart form data with key name "file"
		.contentType("multipart/form-data")// Set request type for file upload
		
		.when()
		.post("http://localhost:8080/uploadFile")
		
		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("Test1.txt"))
		.body("[1].fileName", equalTo("Test2.txt"))
		.log().all();
		
	}
	
	@Test(priority = 3)
	void MultiFileUpload2()//wont work for all kinds API
	{
		File myfile1=new File("/Users/shubham_infinity/Desktop/test1/RestAssuredTraining/fileUpload");
		File myfile2=new File("/Users/shubham_infinity/Desktop/test1/RestAssuredTraining/fileUpload");
		
		File arrfile[]= {myfile1,myfile2};
		
		given()
		.multiPart("files",arrfile)// Attach file as multipart form data with key name "file" using array
		
		.contentType("multipart/form-data")// Set request type for file upload
		
		.when()
		.post("http://localhost:8080/uploadFile")
		
		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("Test1.txt"))
		.body("[1].fileName", equalTo("Test2.txt"))
		.log().all();
		
	}
	
	//Download file and see response in console window
	void fileDownload()
	{
		given()
		
		.when()
		.get("http://localhost:8080/uploadFile/Test1.txt")
		
		.then()
		.statusCode(200)
		.log().body();
	}
	
	//download file and saved
	void fileDownloadAndSave() throws IOException
	{
	    // Send GET request and store the full HTTP response
	    Response response =
	        given()
	        .when()
	            .get("http://localhost:8080/uploadFile/Test1.txt");

	    // Convert response body (file content) into byte array
	    byte[] fileBytes = response.asByteArray();

	    // Create file object for download location and file name
	    File file = new File("downloads/Test1.txt");

	    // Create parent directory if it does not exist
	    file.getParentFile().mkdirs();

	    // Write downloaded bytes into the file
	    Files.write(file.toPath(), fileBytes);

	    // Print absolute file path where file is saved
	    System.out.println("File downloaded at: " + file.getAbsolutePath());
	}

}
