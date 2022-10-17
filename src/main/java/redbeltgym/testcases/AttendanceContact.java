package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class AttendanceContact extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testCaseName = "check In for each member from contact modal and verify from global attendance";
		testDescription = "Do check in for individual contact from contacts modal and verify from global attendance calendar day view";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "AttendanceContact";
	}

	@Test(dataProvider = "fetchData")
	public void logInPass(String uName, String pwd, String nameOfContact) throws InterruptedException {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin().clickContacts()
				.searchContacts(nameOfContact).clickContactName().clickAttendanceModal().clickClockIn()
				.clickAttendance().selectDate();
	}
}
