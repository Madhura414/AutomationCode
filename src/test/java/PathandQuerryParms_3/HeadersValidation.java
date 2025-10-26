package PathandQuerryParms_3;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersValidation
{
	//@Test
	void cookies()
	{
		given().log().all()
		.when().get("https://www.google.com/")
		.then().statusCode(200).header("Content-type", "text/html; charset=ISO-8859-1").log().all();
		
	}
} 