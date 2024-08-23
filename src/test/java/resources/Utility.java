package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {

	public static RequestSpecification requestSpec;

	public static RequestSpecification requestSpecification() throws IOException {

		if (requestSpec == null) {
			PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
			requestSpec = new RequestSpecBuilder().setBaseUri(getGlobalVariableFromPropertyFile("baseurl")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			// return requestSpec;
		}
		return requestSpec;
	}

	public static String getGlobalVariableFromPropertyFile(String Property_File_Key) throws IOException {

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/PropertyFile.properties");
		prop.load(file);
		return (String) prop.get(Property_File_Key);

	}
	
	public static String rawToJson(String response, String key) {

		return new JsonPath(response).getString(key); // for parsing json
		
	}

	public static String readFromJsonFile(String FilePath) throws IOException {

		return new String(Files.readAllBytes(Paths.get(FilePath)));

	}
	
	public static String getJsonPath(Response response, String field) {

		 return new JsonPath(response.asString()).getString(field); // for parsing json
	
	}
}
