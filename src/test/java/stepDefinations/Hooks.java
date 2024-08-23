package stepDefinations;

import java.io.IOException;

import org.junit.BeforeClass;

import io.cucumber.java.*;

public class Hooks {
		 
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
	
		// write a a code that will give you place id
		// execute this code only when place id in null
		
		StepDefination m = new StepDefination();
		if(StepDefination.place_id==null) {
		m.add_place_payload_with("Jackson", "Dutch", "USA");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("Jackson","GetPlaceAPI");
		}
		System.out.println("git");
	}

}
