package redbeltgym.pages;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class ContactPage extends ProjectSpecificMethods {

	private static List<String> checkinDetails = null;

	public static List<String> getCheckinDetails() {
		return checkinDetails;
	}

	public ContactPage(RemoteWebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	static String attendeesName = "";

	public ContactPage searchContacts(String data) throws InterruptedException {
		clearAndType(locateElement("xpath", "//input[@type='search' and @name='search']"), data);
		attendeesName = data;
//		System.out.println("Name: " + attendeesName);

		WebElement searchIcon = locateElement("xpath", "//form/button[@class='searchIcon']");
		jsExecutor(searchIcon);
		return this;
	}

	public ContactPage clickContactName() throws InterruptedException {

		Thread.sleep(4000);
		List<WebElement> searchedContactsLists = locateElements("xpath",
				"//li[@class='listHeadingContacts']/following-sibling::*");

		for (int i = 1; i <= searchedContactsLists.size(); i++) {

			String name = getElementText(locateElement("xpath",
					"//li[@class='listHeadingContacts']/following-sibling::*[" + i + "]/div/button/span[2]"));
//			System.out.println("Name: " + name);
//			System.out.println("attendeesName: " + attendeesName);
			if (attendeesName.equalsIgnoreCase(name)) {
				System.out.println("Name: " + name);
				System.out.println("attendeesName: " + attendeesName);
//				System.out.println("//li[@class='listHeadingContacts']/following-sibling::*[" + i + "]/div/button");
				WebElement nameToClick = locateElement("xpath",
						"//li[@class='listHeadingContacts']/following-sibling::*[" + i + "]/div/button");
				Thread.sleep(4000);
				click(nameToClick);
			}

		}

		return this;
	}

	public ContactPage clickAttendanceModal() {
		System.out.println("attendance click");
		WebElement clickAttendance = locateElement("xpath", "//button[contains(text(), 'Attendance')]");
		jsExecutor(clickAttendance);
		System.out.println("attendance click successfull");
		return this;
	}

	public DashboardPage clickClockIn() throws InterruptedException {
		List<String> times = null;
		Thread.sleep(4000);
		String text = locateElement("xpath", "//div[@class='action']/button").getText();
		if (text.equals("Check In")) {
			jsExecutor(locateElement("xpath", "//button[contains(text(), ' Check In')]"));
			clickSave();
			times = checkInTime();
			System.out.println("checkin Day: " + times.get(0));
			System.out.println("checkin time: " + times.get(1));
			System.out.println("checkin By: " + times.get(2));
			reportStep(attendeesName + " has checked in at " + times.get(1) + " on " + times.get(0) + " by "
					+ times.get(2), "pass");

			closeContactModal();
		} else if (text.equals("Checked In")) {
			times = checkInTime();
			System.out.println("checkin Day: " + times.get(0));
			System.out.println("checkin time: " + times.get(1));
			System.out.println("checkin By: " + times.get(2));
			reportStep(attendeesName + " has already checked in at " + times.get(1) + " on " + times.get(0) + " by "
					+ times.get(2), "pass");

			closeContactModal();
		}
		checkinDetails = times;
		return new DashboardPage(driver, node);
	}

	public List<String> checkInTime() {
		DateFormat dateFormate = new SimpleDateFormat("E, dd");
		Date day = new Date();
		String OnlyDay = dateFormate.format(day);

		List<String> timeNames = new ArrayList<>();
		String daysXpath = "//span[@class='fc-list-dateTd']";

		List<WebElement> checkInTimes = locateElements("xpath", "" + daysXpath + "/following-sibling::*[1]/span");

		for (int i = 1; i <= checkInTimes.size(); i++) {

			String checkInTimeXpath = "(//span[@class='fc-list-dateTd']/following-sibling::*[1]/span)[";
			String checkInByXpath = "/parent::*[1]/following-sibling::*[2]";
			String checkInDays = "/parent::*[1]/preceding-sibling::*[1]";
			String checkDay = locateElement("xpath", "" + checkInTimeXpath + i + "]" + checkInDays).getText();

			if (OnlyDay.equals(checkDay)) {
//				System.out.println("only day: " + OnlyDay + "  checkDay: " + checkDay);
				String checkTime = locateElement("xpath", "" + checkInTimeXpath + i + "]").getText();
				String checkBy = locateElement("xpath", "" + checkInTimeXpath + i + "]" + checkInByXpath).getText();
//				System.out.println("check time: " + checkTime + "Check by: " + checkBy);
				timeNames.add(checkDay);
				timeNames.add(checkTime);
				timeNames.add(checkBy);
			}
		}
		return timeNames;
	}

	public ContactPage clickSave() {
		click(locateElement("xpath", "//span[contains(text(), 'Save')]//parent::button"));
//		System.out.println("clcik save is printing");
		return this;
	}

	public ContactPage closeContactModal() {
		click(locateElement("xpath", "//button[@class='closeModal']"));
		return this;
	}

}
