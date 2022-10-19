package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class PersonalDetailsPage extends BaseClass {

	@Then("The Personal Details dashboard will open")
	public PersonalDetailsPage verifyPersonalDetailsDashboard() throws InterruptedException {
		Thread.sleep(3000);
		String url = getDriver().getCurrentUrl();
		url.contains("personal-details");
		return this;
	}

	@Then("There at the left side auto populated personal details will be there")
	public PersonalDetailsPage fetchPersonalDetails() throws InterruptedException {
		Thread.sleep(5000);
		String personName = getDriver().findElement(By.xpath("//span[@class='profileNameDisplay']/span")).getText();
		String personEmail = getDriver().findElement(By.xpath("//div[@class='gymInfo full']/p[2]")).getText();
		System.out.println("Person Name: " + personName + ". Person Email: " + personEmail);
		return this;
	}

	@Then("There will be name {string} & email {string} about user")
	public PersonalDetailsPage verifyPersonalDetails(String name, String email) throws InterruptedException {
		Thread.sleep(5000);
		String personName = getDriver().findElement(By.xpath("//span[@class='profileNameDisplay']/span")).getText();
		String personEmail = getDriver().findElement(By.xpath("//div[@class='gymInfo full']/p[2]")).getText();
		System.out.println("Person Name: " + personName + ". Person Email: " + personEmail);
		assertEquals(personName, name);
		assertEquals(personEmail, email);
		return this;
	}

	@Then("I want to edit the personal details, edit name {string}")
	public PersonalDetailsPage editPersonalDetails(String editedName) throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//button[@class='editPersonalName']")).click();
		getDriver().findElement(By.xpath("//span[@class='profileNameDisplayEdits']/input")).clear();
		getDriver().findElement(By.xpath("//span[@class='profileNameDisplayEdits']/input")).sendKeys(editedName);
		getDriver().findElement(By.xpath("//button[@class='editPersonalNameSave']")).click();
		return this;
	}

	@Then("I want to edit the personal details, edit display picture {string}")
	public PersonalDetailsPage editDisplayPicture(String image) throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//button[@class='editPersonalName']")).click();
		getDriver().findElement(By.xpath("//span[@class='profileUpload']/input")).clear();
		getDriver().findElement(By.xpath("//span[@class='profileUpload']/input")).sendKeys(image);
		getDriver().findElement(By.xpath("//button[@class='editPersonalNameSave']")).click();
		return this;
	}

	@Then("In the right side there will be a section called Basic Settings")
	public PersonalDetailsPage basicDetails() throws InterruptedException {
		Thread.sleep(4000);
		String basicSettings = getDriver().findElement(By.xpath("//div[@class='holidayListHeader']/h3")).getText();
		assertEquals(basicSettings, "Basic Settings");
		return this;
	}

	@Then("In the right side there will be a section called Change Password")
	public PersonalDetailsPage changePasswordDetails() throws InterruptedException {
		Thread.sleep(4000);
		String changePassword = getDriver()
				.findElement(By.xpath("//div[@class=\"holidayListHeader\"]/following-sibling::form/div[2]/h3"))
				.getText();
		assertEquals(changePassword, "Change Password");
		return this;
	}

	@Then("I can view and edit country name as {string} information")
	public PersonalDetailsPage basicDetails(String countrySelect) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> countryOptions = getDriver().findElements(By.xpath("//select[@name='countryLists']/option"));
		for (int i = 2; i <= countryOptions.size(); i++) {
			String country = getDriver().findElement(By.xpath("//select[@name='countryLists']/option[" + i + "]"))
					.getText();
			if (country.equalsIgnoreCase(countrySelect)) {
				getDriver().findElement(By.xpath("//select[@name='countryLists']/option[" + i + "]")).click();
			}
		}
		return this;
	}

	@Then("There will be Three text box by which we can change the password, which are Current Password, New Password, Confirm New Password")
	public PersonalDetailsPage passwordChange() throws InterruptedException {
		Thread.sleep(2000);
		String currentPassword = getDriver().findElement(By.xpath("(//div[@class='detailsForm']/div/label)[2]"))
				.getText();
		String newPassword = getDriver().findElement(By.xpath("(//div[@class='detailsForm']/div/label)[3]")).getText();
		String confirmNewPassword = getDriver().findElement(By.xpath("(//div[@class='detailsForm']/div/label)[4]"))
				.getText();
		assertEquals(currentPassword, "Current Password");
		assertEquals(newPassword, "New Password");
		assertEquals(confirmNewPassword, "Confirm New Password");
		return this;
	}

	@Then("Need to fill up the field accordingly as Current Password {string}, New Password {string}, Confirm New Password {string}")
	public PersonalDetailsPage passwordFieldInsertData(String currentPwd, String newPwd, String confirmNewPwd)
			throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//div[@class='detailsForm']/div/input)[1]")).sendKeys(currentPwd);
		getDriver().findElement(By.xpath("(//div[@class='detailsForm']/div/input)[2]")).sendKeys(newPwd);
		getDriver().findElement(By.xpath("(//div[@class='detailsForm']/div/input)[3]")).sendKeys(confirmNewPwd);
		return this;
	}

	@Then("Click on save in the bottom")
	public PersonalDetailsPage clickSave() throws InterruptedException {
		getDriver().findElement(By.xpath("//button[@class='saveNnewBtn']")).click();
		return this;
	}

}