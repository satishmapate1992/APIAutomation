package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utility;

public class StepDefination extends Utility {

	RequestSpecification res;
	ResponseSpecification responseSpec;
	Response response;
	static String place_id;

	TestDataBuild build = new TestDataBuild();

	@SuppressWarnings("static-access")
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		res = given().spec(requestSpecification()).body(build.addPlacePayload(name, language, address));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {

		// constructor will be called with value of resource which you pass
		APIResources resourceAPI = APIResources.valueOf(resource);
		String getResource = resourceAPI.getResource();
		System.out.println(getResource);

		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if (httpMethod.equalsIgnoreCase("POST"))
			response = res.when().post(getResource).then().spec(responseSpec).extract().response();
		else if (httpMethod.equalsIgnoreCase("GET"))
			response = res.when().get(getResource).then().spec(responseSpec).extract().response();
		else
			response = res.when().delete(getResource).then().spec(responseSpec).extract().response();

	}

	@Then("the API call got success with status code {string}")
	public void the_api_call_got_success_with_status_code(String string) {

		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {

		assertEquals(getJsonPath(response, key), value);

	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expecetdName, String resource) throws IOException {

		// request spec
		place_id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource,"GET");
		String actualName = getJsonPath(response,"name");
		assertEquals(actualName, expecetdName);
		
	}
	
	@SuppressWarnings("static-access")
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    
		res=given().spec(requestSpecification()).body(build.deletePayload(place_id));
		
	}

}
