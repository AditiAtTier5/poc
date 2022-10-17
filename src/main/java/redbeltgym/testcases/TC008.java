package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC008 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC008";
		testDescription = "Add a Status while there is no phase added";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC008";
	}

	@Test(dataProvider = "fetchData", priority = 3)
	public void addStatusWithNoPhase(String uName, String pwd, String msg) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().addStatusNoPhase().verifyAddedPhase(msg);
	}

}
