package stepDefinitions;

import org.json.simple.JSONObject;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_Request {
	RequestSpecification httpRequest;
	Response response;
	
	
	
	@Given("^Set POST data service api endpoint$")
	public void set_POST_data_service_api_endpoint() throws Throwable {
		RestAssured.baseURI = "http://localhost:3000";
		//Request Object
		httpRequest=RestAssured.given();
	}

	@When("^User upload data on a project$")
	public void user_upload_data_on_a_project() throws Throwable {
		JSONObject map=new JSONObject();
		map.put("id","7");		
		map.put("first_name","Scott");
		map.put("last_name", "Weyland");		
		map.put("email","scott.weyland@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(map.toJSONString());
		
		//Response Object
		response = httpRequest.request(Method.POST,"/employees");
		
	}

	@Then("^the server should handle it$")
	public void the_server_should_handle_it() throws Throwable {
				
		String responseBody=response.getBody().asString();
		System.out.println("responseBody --->" + responseBody);
		
}
	
	@Then("^return a success status$")
	public void return_a_post_response() throws Throwable {
		int StatusCode = response.getStatusCode();
		System.out.println("StausCode is : "+ StatusCode);
		Assert.assertEquals(StatusCode, 201);
	}
}
