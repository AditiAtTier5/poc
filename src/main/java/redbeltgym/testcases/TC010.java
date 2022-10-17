package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class TC010 extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "TC010";
		testDescription = "After adding one status the number will be increased and the total number of status i should be able to see beside the respective phase name";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "TC010";
	}

	@Test(dataProvider = "fetchData")
	public void testDetails(String uName, String pwd, String statusName, String statusDes) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup()
				.clickStatusAndPhase().getStatusCountInsidePhase(statusName, statusDes);
	}

}
