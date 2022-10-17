package redbeltgym.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class CheckInPortalPage extends ProjectSpecificMethods {

	public CheckInPortalPage(RemoteWebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	static String membersName = "";

	public CheckInPortalPage enterAccessCode() {
		try {
			Thread.sleep(3000);
			locateElement("xpath", "//form[@id='gymOwnerLoginForm']/input").sendKeys(Keys.chord(Keys.CONTROL, "v"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return this;
	}

	public CheckInPortalPage clickVerify() {
		try {
			Thread.sleep(3000);
			click(locateElement("xpath", "//button[@id='submitOtpBtns']"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return this;
	}

	public CheckInPortalPage enterName(String data) {
		WebElement enterNamePlace = locateElement("xpath", "//div[@id='inputNameWraperId']/input");
		append(enterNamePlace, data);
		membersName = data;
		return this;
	}

	public DashboardPage selectNameFromSuggestions() {
		try {
			Thread.sleep(2000);
			List<String> tabs = GymdetailsPage.getTabs();
			WebElement selectFromSuggestions = locateElement("xpath",
					"//ul[@class='autoSuggestListing']/li/span[2]/span");
			System.out.println(selectFromSuggestions.getText());
			click(selectFromSuggestions);
			Thread.sleep(2000);
			String checkText = locateElement("xpath", "//span[@class='leftSec show']").getText();
			if (checkText == "Check-In") {
				click(locateElement("xpath", "//span[@class='leftSec show']"));
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(tabs.get(0));
			} else if (checkText == "Checked In") {
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(tabs.get(0));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return new DashboardPage(driver, node);
	}

}