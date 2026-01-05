package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakeLibraryGenerator {
	
	@Test
	void fakeDataGenerator() {

		Faker fake = new Faker();

		// name
		String firstname = fake.name().firstName();
		String lastname = fake.name().lastName();
		// address
		Address address = fake.address();
		// phone number
		String phonenumber = fake.phoneNumber().cellPhone();
		// email address
		String email = fake.internet().safeEmailAddress();

		// login details username and password
		String username = fake.name().username();
		String password = fake.internet().password();

		System.out.println("firstName: "+firstname);
		System.out.println("lastName: "+lastname);
		System.out.println("address: "+address);
		System.out.println("cellPhone: "+phonenumber);
		System.out.println("safeEmailAddress: "+email);
		System.out.println("username: "+username);
		System.out.println("password: "+password);

	}

}
