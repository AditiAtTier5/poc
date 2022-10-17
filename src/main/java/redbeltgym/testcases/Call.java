package redbeltgym.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class Call extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {

		testCaseName = "Make Call";
		testDescription = "Make Call";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "makeCall";

	}

	@Test(dataProvider = "fetchData")
	public void logInFail(String uName, String pwd, String callorsms, String prefix, String number) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickCallOrSMS(callorsms)
				.sendPrefixOfNumber(prefix).sendNumber(number).makeCall();
	}

}