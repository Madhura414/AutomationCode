package JOSN_Schema_validation_6;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import PostRequestBody.pojo_postRequest;

public class Serialization_Deserialization {
@Test
void Pojo2Json() throws JsonProcessingException
{
	//created javaobject-> using pojo class
	PostRequestBody Studata= new  PostRequestBody();//pojo
	
	Studata.setSetName("scott");
	Studata.setSetJob("b");
	//convert java object -->json object(serialization)
	ObjectMapper objmapper= new ObjectMapper();
	String josndata= objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(Studata);
	System.out.println(josndata);
		

}
}
