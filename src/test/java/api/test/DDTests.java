package api.test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.uilities.DataProviders;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUsers(String userID, String userName, String fname, String lName, String useremail, String pwd,
			String ph) throws InterruptedException {

		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lName);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		// Code to test creating a user
		Response response = UserEndPoints.createUser(userPayload);
		// response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Thread.sleep(4000);

	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) throws InterruptedException {
		
		
		// Code to test delete a user by username
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		Thread.sleep(2000);
	}

}
