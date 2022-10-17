package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC004 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC004";
		testDescription = "Edit a Phase with same Phase Name which is already existing";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC004";
	}

	@Test(dataProvider = "fetchData")
	public void editPhaseExisting(String uName, String pwd, String phName, String msg) throws InterruptedException {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().editPhase().enterPhaseName(phName).addPhase().verifyAddedPhase(msg);
	}

}