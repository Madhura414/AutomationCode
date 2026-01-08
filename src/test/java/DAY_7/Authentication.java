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

public class Authentication {
	@Test(priority=1)

	// 1.Basic Authentication
	void testBasicAuthentication() {
		// here we can use method auth
given()
		.auth().basic("postman", "password")
		.when()
	.get("https://postman-echo.com/basic-auth")
	.then()
				.statusCode(200).body("authenticated", equalTo(true)).log().all();

	}

	// 2.digest Authentication
	// @Test(priority=2)

	void testdigestAuthentication() {
		// here we can use method auth
		given().auth().digest("postman", "password").when().get("https://postman-echo.com/basic-auth").then()
				.statusCode(200).body("authenticated", equalTo(true)).log().all();

	}
	// 3.preemptive Authentication
	// @Test(priority=3)

	void testpreemptiveAuthentication() {
		// here we can use method auth
		given().auth().preemptive().basic("postman", "password").when().get("https://postman-echo.com/basic-auth")
				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();

	}

	// @Test(priority=4)
	// 4.Bearer token authentication
	void testBearerAuthentication() {
		String BearerToken = "";//"";
		given().headers("Authorization", "Bearer" + BearerToken).when().get("https://docs.github.com/rest").then()
				.statusCode(200).log().all();
	}

	//@Test(priority = 5)
	// 4.Oauth token authentication
	void testOAuthAuthentication() {

		given().auth().oauth2("")//"").when().get("https://docs.github.com/rest")
				.then().statusCode(200).log().all();
	}
	@Test(priority = 6)
	// 4.ApiKey authentication
	void testApiKeyAuthentication() {

		given().auth().oauth2("")//"").when().get("https://docs.github.com/rest")
				.then().statusCode(200).log().all();
	}
	
}
