package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC002 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC002";
		testDescription = "Add a Phase with same Phase Name which is already existing";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC002";
	}

	@Test(dataProvider = "fetchData")
	public void addPhaseExisting(String uName, String pwd, String phName, String msg) throws InterruptedException {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().enterPhaseName(phName).addPhase().verifyAddedPhase(msg);
	}

}