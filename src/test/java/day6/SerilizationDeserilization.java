package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilizationDeserilization {

	// Create Java Object Using POJO Class
	@Test(priority = 1)
	void convertPojo2Json() throws JsonProcessingException {
		Student data = new Student();
		data.setName("Scott");
		data.setCourse("RestAssured");
		data.setEmail("abc@gmail.com");

		// Convert Java object ----> Java Object (Serilization)
		ObjectMapper objmapper = new ObjectMapper();

		String jsondata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsondata);

	}
		@Test(priority = 2)
		void convertJson2Pojo() throws JsonMappingException, JsonProcessingException
		{
			String jsondata="{\n"
					+ "  \"name\" : \"Scott\",\n"
					+ "  \"course\" : \"RestAssured\",\n"
					+ "  \"email\" : \"abc@gmail.com\"\n"
					+ "}";
			ObjectMapper objmapper = new ObjectMapper();
			
		Student stupojo=objmapper.readValue(jsondata, Student.class);//convert json to pojo
		System.out.println("name :"+stupojo.getName());
		System.out.println("course :"+stupojo.getCourse());
		System.out.println(""+stupojo.getEmail());
			
		}

}
