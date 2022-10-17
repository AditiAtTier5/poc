package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC005 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC005";
		testDescription = "Delete a phase which does not have any status assigned";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC005";
	}

	@Test(dataProvider = "fetchData")
	public void deletePhase(String uName, String pwd, String msg) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().deletePhaseNoStatus().verifyAddedPhase(msg);
	}

}