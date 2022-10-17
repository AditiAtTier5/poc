package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC003 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC003";
		testDescription = "Edit existing phase";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC003";
	}

	@Test(dataProvider = "fetchData")
	public void editPhase(String uName, String pwd, String phName, String msg) throws InterruptedException {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().editPhase().enterPhaseName(phName).addPhase().verifyAddedPhase(msg);
	}

}