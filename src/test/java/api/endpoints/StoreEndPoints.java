package api.endpoints;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class StoreEndPoints {

	public static Response getStoreInventory() {
		Response res = given().when().get(Routes.get_store_inventory);

		return res;
	}

	public static Response postStoreOrder(Store payload) {
		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_store_order);

		return res;

	}

	public static Response getOrderId(int orderID) {
		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("orderID", orderID)
				.when().get(Routes.get_order_id);
		return res;
	}
	
	public static Response deleteStoreOrder(int orderID) {
		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("orderID", orderID)
				.when().delete(Routes.delete_order_id);
		return res;
	}


}
