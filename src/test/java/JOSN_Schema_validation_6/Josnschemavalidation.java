package JOSN_Schema_validation_6;

import org.testng.annotations.Test;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
//import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import  io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Josnschemavalidation {
	
	@Test
	void jsonschemavalidationoint()
	{
		given()
		.when()
		.then();
		//assertThat().body(JsonSchemaValidator.matchesJosnSchemaInClasspath("Snippet.json"));
	}

}
