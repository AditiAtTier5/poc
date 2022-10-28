package pages;

import org.openqa.selenium.By;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends BaseClass {

	@Given("Enter username as {string}")
	public LoginPage enterUserName(String uName) {
		getDriver().findElement(By.xpath("(//div[@class='inFormField']/input)[1]")).sendKeys(uName);
		return this;
	}

	@Given("Enter Password as {string}")
	public LoginPage enterPassword(String password) {
		getDriver().findElement(By.xpath("(//div[@class='inFormField']/input)[2]")).sendKeys(password);
		return this;
	}

	@When("Click on Login")
	public DashboardPage clickLogin() {
		// click on Login button
		getDriver().findElement(By.xpath("//div[@class='formInputs']/button")).click();
		return new DashboardPage();
	}

	@Then("This will be in Login page only")
	public LoginPage dashboardURL() throws InterruptedException {
		Thread.sleep(6000);
		String url = getDriver().getCurrentUrl();
		url.contains("login");
		return this;
	}
}
