package DAY_2;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.google.common.io.Files;

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

public class PostRequestBody_UsingPOJO {
	//2.post request body create POJO (plain old java object)
		@Test(priority=1)

		void test_postusingPJOClass()
		
		{
			POJO_PostRequest data= new  POJO_PostRequest();
			data.setName("Madhura");
			data.setAge("56");
			data.setMajor("Science");
		
			given().contentType("application/json")
			
			.body(data)
					.when().post("http://localhost:3000/students")
				   .then()
				   .statusCode(201)
				   .body("name", equalTo("Madhura")).
				   body("age", equalTo("56")).log().all();
				}

}

