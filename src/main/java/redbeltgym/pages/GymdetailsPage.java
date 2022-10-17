package redbeltgym.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class GymdetailsPage extends ProjectSpecificMethods {

	public GymdetailsPage(RemoteWebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;

	}

	private static List<String> tabs = null;

	public static List<String> getTabs() {
		return tabs;
	}

	public CheckInPortalPage clickMemberPortalLink() throws InterruptedException {
		Thread.sleep(3000);
		WebElement copyButton = locateElement("xpath", "(//button[@class='copy_button'])[1]");
		click(copyButton);
		WebElement clickPortalURL = locateElement("xpath", "//div[@class='copy_url_gen']/span/button");
		click(clickPortalURL);
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		tabs = allTabs;
		System.out.println("tabs: " + tabs);
		return new CheckInPortalPage(driver, node);
	}

}
