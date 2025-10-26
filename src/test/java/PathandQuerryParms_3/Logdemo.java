package PathandQuerryParms_3;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Logdemo 
{
	@Test
	void cookies()
	{
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		//log().cookies()
		//.log().headers()
		//.log().body()
		.log().all();
		
		
	}
}



