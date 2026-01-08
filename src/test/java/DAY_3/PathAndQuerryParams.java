package DAY_3;
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
import io.restassured.internal.support.FileReader;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.HashMap;

public class PathAndQuerryParams {
	@Test
	
	void TestQuerry()
	{
		//https://reqres.in/api/users?page=2
		given()
		.pathParams("mypath", "users")//path
		.queryParams("page",2)//querry
		.queryParams("id",5)//querry
		
		.when().get("https://reqres.in/api/{mypath}")
		.then().statusCode(200)
		.log().all();

		
	}

}
