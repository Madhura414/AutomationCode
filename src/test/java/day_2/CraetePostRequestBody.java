package day_2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.HashMap;

import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.support.FileReader;

public class CraetePostRequestBody {

	///*Different Ways to create post Request Body
	//1.post request body create hashmap
	//2.post request body create org.json
	//3.post request body creting POJO CLASSES(plain old java object)
	//4.post request external json file data
	////1.post request body create hashmap
	//@Test
	
	void testpostusinghashmap()
	{
		HashMap data= new HashMap();
		data.put("sname","bruce");
		data.put("grade","c");
		
		
		given().contentType("application/json").body(data)
				.when().post("http://localhost.3000/StudentsData1")
			   .then()
			   .statusCode(201)
			   .body("sname", equalTo("BEnni")).
			   body("grade", equalTo("A")).log().all();
			}
	
	//3.post request body creating POJO CLASSES(plain old java object)
	@Test(priority =1)
	void testpostusingPOJOClass()
	{
		pojo_postRequest data= new  pojo_postRequest();
		data.setName("Madhuraaa");
		data.setJob("leaders");
	
	HashMap data1= new HashMap();
	data1.put("name","mdhura");
	data1.put("job","leader");
	given().contentType("application/json").body(data1)
			
	.when().put("https://reqres.in/api/users/")
	.then().statusCode(200).log().all();
}
	//4.post request json file data
	void PostjosnExternalSourceFile()
	{
		File F= new File(".\\body.json");
		FileReader fr=new FileReader();
		//JSONTokener js= new JSONTokener(null);
		HashMap data2= new HashMap();
		//data2.setName("Madhuraaa");
		//data2.setJob("leaders");
	
	HashMap data1= new HashMap();
	data1.put("name","mdhura");
	data1.put("job","leader");
	given().contentType("application/json").body(data1)
			
	.when().put("https://reqres.in/api/users/")
	.then().statusCode(200).log().all();
		
		
	}
}

