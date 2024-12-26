package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayLoad;
	public Logger logger;


	@BeforeClass
	public void dataSetup() {

		faker = new Faker();
		userPayLoad = new User();

		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().emailAddress());
		userPayLoad.setPassword(faker.internet().password());
		userPayLoad.setPhone(faker.phoneNumber().phoneNumber());

		//logs
		logger = LogManager.getLogger(this.getClass());
		logger.debug("debugging.....");
	}

	@Test(priority = 1)
	public void testPostCreateUser() {
		logger.info("***************** Create User test Started *****************");
		Response res = UserEndPoints.createUser(userPayLoad);
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("***************** Create User test ended *****************");

	}

	@Test(priority = 2)
	public void testGetUserDetails() {

		Response res = UserEndPoints.getUserUser(this.userPayLoad.getUsername());
		res.then().log().all();
		String it = res.getBody().jsonPath().get("email");
		System.out.println(it);
		Assert.assertEquals(res.statusCode(), 200);

	}

	@Test(priority = 3)
	public void testUpdateUser() {

		userPayLoad.setEmail(faker.internet().emailAddress());
		userPayLoad.setPhone(faker.phoneNumber().phoneNumber());
		;

		Response res = UserEndPoints.updateUser(this.userPayLoad.getUsername(), userPayLoad);
		res.then().log().all();

		// Checking the updated data

		Response res2 = UserEndPoints.getUserUser(this.userPayLoad.getUsername());
		res2.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);

	}

	@Test(priority = 4)
	public void testDeletUser() {

		Response res = UserEndPoints.deleteUser(this.userPayLoad.getUsername());
		res.then().log().all();

		Assert.assertEquals(res.statusCode(), 200);

	}

}
