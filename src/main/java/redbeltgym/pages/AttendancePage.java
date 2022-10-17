package redbeltgym.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class AttendancePage extends ProjectSpecificMethods {
	public AttendancePage(RemoteWebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	public AttendancePage selectDate() {
		String beforeXpath = "//*[@id='root']/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/div/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[";
		String afterXpath = "]/td[";
		String lastXpath = "]";
		int totalWeekDays = 7;
		boolean stopLoop = false;

		for (int rowNum = 1; rowNum < totalWeekDays && !stopLoop; rowNum++) {

			for (int columnNum = 1; columnNum <= totalWeekDays && !stopLoop; columnNum++) {

				String path = beforeXpath + rowNum + afterXpath + columnNum + lastXpath;

				String daysValue = (locateElement("xpath", "" + path)).getAttribute("data-date");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String todayDate = dateFormat.format(date);

				if (daysValue.equalsIgnoreCase(todayDate)) {
					click(locateElement("xpath", "" + path + "/div/div/a"));

					List<WebElement> listOptions = locateElements("xpath",
							"//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/div/div/table/tbody/tr");

					String attendesFirstXpath = "//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/div/div/table/tbody/tr[";
					String attendesLastXpath = "]/td[3]/span";
					String attendeesNameToCheckIn = ContactPage.attendeesName;

					if (listOptions.size() > 0) {
						for (int i = 2; i <= listOptions.size(); i++) {
							String attendeeFullName = getElementText(
									locateElement("xpath", "" + attendesFirstXpath + i + attendesLastXpath));
//							System.out.println("   attendeesNameToCheckIn: " + attendeesNameToCheckIn
//									+ "  attendeeFullName: " + attendeeFullName);
							if (attendeesNameToCheckIn.equals(attendeeFullName)) {
								List<String> timees = ContactPage.getCheckinDetails();
//								System.out.println("Global checkin Day: " + timees.get(0));
//								System.out.println("Global checkin time: " + timees.get(1));
//								System.out.println("Global checkin By: " + timees.get(2));

								reportStep(attendeesNameToCheckIn + " has checked in at " + timees.get(1) + " on "
										+ timees.get(0) + " by " + timees.get(2) + " and " + attendeeFullName
										+ " is showing in global attendance calendar", "pass");
								stopLoop = true;
							}
						}
					} else {
						reportStep(
								attendeesNameToCheckIn
										+ " has checked in but not showing in global attendance calendar day view ",
								"fail");
					}

				}

			}

		}

		return this;
	}

	public AttendancePage verifyDataFRomMemberPOrtal() {
		String beforeXpath = "//*[@id='root']/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/div/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[";
		String afterXpath = "]/td[";
		String lastXpath = "]";
		int totalWeekDays = 7;
		boolean stopLoop = false;

		for (int rowNum = 1; rowNum < totalWeekDays && !stopLoop; rowNum++) {

			for (int columnNum = 1; columnNum <= totalWeekDays && !stopLoop; columnNum++) {

				String path = beforeXpath + rowNum + afterXpath + columnNum + lastXpath;

				String daysValue = (locateElement("xpath", "" + path)).getAttribute("data-date");
				System.out.println("daysValue: " + daysValue);
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String todayDate = dateFormat.format(date);
				System.out.println("todayDate: " + todayDate);

				if (daysValue.equalsIgnoreCase(todayDate)) {
					click(locateElement("xpath", "" + path + "/div/div/a"));

					List<WebElement> listOptions = locateElements("xpath",
							"//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/div/div/table/tbody/tr");
					System.out.println("list size: " + listOptions.size());
					String attendeesNameToCheckIn = CheckInPortalPage.membersName;
					System.out.println("attendeesNameToCheckIn: " + attendeesNameToCheckIn);

					if (listOptions.size() > 0) {
						for (int i = 2; i <= listOptions.size(); i++) {
							String attendesFirstXpath = "//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/div/div/table/tbody/tr[";
							String attendesLastXpath = "]/td[3]/span[1]";
							System.out.println("xpath: " + attendesFirstXpath + i + attendesLastXpath);
							String attendeeFullName = (locateElement("xpath",
									"" + attendesFirstXpath + i + attendesLastXpath)).getText();
							System.out.println("attendeeFullName: " + attendeeFullName);
							if (attendeesNameToCheckIn.equals(attendeeFullName)) {
								reportStep(
										attendeesNameToCheckIn + " has checked in from member login tab and "
												+ attendeeFullName + " is showing in global attendance calendar",
										"pass");
								stopLoop = true;
							}
						}
					} else {
						reportStep(attendeesNameToCheckIn
								+ " has checked in from member login tab but it is not showing in global attendance calendar day view ",
								"fail");
					}

				}

			}

		}

		return this;
	}

}