package api.test;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.StoreEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Store;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class StoreDataDrivenTests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostStoreOrder(String identity, String petIdentity, String quantityno, String orderStatus, String completeStatus) {
		Store obj = new Store();
		obj.setId(Integer.parseInt(identity));
		obj.setPetId(Integer.parseInt(petIdentity));
		obj.setQuantity(Integer.parseInt(quantityno));
		obj.setStatus(orderStatus);
		obj.setComplete(Boolean.parseBoolean(completeStatus));

		Response res = StoreEndPoints.postStoreOrder(obj);
		Assert.assertEquals(res.getStatusCode(), 200);

	}

}