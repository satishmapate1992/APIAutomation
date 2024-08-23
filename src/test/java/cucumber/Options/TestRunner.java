package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = "src/test/java/features", 
					plugin="json:target/jsonReports/cucumber_report.json", 
					glue = {"stepDefinations"}
//					tags = "@AddPlace"
				)
public class TestRunner {

	
}
