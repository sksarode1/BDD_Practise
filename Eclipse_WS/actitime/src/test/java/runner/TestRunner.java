package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature/printsearchresults.feature",
		glue = {"stepdefinition"},
		dryRun = false,
		plugin = {"pretty","junit:target/junitreports/report.xml",
							"html:target/htmlreports/report.html",
							"json:target/jsonreports/report.json"})
public class TestRunner {

}