package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC006 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC005";
		testDescription = "Delete phase which has assigned status";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC006";
	}

	@Test(dataProvider = "fetchData")
	public void deletePhaseAssign(String uName, String pwd, String msg) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().deletePhaseHasStatus().verifyAddedPhase(msg);
	}

}