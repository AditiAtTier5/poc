package redbeltgym.testng.api.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import redbeltgym.selenium.api.base.SeleniumBase;
import utils.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

	public String dataSheetName;

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = startApp("chrome", "https://dev.redbeltgym.com");
		node = test.createNode(testCaseName);
	}

	@AfterMethod
	public void afterMethod() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		close();
	}

}
