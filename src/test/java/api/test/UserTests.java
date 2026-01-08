package api.test;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.common.io.Files;


import api.endpoints.UserEndingpoints;
import api.payload.User;
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
//this is for test cases 
public class UserTests {
	Faker faker;
	User Payload;
	@BeforeClass
	public void SetupData() {
		faker= new Faker();
		Payload= new User();
		 Payload.setId(faker.idNumber().hashCode());
		 Payload.setUsername(faker.name().username());
		 Payload.setFirstName(faker.name().firstName());
		 Payload.setLastName(faker.name().lastName());
		 Payload.setEmail(faker.internet().emailAddress());
		 Payload.setPassword(faker.internet().password());
		 Payload.setPhone(faker.phoneNumber().phoneNumber());
	}
	@Test(priority = 1)
	public void testPostCreateUser() {
		
		Response res = UserEndingpoints.CreateUser(Payload);
		Assert.assertEquals(res.getStatusCode(), 200);
	

	}
	@Test(priority = 2)
	public void testGETUserByNames() {
		
		Response res = UserEndingpoints.readUser(this.Payload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	

	}

}
