package ApplicationDataTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions( features = "src/test/resources/features" ,
glue = "ApplicationDataTest",
tags = {},
		
plugin = {"pretty:reports/cucumber-pretty-report/cucumber-pretty.txt",
"html:reports/cucumber-html-report",
 "json:reports/cucumber-usage-report/cucumber-usage.json",
 "junit:report/cucumber-junit-report/cucumber.xml"
}
		)
public class RunnerTest {
		
}