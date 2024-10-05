package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)  // run complete test with cucumber junit runner
@CucumberOptions(
					features = "src/test/java/features", 
					plugin="json:target/jsonReports/cucumber_report.json", 
					glue = {"stepDefinations"}
//					tags = "@AddPlace"
				)
public class TestRunner {

	// after run  TestRunner class will get step defination methods. 
}
