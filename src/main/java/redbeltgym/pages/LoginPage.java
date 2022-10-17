package redbeltgym.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage(RemoteWebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;

	}

	public LoginPage enterUserName(String data) {
		clearAndType(locateElement("name", "email"), data);
		return this;
	}

	public LoginPage enterPassword(String data) {
		clearAndType(locateElement("name", "password"), data);
		return this;
	}

	public DashboardPage clickLogin() {
		click(locateElement("xpath", "//button[@class='btn orangeBtn']"));
		return new DashboardPage(driver, node);
	}

	public LoginPage clickLogInForFailer() {
		click(locateElement("xpath", "//button[@class='btn orangeBtn']"));
		return this;
	}

	public LoginPage verifyErrorMsg(String data) {
		verifyPartialText(locateElement("xpath", "//div[@class='popupMessage error']/p"), data);
		return this;
	}

}
