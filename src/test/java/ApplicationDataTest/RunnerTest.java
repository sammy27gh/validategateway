package ApplicationDataTest;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        toPDF = true,
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        outputFolder = "target/cucumber-reports/extended-report")


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