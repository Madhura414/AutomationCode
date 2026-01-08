package DAY_2;
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

//C:\Users\ADMIN>cd /d C:\Apirequest
//
//C:\Apirequest>
//C:\Apirequest>
//C:\Apirequest>json-server --watch Data.jsonjson-server --watch Data.jsonjson
//--watch/-w can be omitted, JSON Server 1+ watches for file changes by default
//File Data.jsonjson-server not found
//
//C:\Apirequest>jso
//'jso' is not recognized as an internal or external command,
//operable program or batch file.
//
//C:\Apirequest>
//C:\Apirequest>json-server Student.json
//JSON Server started on PORT :3000
//Press CTRL-C to stop
//Watching Student.json...
//
//(˶ᵔ ᵕ ᵔ˶)

//Index:
//http://localhost:3000/
//
//Static files:
//Serving ./public directory if it exists
public class PostRequestBody_usingHashMap {
	///*Different Ways to create post Request Body
		//1.post request body create hashmap
		//2.post request body create org.json
		//3.post request body creting POJO CLASSES(plain old java object)
		//4.post request external json file data
		



//1.post request body create hashmap
@Test(priority=1)

void test_postusingHashMap()
{
	HashMap data= new HashMap();
	data.put("sname","bruce");
	data.put("grade","c");
	
	
	given()
	    .contentType("application/json")
	       .body(data)
	.when()
			.post("http://localhost:3000/students")
	.then()
		   .statusCode(201)
		   .body("sname", equalTo("bruce")).
		   body("grade", equalTo("c")).log().all();
		}

//if u want to delete those created data 
//@Test()
void test_deleteusingHashMap() {
given()
.when().delete("http://localhost:3000/students/b56f")
.then()
.statusCode(200)
;
}

}