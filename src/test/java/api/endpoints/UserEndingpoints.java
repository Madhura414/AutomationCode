package api.endpoints;
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

public class UserEndpoints {
	//useEndPoints.java
	//created to perform Create,Read,Update,Delete requests to the user API.
	 public static Response CreateUser(User payload)
	{
		 //storing the response in variable
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().post(Routes.post_create_url); //refering url from Route class
		return response;
		
	}
	 public static Response readUser(String Username)
		{
			 //storing the response in variable
			Response response=given()
			.pathParam("Username", Username)
			.when().post(Routes.get_get_user); //refering url from Route class
			return response;
			
		}
	 
	 public static Response UpdatedUser(String Username,User payload)
		{
			 //storing the response in variable
			Response response=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
			.pathParam("Username", Username).body(payload)
			.when().put(Routes.put_update_user); //refering url from Route class
			return response;
			
		}
	 public static Response DeletedUser(String Username)
		{
			 //storing the response in variable
			Response response=given()
					
			.pathParam("Username", Username)
			.when()
			.put(Routes.delete_delete_user); //refering url from Route class
			return response;
			
		}

}

