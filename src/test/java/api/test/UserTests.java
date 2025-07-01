package api.test;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	public  Logger logger;

	@BeforeClass
	public void setup() {
		// Setup code for the tests, if needed

		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUserStatus(0); // Default value for userStatus
		//logs
		logger=LogManager.getLogger(UserTests.class);
		

	}

	// Post request testcase
	@Test(priority = 1,enabled = true)
	public void testPostUser() throws InterruptedException {
		logger.info("Creating user with username: " + userPayload.getUsername());
		// Code to test creating a user
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Thread.sleep(6000);
	}

	// Get request testcase
	@Test(priority = 2,enabled = true)
	public void testGetUserByName() throws InterruptedException {
		logger.info("Retrieving user with username: " + userPayload.getUsername());
		// Code to test retrieving a user by username
		System.out.println("Username: " + userPayload.getUsername() + "++++++"); // Print the username for debugging
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		// Response response = UserEndPoints.readUser("Tubai s");
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		// User userResponse = response.as(User.class); // Deserialize the response to
		// User object
		// Assert.assertEquals(userResponse.getUsername(), userPayload.getUsername());
		Thread.sleep(4000);

	}

	// Put request testcase
	@Test(priority = 3,enabled = true) // Set enabled to false to skip this test)
	public void testUpdateUserByName() throws InterruptedException {
		logger.info("Updating user with username: " + userPayload.getUsername());
		// Code to test updating a user by username
		userPayload.setFirstName(faker.name().lastName());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setFirstName(faker.internet().safeEmailAddress());// Update for testing
		System.out.println("Updated Username: " + userPayload.getUsername() + "++++++"); // Print the updated username for debugging
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body(); // Log the response body for debugging;
		// response.then().log().body().statusCode(200); //Another assertion method
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Thread.sleep(2000);
		
		// Optionally, verify the updated user
		System.out.println("Username after updation: " + userPayload.getUsername() + "++++++");
		Response getAfterResponse = UserEndPoints.readUser(this.userPayload.getUsername());
		getAfterResponse.then().log().all();
		Assert.assertEquals(getAfterResponse.getStatusCode(), 200);
		
		Thread.sleep(3000);
	}

	// Delete request testcase
	@Test(priority = 4,enabled = true) // Set enabled to false to skip this test)
	public void testDeleteUserByName() {
		logger.info("Deleting user with username: " + userPayload.getUsername());
		// Code to test delete a user by username
		System.out.println("Username before deletion: " + userPayload.getUsername() + "++++++");
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200); 

	}

}
