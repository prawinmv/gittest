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

public class PUT_Request {
	
	RequestSpecification httpRequest;
	Response response;
	
	@Given("^Set PUT data service api endpoint$")
	public void set_PUT_data_service_api_endpoint() throws Throwable {
		RestAssured.baseURI = "http://localhost:3000";
		//Request Object
		httpRequest=RestAssured.given();
	}

	@When("^User updates existing record in a project$")
	public void user_updates_existing_record_in_a_project() throws Throwable {
		JSONObject map=new JSONObject();
		map.put("id","7");		
		map.put("first_name","Scott1");
		map.put("last_name", "Weyland1");		
		map.put("email","scott.weyland1@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(map.toJSONString());
		
		//Response Object
		response = httpRequest.request(Method.PUT,"/employees");
	}
	
	@Then("^receives a valid status$")
	public void receives_a_put_response() throws Throwable {
		int StatusCode = response.getStatusCode();
		System.out.println("StausCode is : "+ StatusCode);
		Assert.assertEquals(StatusCode, 200);
	}

}
