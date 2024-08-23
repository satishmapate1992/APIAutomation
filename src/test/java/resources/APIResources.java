package resources;

// enum is special class in java which has collection of constants and methods
// calling constructor does mean loading methods.
public enum APIResources {

	AddPlaceAPI("/maps/api/place/add/json"), 
	GetPlaceAPI("/maps/api/place/get/json"),
	PutPlaceAPI("/maps/api/place/update/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");

	private String resource;
	
	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
}
