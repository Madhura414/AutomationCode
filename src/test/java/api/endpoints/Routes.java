package api.endpoints;

//base uri - https://petstore.swagger.io/v2

//create user - https://petstore.swagger.io/v2/user              - POST
//get user - https://petstore.swagger.io/v2/user/{userName}      - GET
//update - https://petstore.swagger.io/v2/user/{userName}		 - PUT
//delete - https://petstore.swagger.io/v2/user/{userName}		 - DELETE


public class Routes {

	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//end points for USER module
	
	public static String post_create_user = base_url+"/user";
	public static String get_get_user = base_url+"/user/{username}";
	public static String put_update_user = base_url+"/user/{username}";
	public static String delete_delete_user = base_url+"/user/{username}";
	
	//end points for Store module
	
	
	public static String get_store_inventory = base_url+"/store/inventory";
	public static String post_store_order = base_url+"/store/order";
	public static String get_order_id = base_url+"/store/order/{orderID}";
	public static String delete_order_id = base_url+"/store/order/{orderID}";

	

	
	
	
}
