package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class SMS extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {

		testCaseName = "Sms send";
		testDescription = "send sms";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "smssend";
	}

	@Test(dataProvider = "fetchData")
	public void sendSMS(String uName, String pwd, String callorsms, String prefix, String number, String text) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickCallOrSMS(callorsms)
				.sendPrefixOfNumber(prefix).sendNumber(number).enterTextandSend(text);
	}

}
