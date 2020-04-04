package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETE_Request {
	
RequestSpecification httpRequest;
Response response;
	
	@Given("^Set DELETE data service api endpoint$")
	public void set_DELETE_data_service_api_endpoint() throws Throwable {
		RestAssured.baseURI = "http://localhost:3000";
		//Request Object
		httpRequest=RestAssured.given();
	}

	@When("^User deletes an existing record in a project$")
	public void user_deletes_an_existing_record_in_a_project() throws Throwable {
		response = httpRequest.request(Method.DELETE,"/employees/7");	
	}


	@Then("^receives a delete status$")
	public void receives_a_delete_response() throws Throwable {
		int StatusCode = response.getStatusCode();
		System.out.println("StausCode is : "+ StatusCode);
		Assert.assertEquals(StatusCode, 200);
	}
}
