package PathandQuerryParms_3;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Cookiesvalidation {
	//@Test
	void cookies()
	{
		given().log().all()
		.when().get("https://www.google.com/")
		.then().statusCode(200).cookie("AEC", "AZ6Zc-VJHyhQx5e_Lufo1xywFRYPzuaBQ07QhFzWD-P1bW2C4nYgzSoPEY4").log().all();
		
	}
@Test(priority=2)
void getcookiesinfo()
{
//	ValidatableResponse res= given().
//  when().get("https://www.google.com/")
//  
//  //getsingle cookieinfo
//  String cookie_value= res.getCookie("AEC");
//	System.out.println("value of cookie is -->"+cookie_value);
//  
//	.then();
	
}
}
