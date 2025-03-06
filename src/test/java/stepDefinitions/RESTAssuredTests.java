package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RESTAssuredTests {

	public static RequestSpecification httpRequest;
	public static Response response;
	public static String endPoint;
	public static String strFile;

	@Given("API server is up & running on {string}")
	public void api_server_is_up_running_on(String string) {
		RestAssured.baseURI = string;

		given().contentType(ContentType.JSON).when().get(string).then().statusCode(200);
	}

	@When("user access the endpoint {string}")
	public void user_access_the_endpoint(String string) {

		endPoint = string;
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, string);

	}

	@Then("user should get status as {string}")
	public void user_should_get_status_as(String string) {

		int statusCode = response.getStatusCode();
		Assert.assertEquals(Integer.parseInt(string), statusCode);
	}

	@Then("user should receive data with header content-type as {string}")
	public void user_should_receive_data_with_header_content_type_as(String string) {

		Headers headers = response.getHeaders();
		Assert.assertEquals("application/json", headers.get("Content-Type").getValue());

	}

	@Then("user should get active user {string}")
	public void user_should_get_active_user(String string) {

		ResponseBody body = response.getBody();
		Assert.assertTrue(body.asPrettyString().contains(string));
//		System.out.println("body: " + body.asPrettyString());		
//		implement this later
//		List<Object> allUsers = body.as(List.class);
//		System.out.println(allUsers.size());
//		Map<String, Object> user1 = (Map<String, Object>) allUsers.get(0);
//		System.out.println(user1.get("name"));

	}

	@Then("user should get stock as {string}")
	public void user_should_get_stock_as(String string) {

		ResponseBody body = response.getBody();
		Assert.assertTrue(body.asPrettyString().contains(string));
//		System.out.println("body: " + body.asPrettyString());

	}

	@When("user create and reads the payload {string}")
	public void user_create_and_reads_the_payload(String string) {

		String dir = System.getProperty("user.dir");
		Path fileName = Path.of(dir + File.separator + "src" + File.separator + "test" + File.separator + "resources"
				+ File.separator + "data" + File.separator + string);
		try {
			strFile = Files.readString(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@When("attach it to the request body and post")
	public void attach_it_to_the_request_body_and_post() {

		String payload = strFile;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		response = httpRequest.body(payload).post(endPoint);
		int statusCode = response.getStatusCode();

	}

}
