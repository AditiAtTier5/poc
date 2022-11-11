package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class DashboardPage extends BaseClass {

	@Then("Dashboard should be displayed")
	public DashboardPage dashboardURL() throws InterruptedException {
		Thread.sleep(6000);
		String url = getDriver().getCurrentUrl();
		url.contains("dashboard");
		return this;
	}

	@Then("Click on the setup menu which is in the top right side")
	public DashboardPage clicksetup() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//div[@class='dashboardHeader']/button)[1]")).click();
		return this;
	}

	@Then("There will be one option named {string}, need to click on that")
	public PersonalDetailsPage clickOption(String optionName) throws InterruptedException {
		boolean stopOptionLoop = false;
		int attempts = 0;
		if (!stopOptionLoop && attempts < 2) {

			try {
				List<WebElement> options = getDriver().findElements(By.xpath("//div[@class='listHead']/div/h3/a"));
				for (WebElement option : options) {
					String optionText = option.getText();
					if (optionName.equals(optionText)) {
						option.click();
					}

				}
			} catch (StaleElementReferenceException e) {
			}
			attempts++;

		}

		return new PersonalDetailsPage();
	}

	@Then("Click on Email Templates")
	public EmailTemplatePage clickEmailTemplates() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//a[@href='/email-template']")).click();
		return new EmailTemplatePage();
	}

}
