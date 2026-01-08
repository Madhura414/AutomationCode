package DAY_4;
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
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
public class Parsing_JosnResponseData {
	//@Test(priority=1)
void test_JsonResponse()
//	//Approach1
//	{
//		given()
//		.contentType("ContentType.JSON")
//		.when().get("http://localhost:3000/students")
//		.then().statusCode(200).header("Content-Type", "application/json")
//		//jsonpathfinder use 
//		//When the response is a JSON array, always use: its in array
//
////[index].field → for specific item
////hasItem() / hasItems() → to check existence
//		.body("[0].name", equalTo("John Doe")).log().all();}



	//APPROACH 2
	{
		Response res= given()
				.contentType("ContentType.JSON")
	.when()
	.get("http://localhost:3000/students");
		// Status & header validation
	Assert.assertEquals(res.getStatusCode(),200);////validation 1
	Assert.assertEquals(res.header("Content-Type"),"application/json");
	// Extract specific values
	String name=res.jsonPath().get("[0].name").toString();
    Assert.assertEquals(name,"John Doe");
 // Check if "madhura" exists anywhere
    java.util.List<String> names = res.jsonPath().getList("name");
    Assert.assertTrue(names.contains("madhura"));
		
	}
@Test(priority = 2)
void test_jsonResponseBodyData() {

    Response res = given()
        .contentType(ContentType.JSON)
        .when()
        .get("http://localhost:3000/students");

    // Convert response to JSON
    // Case 1: If your db.json has { "students": [ ... ] } → use JSONObject
    // Case 2: If it's direct array [ ... ] → use JSONArray directly

    // Option A: If root is { "students": [...] }
    JSONObject jo = new JSONObject(res.asString());
    JSONArray students = jo.getJSONArray("students");

    // Option B: If root is direct array [...] → uncomment this instead
    // JSONArray students = new JSONArray(res.asString());

    // Print all student names
    System.out.println("=== All Student Names ===");
    for (int i = 0; i < students.length(); i++) {
        String studentName = students.getJSONObject(0).getString("name");
        System.out.println(studentName);
    }

    // Search for a specific student (e.g., "John Doe")
    boolean status = false;
    String searchName = "John Doe";  // Change this to test others like "Emma Johnson"

    for (int i = 0; i < students.length(); i++) {
        String studentName = students.getJSONObject(i).getString("name");
        if (studentName.equals(searchName)) {
            status = true;
            break;
        }
    }

    System.out.println("Student '" + searchName + "' found: " + status);
}
}