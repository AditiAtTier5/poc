package testcases;

import org.testng.annotations.DataProvider;
import base.BaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/stepdefinitions/PersonalDetails.feature", glue = "pages", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true)
public class Runner extends BaseClass {

	@DataProvider(parallel = false)
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
