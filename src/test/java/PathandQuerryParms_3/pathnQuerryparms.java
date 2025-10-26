package PathandQuerryParms_3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//https://reqres.in/api/users?page=2

public class pathnQuerryparms {
	@Test(priority=1)
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
