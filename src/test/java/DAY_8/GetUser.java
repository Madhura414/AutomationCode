package DAY_8;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestContext;
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


public class GetUser {
	public void test_createuser(ITestContext context)
	{
	
	int id = (Integer)context.getAttribute("user_id");// it should coming from createuser request
	
	String BearerToken= "378f3ae4453f58ccf0ce9745bdb93858a6528a3a34050d843b890ad27bfe525a";
	
	given()
	.headers("Authorization","Bearer " + BearerToken)
	.pathParam("id",id)
	
	.when()
	.get("https://gorest.co.in/public/v2/{id}")
	.then()
    .statusCode(200)  // Expected on success
    .log().all()      // Print full response for debugging
    .extract()
    .path("id");      // Safer way to extract id
	
	
	
}

}
