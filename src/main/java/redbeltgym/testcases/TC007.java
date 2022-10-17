package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC007 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC007";
		testDescription = "Add a Status while there are existing phases ";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC007";
	}

	@Test(dataProvider = "fetchData")
	public void addStatus(String uName, String pwd, String statusName, String statusDes, String msg) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().addStatus(statusName, statusDes).verifyAddedPhase(msg);
	}

}
