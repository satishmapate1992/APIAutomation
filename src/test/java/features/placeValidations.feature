Feature: Validating Place API's
@AddPlace @Regression
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
 		Given Add Place Payload with "<name>" "<language>" "<address>"
 		When user calls "AddPlaceAPI" with "POST" http request
 		Then the API call got success with status code "200"
 		And "status" in response body is "OK"
 		And "scope" in response body is "APP"
 		And verify place_id created maps to "<name>" using "GetPlaceAPI"
 		 
Examples:
		|name 			|language 	|address 		| 		
		|XTown			|Telgo  		|Tamilnadu  |
#		|BTown			|Punjabi    |Noida		  |

@DeletePlace
Scenario: Verify if Delete Place functionality is working

		Given DeletePlace Payload
		When  user calls "DeletePlaceAPI" with "POST" http request
		Then the API call got success with status code "200"
		And "status" in response body is "OK"