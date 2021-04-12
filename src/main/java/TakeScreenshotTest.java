import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class TakeScreenshotTest {
	private WebDriver driver;

	// Use WebDriverManager Maven package to download the correct version of a driver to automate
	// Chrome browser. This method will run once before all of the tests in our class
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	//Set variable driver to an instance of ChromeDriver
	@Before
	public void setupTest() {
		driver = new ChromeDriver();
	}

	// quit session
	@After
	public void teardown() {
		if (driver != null) {
			driver.close();
		}
	}

	@Test
	// take screenshot and save as local file "screenshot.png"
	public void screenshotTest() throws IOException {
		driver.get("http://yingyao.codes");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./screenshot.png"));
	}
}

