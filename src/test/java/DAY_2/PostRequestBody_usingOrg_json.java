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

public class PostRequestBody_usingOrg_json {

	//2.post request body create org.json Library
	@Test(priority=1)

	void test_postusingOrgJosnLibrary()
	
	{
		JSONObject  data = new JSONObject();
		
		data.put("sname","bruce");
		data.put("grade","c");
		
		
		given().contentType("application/json")
		// json library we cannot pass data directly we have to convert string format
		.body(data.toString())
				.when().post("http://localhost:3000/students")
			   .then()
			   .statusCode(201)
			   .body("sname", equalTo("bruce")).
			   body("grade", equalTo("c")).log().all();
			}

}
