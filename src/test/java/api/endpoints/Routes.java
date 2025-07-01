package api.endpoints;

public class Routes {
	
/*
	 Swagger API Documentation:
	 Swagger URI: https://petstore.swagger.io
	 Create User(POST):   https://petstore.swagger.io/v2/user
	 Get User(GET):       https://petstore.swagger.io/v2/user/{username}
	 Update User(PUT):    https://petstore.swagger.io/v2/user/{username}
	 Delete User(DELETE): https://petstore.swagger.io/v2/user/{username}
*/
	
	public static String base_url = "https://petstore.swagger.io/v2/"; // Base URL for the API";
	
	// User Endpoints
	public static String post_url = base_url + "user"; 
	public static String user_get = base_url + "user/{username}"; // Get User
	public static String user_update = base_url + "user/{username}"; // Update User
	public static String user_delete = base_url + "user/{username}"; // Delete User
	
	// Pet Endpoints
	   // Pet Endpoints
	//Store Endpoints
		// Store Endpoints

}
