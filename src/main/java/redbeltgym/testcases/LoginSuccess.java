package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class LoginSuccess extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Login(Positive)";
		testDescription = "Login with valid username and password";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "LoginSuccess";
	}

	@Test(dataProvider = "fetchData")
	public void logInPass(String uName, String pwd, String dashboardUrl) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogin()
				.verifyDashboardPage(dashboardUrl);
	}

}
