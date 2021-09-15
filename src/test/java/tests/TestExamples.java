package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	/*
	 * Step 1: Create a class
	 * Step 2: Create a function and annotate with @Test(TestNG)
	 * Step 3: Run a GET request
	 * Step 4: Store response and print response data
	 * Step 5: Add assertions
	 * Step 6: Run and Verify
	 */

	@Test
	public void test_01() {
		
		Response response = get("https://reqres.in/api/users?page=2");
	
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void test_02() {

		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data.id[1]", equalTo(8)).
			log().all();
	}
}
