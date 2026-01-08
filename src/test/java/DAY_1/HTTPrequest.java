package DAY_1;
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
import java.util.HashMap;
//this mainly CRUD 
public class HTTPrequest {
	/*
	given()
	    content type, set cookies, add auth, add param, set headers info etc....

	when()
	    get, post, put, delete

	then()
	    validate status code, extract response, extract headers cookies & response body
	*/
	int Id;

	//@Test(priority=1)
	
	@Test
    void getUsers_basicValidations() {
        given()
            .header("Accept", "application/json")
            .log().all()
        .when()
            .get("https://jsonplaceholder.typicode.com/users")
        .then()
            .statusCode(200)
            .body("size()", equalTo(10))
            .body("[0].id", equalTo(1))
            .body("[0].name", equalTo("Leanne Graham"))
            .body("[9].id", equalTo(10))
            .log().all();
    }

    @Test(priority = 1)
    void createUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "madhura");
        data.put("job", "QA");

        Response response = given()
            .contentType(ContentType.JSON)
            .body(data)
            .log().all()
        .when()
            .post("https://jsonplaceholder.typicode.com/users")
        .then()
            .statusCode(201)  // Correct for POST
            .body("name", equalTo("madhura"))
            .body("job", equalTo("QA"))
            .log().all()
            .extract().response();

        // Extract and store the fake ID (always 101 for new creates)
        Id = response.jsonPath().getInt("id");
        System.out.println("Created user with fake ID: " +Id);
    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    void updateUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "madhura updated");
        data.put("job", "Senior QA");

        given()
            .contentType(ContentType.JSON)
            .body(data)
            .log().all()
        .when()
            .put("https://jsonplaceholder.typicode.com/users/1")//+Id
        .then()
            .statusCode(200)  // Correct for PUT
            .body("name", equalTo("madhura updated"))
            .body("job", equalTo("Senior QA"))
            .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void deleteUser() {
        given()
            .log().all()
        .when()
            .delete("https://jsonplaceholder.typicode.com/users/1") //+Id
        .then()
            .statusCode(200)  // Correct for DELETE (returns {} empty body)
            .body(is(emptyOrNullString()))  // Optional: check empty response
            .log().all();
    }
}
