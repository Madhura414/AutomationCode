package DAY_7;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.common.io.Files;

//import Day_2.POJO_PostRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

public class FakerDataGenerator {
@Test

	void testGenerateDummyData()
	{
		Faker faker= new Faker();
	        String fullName = faker.name().fullName();         // Better: full name
	        String firstName = faker.name().firstName();
	        String email = faker.internet().emailAddress();
	        String bookTitle = faker.book().title();            // More meaningful than flag()
	        String countryFlag = faker.nation().flag();         // If you really want a flag emoji
	        String phoneNumber = faker.phoneNumber().cellPhone();

	        // Print the generated fake data
	        System.out.println("Full Name: " + fullName);
	        System.out.println("First Name: " + firstName);
	        System.out.println("Email: " + email);
	        System.out.println("Book Title: " + bookTitle);
	        System.out.println("Country Flag Emoji: " + countryFlag);
	        System.out.println("Phone Number: " + phoneNumber);
	    }
		
	}
	


