package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//					tags = "@api-test1 or @api-test2 or @api-test2.1",
					tags = "@test1",
					features = "src/test/resources/features",
					glue = "stepDefinitions",
					dryRun = false,
					monochrome = true,
					publish = true,
					plugin = {
								"summary", "pretty",
								"html:target/cucumber-reports/TestReport.html",
								"json:target/cucumber-reports/TestReport.json",
								"junit:target/cucumber-reports/TestReport.xml",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							}		
				)

public class testRunner{

}
