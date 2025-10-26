package ParsingJsonResponseData_4;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import  io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class ParsingjosnResponseData {
	@Test(priority=1)
	void Jsondatavaidtion()
//	{
//		given().contentType("ContentType.JSON")
//		.when().get("http://localhost:3000/StudentsData1")
//		.then().statusCode(200).header("Content-Type", "application/json")
//		//jsonpathfinder use 
//		.body("grade", equalTo("B"));	}
//
//
	//APPROACH 2
	{
		Response res= given().contentType("ContentType.JSON")
	.when().get("http://localhost:3000/StudentsData1");
		
	Assert.assertEquals(res.getStatusCode(),200);////validation 1
	Assert.assertEquals(res.header("Content-Type"),"application/json");
	
	String name=res.jsonPath().get("sname").toString();
    Assert.assertEquals(name,"BEnni");
		
	}
}
