package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;
import io.cucumber.java.en.Then;

public class EmailTemplatePage extends BaseClass {

	@Then("Email Template page should be displayed")
	public EmailTemplatePage emailTemplatePageURL() throws InterruptedException {
		Thread.sleep(3000);
		String url = getDriver().getCurrentUrl();
		url.contains("email-template");
		return this;
	}

	@Then("Click on Create an Email Template button")
	public EmailTemplatePage createEmailTemplate() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[text()='Create an Email Template']")).click();
		return this;
	}

	@Then("Enter Title {string}")
	public EmailTemplatePage enterTitle(String title) throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//label[text()='Title']/following::input")).sendKeys(title);
		return this;
	}

	@Then("Enter Subject {string}")
	public EmailTemplatePage enterSubject(String subject) throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//label[text()='Subject']/following::input")).sendKeys(subject);
		getDriver().findElement(By.xpath("//button[@class='btn browseKeywords']")).click();
		List<WebElement> keywordList = getDriver().findElements(By.xpath("//div[@class='keywordList']/ul/li"));
		for (int i = 1; i <= keywordList.size(); i++) {
			Actions act = new Actions(getDriver());
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(500);
			System.out.println("Options: " + getDriver()
					.findElement(By.xpath("//div[@class='keywordList']/ul/li[" + i + "]/button")).getText());
			getDriver().findElement(By.xpath("//div[@class='keywordList']/ul/li[" + i + "]/button")).click();

		}
		getDriver().findElement(By.xpath("//div[@class='cancelKeySearch']//button[1]")).click();
		return this;
	}

	@Then("Enter Message {string}")
	public EmailTemplatePage enterMessage(String message) throws InterruptedException {
		Thread.sleep(3000);
		getDriver().switchTo().frame(0);
		getDriver().findElement(By.xpath("//body[@id='tinymce']")).sendKeys(message);
		getDriver().switchTo().parentFrame();
		Actions act1 = new Actions(getDriver());
		act1.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//div[@class='createEmailButtons']/button[1]")).click();
		List<WebElement> keywordList = getDriver().findElements(By.xpath("//div[@class='keywordList']/ul/li"));
		for (int i = 1; i <= keywordList.size(); i++) {
			Actions act2 = new Actions(getDriver());
			act2.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(500);
			getDriver().findElement(By.xpath("//div[@class='keywordList']/ul/li[" + i + "]/button")).click();
			System.out.println(
					getDriver().findElement(By.xpath("//div[@class='keywordList']/ul/li[" + i + "]/button")).getText());

		}
		return this;
	}

	@Then("Click on Save")
	public EmailTemplatePage clickSave() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//button[text()='Save ']")).click();
		return this;
	}

	@Then("Click on Option dropdown select Email")
	public EmailTemplatePage clickEmail() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//button[@class='listDropBtn']//img[1]")).click();
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//input[@value='email']")).click();
		return this;
	}

	@Then("Enter Email ID {string} to send an Email")
	public EmailTemplatePage enterEmailID(String emailID) throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys(emailID);

		return this;
	}

	@Then("Select from template")
	public EmailTemplatePage selectTEmplate() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//div[@class='cmnFieldStyle btnSelect']")).click();
		getDriver().findElement(By.xpath("//ul[@class='showTemplateName']//li[1]")).click();
		return this;
	}

	@Then("Click on Send Email")
	public EmailTemplatePage sendEmai() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//button[text()='Send Email ']")).click();
		return this;
	}

}
