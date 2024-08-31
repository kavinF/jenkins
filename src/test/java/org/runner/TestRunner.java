package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\kvkav\\workspace\\FaceBook\\src\\test\\resources\\Feature\\sample.feature", 
glue="org.steprunner", monochrome=false,dryRun=false, snippets=SnippetType.CAMELCASE,
plugin = {"json:target\\facebook.json"}
, tags="@tag2"
)
public class TestRunner {

	@AfterClass
	public static void reportName() {
		JVMReport.toGenerateReport("target\\facebook.json");
	}
}
