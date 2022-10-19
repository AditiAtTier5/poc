package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends AbstractTestNGCucumberTests {

	private static final ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<RemoteWebDriver>();

	public void setDriver(RemoteWebDriver driver) {
		tlDriver.set(driver);
	}

	public RemoteWebDriver getDriver() {
		return tlDriver.get();
	}

	public String fileName;

	public static Properties prop1;

	@BeforeMethod
	public void preCondition() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(new File("./src/main/resources/config.properties"));
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
		setDriver(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String lang = prop.getProperty("language");

		prop1 = new Properties();
		FileInputStream fis1 = new FileInputStream(new File("./src/main/resources/" + lang + ".properties"));
		prop1.load(fis1);
	}

	@AfterMethod
	public void postCondition() throws InterruptedException {
		Thread.sleep(8000);
		getDriver().close();
	}
}
