package Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Base {
	@Test
	void BaseTest()
	{
    given().log().all()
		
		.when().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200).body("page", equalTo(2)).log().all();
		
	}

	@Test(priority=1)
	void PostRequest()
	{
		given().baseUri("https://petstore.swagger.io/")
		.when().get("v2/user/madhura").then().log().all();
	}
}
 
