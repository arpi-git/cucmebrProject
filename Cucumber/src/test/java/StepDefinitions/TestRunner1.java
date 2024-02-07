package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





	@RunWith(Cucumber.class)

	@CucumberOptions(features = "src/test/resources/Features", glue = {"StepDefinitions"}, monochrome = true,

	        plugin = {"pretty", "html:target/cucumber-reports/TestReport.html",

	                "json:target/cucumber-reports/TestReport.json",

	                "junit:target/cucumber-reports/TestReport.xml"},

	        tags = "@test1",

	        dryRun=false

	 

	)

	public class TestRunner1 {

	 

	}

