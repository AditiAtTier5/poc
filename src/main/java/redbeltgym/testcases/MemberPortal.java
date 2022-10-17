package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class MemberPortal extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testCaseName = "check In for each member from member portal and verify from global attendance";
		testDescription = "Do check in for individual contact from member portal and verify from global attendance calendar day view";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "MemberPortal";
	}

	@Test(dataProvider = "fetchData")
	public void memberCheckIn(String uName, String pwd, String memberName) throws InterruptedException {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickSetup().clickGymDetails()
				.clickMemberPortalLink().enterAccessCode().clickVerify().enterName(memberName)
				.selectNameFromSuggestions().clickAttendance();

//		.verifyDataFRomMemberPOrtal()
	}
}
