package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC012 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC012";
		testDescription = "Edit existing Status";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC012";
	}

	@Test(dataProvider = "fetchData")
	public void testDetails(String uName, String pwd, String StatusName, String statusDes, String msg) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().editStatusName(StatusName, statusDes).verifyAddedPhase(msg);
	}

}
