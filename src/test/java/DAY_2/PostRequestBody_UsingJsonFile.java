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
//it not worked 
public class PostRequestBody_UsingJsonFile {
	//4.post request json file data
		void PostjosnExternalSourceFile() throws FileNotFoundException
		{
			File f= new File(".\\Students.json");
			FileReader fr=new FileReader();
			//JSONTokener jt= new JSONTokener(fr);
//			JSONObject data= new JSONObject(jt);
			HashMap data2= new HashMap();
			//data2.setName("Madhuraaa");
			//data2.setJob("leaders");
		
given().contentType("application/json")
			
			//.body(data)
					.when().post("http://localhost:3000/students")
				   .then()
				   .statusCode(201)
				   .body("name", equalTo("Madhura")).
				   body("age", equalTo("56")).log().all();
			
			
		}

}
