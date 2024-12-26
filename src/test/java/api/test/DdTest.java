package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DdTest {
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String userid, String username, String fn, String ln, String email, String pwd, String ph) 
	{
	User obj = new User();
	
	obj.setId(Integer.parseInt(userid));
	obj.setUsername(username);
	obj.setFirstName(fn);
	obj.setLastName(ln);
	obj.setEmail(email);
	obj.setPassword(pwd);
	obj.setPhone(ph);
	
	Response res = UserEndPoints.createUser(obj);
	Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUser(String username) {
		
		Response res = UserEndPoints.deleteUser(username);
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
}
