package DAY_6;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;

//import Day_2.POJO_PostRequest;
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
// POJO--serialization--->JSONObject -----Deserilazation--->pojo

public class SerializationDesirization {
	@Test
	void Pojo2Json() throws JsonProcessingException
	{
		//creating java object using pojo class
PojoStudent stupojo= new PojoStudent(); //pojo class object
		
stupojo.setName("simth");
stupojo.setAge("389j");
stupojo.setMajor("science science");

//convert java object ---> json object (serilization)
ObjectMapper objmapper = new ObjectMapper();
///this is in jsonformat the conver into string
String jsondata=objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
System.out.println("jsondata");

}

}
