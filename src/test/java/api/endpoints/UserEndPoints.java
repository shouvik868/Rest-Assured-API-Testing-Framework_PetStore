package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class UserEndPoints {
	
	/*
	 * This class taking urls from routes.properties file
	 * If it needs to be taken from Routes.java class, then we need to change the code
	 * By uncommenting the commented lines and commenting the current lines
	 * 
	 */
	static ResourceBundle getURL(){
		ResourceBundle routes=ResourceBundle.getBundle("routes"); // Load the routes.properties file
		
		return routes;
	}
	
	public static Response createUser(User payload){
		
		String post_url = getURL().getString("post_url");
		
		// Code to create a user
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
		   //.post(Routes.post_url); //from routes.java class
		   .post(post_url); // Assuming Routes.post_url is the endpoint for creating a user);
		return response;
		
		
	}
	
	public static Response readUser(String userName){
		
		String get_url = getURL().getString("get_url");
		// Code to get a user
		Response response=given()
				//.header("Accept", "application/json")  // Set JSON header
			    .pathParam("username", userName)
		.when()
		    //.get(Routes.user_get); //from routes.java class
		    .get(get_url); // Assuming Routes.get_url is the endpoint for getting a user)
		return response;
		
		
	}
	
	public static Response updateUser(String userName, User payload) {
		
		String update_url = getURL().getString("update_url");
		// Code to update a user
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
			.when()
			    //.put(Routes.user_update); //from routes.java class
			 .put(update_url); // Assuming Routes.update_url is the endpoint for updating a user);
		return response;

	}
	
	public static Response deleteUser(String userName) {
		
		String delete_url = getURL().getString("delete_url");
		// Code to delete a user
		Response response = given()
				.pathParam("username", userName)
			.when()
				//.delete(Routes.user_delete);
			    .delete(delete_url); // Assuming Routes.delete_url is the endpoint for deleting a user);
		
		return response;

	}

}
