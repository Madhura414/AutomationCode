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
public class Cookiesvalidation {
	//@Test
	void cookies()
	{
		given()
		        .log().all()
		.when()
		          .get("https://www.google.com/")
		.then()
		          .statusCode(200)
		.cookie("AEC", "AZ6Zc-VJHyhQx5e_Lufo1xywFRYPzuaBQ07QhFzWD-P1bW2C4nYgzSoPEY4").log().all();
		
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