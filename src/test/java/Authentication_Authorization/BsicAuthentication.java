package Authentication_Authorization;

import org.testng.annotations.Test;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import  io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class BsicAuthentication {
	@Test
	void BasicAuthentication()
	{ 
		
		given()
		.auth()
		.basic("postman","password" )
.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true)).log().all();
	}
	@Test
	void testDigestAuthentication()
	{
		
		given()
		.auth().digest("postman","password" )
.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true)).log().all();
	}
@Test
	void testPremitivetAuthentication()
	{
		
		given()
		.auth().preemptive().basic("postman","password" )
.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true)).log().all();
	}
@Test
void BearertokenAuthentication()
{
	String bearerToken="";
	
	given()
	.header("Authorozation"," Bearer"+bearerToken)
.when()
	.get("https://postman-echo.com/basic-auth")
	.then()
	.statusCode(200)
	.body("authenticated", equalTo(true)).log().all();
}
@Test
void testOauthtAuthentication()
{
	
	
	given().auth().oauth("consumerkey", "ConsumerrScercet", "accesstoken", "tokensecrate")//Oauth1.0
	
.when()
	.get("url")
	.then()
	.statusCode(200)
	.body("authenticated", equalTo(true)).log().all();
}
}
