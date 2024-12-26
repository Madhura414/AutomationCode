package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {

	Store payload;
	Faker faker;
	
	@BeforeClass
	public void data() {
		
		payload = new Store();
		faker = new Faker();;
		
		payload.setId(faker.idNumber().hashCode());
		payload.setPetId(9);
		payload.setQuantity(2);
		//payload.setShipDate(faker.date().birthday());
		payload.setComplete(true);
		payload.setStatus("Complete");
	}

	@Test(priority = 0)
	public void testStoreInventory() {

		Response res = StoreEndPoints.getStoreInventory();
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);

	}

	@Test(priority = 1)
	public void testStoreOrder() {
		
		Response res = StoreEndPoints.postStoreOrder(payload);
		Assert.assertEquals(res.statusCode(), 200);

	}
	
	@Test(priority=2)
	public void testStoreId() {
		Response res = StoreEndPoints.getOrderId(this.payload.getId());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testDeleteorder() {
		Response res = StoreEndPoints.getOrderId(this.payload.getId());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
