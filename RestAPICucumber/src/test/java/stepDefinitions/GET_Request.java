package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request {
	
	RequestSpecification httpRequest;
	Response response;
	
	
	@Given("^Set GET data service api endpoint$")
	public void set_GET_data_service_api_endpoint() throws Throwable {
		//Specify the baseURI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";		
		//Request Object
		httpRequest=RestAssured.given();		
	
	}

	@When("^User want to get information on the project$")
	public void user_want_to_get_information_on_the_project() throws Throwable {
		//Response Object
		response = httpRequest.request(Method.GET,"/Hyderabad");
	}
	


	@Then("^the requested data is returned$")
	public void the_requested_data_is_returned() throws Throwable {
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		Assert.assertTrue(responseBody!=null,"Response has not data");
	}
	
	
	@Then("^user receives a success status$")
	public void receives_a_get_response() throws Throwable {
		int StatusCode = response.getStatusCode();
		System.out.println("StausCode is : "+ StatusCode);
		Assert.assertEquals(StatusCode, 200);
	}
}
