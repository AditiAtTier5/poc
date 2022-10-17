package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class StatusAndPhase extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "status and phase page open";
		testDescription = "Status and phase page should open";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "StatusAndPhase";
	}

	@Test(dataProvider = "fetchData")
	public void statusPhase(String uName, String pwd, String statusAndPhaseUrl) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().verifyStatusAndPhasePage(statusAndPhaseUrl);
	}

}