package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC009 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC009";
		testDescription = "Add more than one status with same name in a particular phase";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC009";
	}

	@Test(dataProvider = "fetchData")
	public void addMoreStatus(String uName, String pwd, String statusName, String statusDes, String msg) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().addStatus(statusName, statusDes).verifyAddedPhase(msg);
	}

}
