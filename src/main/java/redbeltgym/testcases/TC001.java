package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC001 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC001";
		testDescription = "Add a Phase";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC001";
	}

	@Test(dataProvider = "fetchData")
	public void addPhases(String uName, String pwd, String phName, String msg) throws InterruptedException {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().enterPhaseName(phName).addPhase().verifyAddedPhase(msg);
	}

}