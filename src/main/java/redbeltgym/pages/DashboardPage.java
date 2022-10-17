package redbeltgym.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class DashboardPage extends ProjectSpecificMethods {

	public DashboardPage(RemoteWebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;

	}

	public DashboardPage verifyDashboardPage(String data) {
		try {
			Thread.sleep(6000);
			verifyUrlContains(data);
		} catch (Exception e) {
			System.out.println("Exception while verifying dashboard url " + e);
		}
		return this;
	}

	public ContactPage clickContacts() {
		click(locateElement("link", "Contacts"));
		return new ContactPage(driver, node);
	}

	public AttendancePage clickAttendance() {
		jsExecutor(locateElement("link", "Attendance"));
		return new AttendancePage(driver, node);
	}

	public DashboardPage clickSetup() {
		click(locateElement("xpath", "//button[@class='btn buttonHeaderIcons']"));
		return this;
	}

	public DashboardPage chatbotClose() {
		switchToFrame(0);
		click(locateElement("xpath", "(//div[@class='iticks-top-bar-button'])[1]"));
		defaultContent();
		return this;
	}

	public StatusAndPhasePage clickStatusAndPhase() {
		click(locateElement("xpath", "(//h3/a)[10]"));
		return new StatusAndPhasePage(driver, node);
	}

	public GymdetailsPage clickGymDetails() throws InterruptedException {
		Thread.sleep(5000);
		click(locateElement("xpath", "(//h3/a)[2]"));
		return new GymdetailsPage(driver, node);

	}

	public DashboardPage clickCallOrSMS(String operation) {
		click(locateElement("xpath", "//button[@class='listDropBtn']"));
		try {
			Thread.sleep(3000);
			boolean stopLoop = false;
			for (int i = 1; i <= 2 && !stopLoop; i++) {
				String callSms = locateElement("xpath", "//div[@class='leftBtnList']/ul/li[" + i + "]").getText();
				Thread.sleep(2000);
				if (callSms.equalsIgnoreCase(operation)) {
					click(locateElement("xpath", "//div[@class='leftBtnList']/ul/li[" + i + "]"));
					stopLoop = true;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public DashboardPage sendPrefixOfNumber(String prefix) {
		try {
			Thread.sleep(2000);
			WebElement prefixNumber = locateElement("xpath", "//select[@class='selectCountry']");
			selectDropDownUsingText(prefixNumber, prefix);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public DashboardPage sendNumber(String number) {
		try {
			Thread.sleep(2000);
			clearAndType(locateElement("xpath", "//div[@class='rightSide']/input"), number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public DashboardPage enterTextandSend(String text) {
		try {
			Thread.sleep(2000);
			locateElement("xpath", "//div[@class='cmnFormField']/textarea").sendKeys(text);
//			clearAndType(locateElement("xpath", "//div[@class='cmnFormField']/textarea"), text);
			Thread.sleep(2000);
			click(locateElement("xpath", "//button[@class='cmnBtn']"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public DashboardPage makeCall() {
		try {
			Thread.sleep(2000);
			click(locateElement("xpath", "//button[@class='makeAcallBtn']"));
			Thread.sleep(80000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

}
