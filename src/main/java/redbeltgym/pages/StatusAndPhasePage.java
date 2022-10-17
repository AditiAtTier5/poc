package redbeltgym.pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import redbeltgym.testng.api.base.ProjectSpecificMethods;

public class StatusAndPhasePage extends ProjectSpecificMethods {

	public StatusAndPhasePage(RemoteWebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
	}

	public StatusAndPhasePage verifyStatusAndPhasePage(String data) {
		verifyUrlContains(data);
		reportStep("Status and phase page opened", "pass");
		return this;
	}

	public StatusAndPhasePage enterPhaseName(String data) {
		clearAndType(locateElement("xpath", "//input[@name='phasesName']"), data);
		return this;
	}

	public StatusAndPhasePage addPhase() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement("xpath", "//button[@class='btn' and @type='submit']"));
		return this;
	}

	public StatusAndPhasePage verifyAddedPhase(String data) {
		try {
			Thread.sleep(3000);
			WebElement ele = locateElement("xpath", "//div[@class='rrt-text']");
			verifyPartialText(ele, data);
		} catch (Exception e) {
			reportStep("Element not found", "fail");
		}
		return this;
	}

	public StatusAndPhasePage editPhase() {
		try {
			click(locateElement("xpath", "(//button[@class='showList'])[1]"));
			click(locateElement("xpath", "//div[@class='dropdownOptions listOpen']/button[1]"));
		} catch (Exception e) {
			reportStep("Could not click on edit phase", "fail");
		}
		return this;
	}

	public StatusAndPhasePage deletePhaseHasStatus() {
		List<WebElement> allPhases = locateElements("xpath", "//ul[@class='ProCategoryListing']/li/button[1]");
		for (WebElement phase : allPhases) {
			String phaseName = phase.getText();
			Matcher m = Pattern.compile("\\((.*?)\\)").matcher(phaseName);
			if (m.find()) {
				int statusNo = Integer.parseInt(m.group(1));
				if (statusNo > 0) {
					click(phase);
					WebElement clickDot = phase.findElement(By.xpath("following-sibling::*[1]"));
					clickDot.click();
					WebElement clickDelete = clickDot.findElement(By.xpath("following-sibling::*[1]/button[2]"));
					clickDelete.click();
					click(locateElement("xpath", "//div[@class='alertBoxFooter']/button[2]"));
					return this;
				}
			}
		}
		return this;
	}

	public StatusAndPhasePage deletePhaseNoStatus() {
		List<WebElement> allPhases = locateElements("xpath", "//ul[@class='ProCategoryListing']/li/button[1]");
		for (WebElement phase : allPhases) {
			String phaseName = phase.getText();
			Matcher m = Pattern.compile("\\((.*?)\\)").matcher(phaseName);
			if (m.find()) {
				int statusNo = Integer.parseInt(m.group(1));
				if (statusNo == 0) {
					click(phase);
					WebElement clickDot = phase.findElement(By.xpath("following-sibling::*[1]"));
					clickDot.click();
					WebElement clickDelete = clickDot.findElement(By.xpath("following-sibling::*[1]/button[2]"));
					clickDelete.click();
					click(locateElement("xpath", "//div[@class='alertBoxFooter']/button[2]"));
					return this;
				} else if (statusNo > 0) {
					reportStep(
							"Present phase has " + statusNo + " status. Please delete all status of this phase first.",
							"fail");
				}
			}
		}
		return this;
	}

	public StatusAndPhasePage addStatusNoPhase() {
		try {
			Thread.sleep(1000);
			click(locateElement("xpath", "//button[@class='creatUserBtn']"));
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", locateElement("xpath", "//button[@class='creatUserBtn']"));
		}
		return this;
	}

	public StatusAndPhasePage addStatus(String data1, String data2) {
		try {
			Thread.sleep(2000);
			click(locateElement("xpath", "//button[@class='creatUserBtn']"));
			clearAndType(locateElement("xpath", "//div[@class='formControl']/input"), data1);
			clearAndType(locateElement("xpath", "//div[@class='formControl']/textarea"), data2);
			click(locateElement("xpath", "(//button[@type='submit'])[2]"));
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", locateElement("xpath", "//button[@class='creatUserBtn']"));
			executor.executeScript("arguments[0].click();", locateElement("xpath", "(//button[@type='submit'])[2]"));
		}
		return this;
	}

	public StatusAndPhasePage getStatusCountInsidePhase(String data1, String data2) {
		WebElement phase = locateElement("xpath", "(//ul[@class='ProCategoryListing']/li/button)[1]");
		String phaseName = phase.getText();
		Matcher m = Pattern.compile("\\((.*?)\\)").matcher(phaseName);
		if (m.find()) {
			int statusNo = Integer.parseInt(m.group(1));
			try {
				Thread.sleep(2000);
				click(locateElement("xpath", "//button[@class='creatUserBtn']"));
				clearAndType(locateElement("xpath", "//div[@class='formControl']/input"), data1);
				clearAndType(locateElement("xpath", "//div[@class='formControl']/textarea"), data2);
				click(locateElement("xpath", "(//button[@type='submit'])[2]"));
			} catch (Exception e) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();",
						locateElement("xpath", "//button[@class='creatUserBtn']"));
				executor.executeScript("arguments[0].click();",
						locateElement("xpath", "(//button[@type='submit'])[2]"));
			}
			try {
				Thread.sleep(2000);
				WebElement newPhase = locateElement("xpath", "(//ul[@class='ProCategoryListing']/li/button)[1]");
				String newPhaseName = newPhase.getText();
				Matcher newM = Pattern.compile("\\((.*?)\\)").matcher(newPhaseName);
				if (newM.find()) {
					int newStatusNo = Integer.parseInt(newM.group(1));
					if (statusNo + 1 == newStatusNo) {
						reportStep("Inside " + newPhaseName + " there was " + statusNo + " status. After adding "
								+ data1 + " status, total number of status become " + newStatusNo, "pass");
					} else {
						reportStep("Number of status didn't get increased", "fail");
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return this;
	}

	public StatusAndPhasePage editStatusName(String data1, String data2) {
		List<WebElement> allPhases = locateElements("xpath", "//ul[@class='ProCategoryListing']/li/button[1]");
		for (WebElement phase : allPhases) {
			String phaseName = phase.getText();
			Matcher m = Pattern.compile("\\((.*?)\\)").matcher(phaseName);
			if (m.find()) {
				int statusNo = Integer.parseInt(m.group(1));
				if (statusNo > 0) {
					click(phase);
					click(locateElement("xpath", "(//div[@class='info_3dot_icon']/button)[1]"));
					click(locateElement("xpath",
							"//div[@class='dropdownOptions status listOpen']/button[@class='btn btnEdit']"));
					clearAndType(locateElement("xpath", "//div[@class='formControl']/input"), data1);
					clearAndType(locateElement("xpath", "//div[@class='formControl']/textarea"), data2);
					try {
						click(locateElement("xpath", "//div[@class='modalbtnHolder']/button[@type='submit']"));
					} catch (Exception e) {
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();",
								locateElement("xpath", "(//button[@type='submit'])[2]"));
					}
					return this;
				}
			}
		}
		return this;
	}

}
