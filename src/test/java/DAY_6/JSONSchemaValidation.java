
package DAY_6;
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

public class JSONSchemaValidation {
	
	
	
	
	@Test
	void jsonscheavlidation()
	{
		given()
		.when()
		         .get("http://localhost:3000/students")
		//here we have to to do schema validtion  --need to add dependency in pom.xml file 
		.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Student.json"));
	}

}
