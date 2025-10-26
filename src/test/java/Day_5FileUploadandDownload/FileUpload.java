package Day_5FileUploadandDownload;import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import  io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUpload {
	@Test
	void SingleFileupload()
	{
		File myfile= new File("");
		given()
		.multiPart("",myfile)
		.contentType("")
		.when().post("")
		.then().statusCode(200).body("", equalTo(""))
		.log().all();
	}
	void MultipleFileUpload()
	{
		File myfile2= new File("");
		File myfile3= new File("");
		given()
		.multiPart("",myfile3)
		.multiPart("",myfile2)
		.contentType("")
		.when().post("")
		.then().statusCode(200).body("", equalTo(""))
		.log().all();
	}


}
