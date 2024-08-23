package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public static AddPlace addPlacePayload(String name, String language, String address) {

		AddPlace p = new AddPlace();
		p.setAccuracy(90);
		p.setName(name);
		p.setPhone_number("8899889900");
		p.setAddress(address);
		p.setWebsite("www.rahulsheety.com");
		p.setLanguage(language);
		List<String> type = new ArrayList<String>();
		type.add("Aus");
		type.add("Nuz");
		p.setType(type);

		Location l = new Location();
		l.setLat(-34.3444);
		l.setLng(12.222);
		p.setLocation(l);

		return p;
	}
	
	public static String deletePayload(String place_Id) {
		
		return "{\r\n"
				+ "    \"place_id\":\""+place_Id+"\"\r\n"
				+ "}\r\n"
				+ "";
	}

}
