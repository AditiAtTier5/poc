package redbeltgym.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import redbeltgym.pages.LoginPage;
import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class LoginFailure extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {

		testCaseName = "Login(Negative)";
		testDescription = "Login with invalid username or password";
		nodes = "Leads";
		authors = "Aditi";
		category = "Smoke";
		dataSheetName = "LoginFailure";

	}

	@Test(dataProvider = "fetchData")
	public void logInFail(String uName, String pwd, String errMsg) {
		new LoginPage(driver, node).enterUserName(uName).enterPassword(pwd).clickLogInForFailer()
				.verifyErrorMsg(errMsg);
	}

}
