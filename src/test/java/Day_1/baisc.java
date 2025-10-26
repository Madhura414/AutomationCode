package Day_1;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.common.io.Files;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class baisc {
	int id;
	//@Test
	void getuser()
	{
RestAssured.baseURI = "https://reqres.in";
        
        given().log().all()
            .queryParam("page", "2")
            .header("Content-Type", "application/json")
            .body("{\r\n" +
                  "    \"name\": \"morpheus\",\r\n" +
                  "    \"job\": \"leader\"\r\n" +
                  "}")
            .when()
            
            .post("/api/users")
            .then()
            .assertThat()
            .statusCode(201);

}
	@Test(priority=1)
	void getuser2()
	{
		given().log().all()
		
		.when().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200).body("page", equalTo(2)).log().all();
		
	}
	
	@Test(priority= 2)
	
	void createuser()
	{
		HashMap data= new HashMap();
		data.put("name","mdhura");
		data.put("job","leader");
		id=given().contentType("application/json").body(data)
		.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
		//.then().statusCode(201).log().all();
	}
	@Test(priority= 3,dependsOnMethods={"createuser"})
	void updateruser()
	{
		HashMap data= new HashMap();
		data.put("name","mdhura");
		data.put("job","leader");
		given().contentType("application/json").body(data)
				
		.when().put("https://reqres.in/api/users/"+id)
		.then().statusCode(200).log().all();
	}
	@Test(priority= 4)
	void DeleteUser()
	{
		given().contentType("application/json").
		when().delete("https://reqres.in/api/users/"+id).
		then().statusCode(204).log().all();
	
	}
	}
