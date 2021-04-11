import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmilySelenimuTest {
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
	public void firstTest(){
		// Initialise & set path
		// System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		// driver = new ChromeDriver();

		// 2. Navigation
		// driver.get("http://yingyao.codes/");
		driver.navigate().to("https://emilylu123.github.io");
		driver.navigate().refresh();
		// driver.navigate().forward();
		// String title = driver.getTitle();

		// String url = driver.getCurrentUrl();
		// driver.findElement(By.className("fa-github")).click();

		// 3. Find element
		// 4. check the state
		// wait 10 seconds
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement githubIcon = wait.until(ExpectedConditions.elementToBeClickable(By.className(
				"fa-github")));
		// 5. take action
		// 6. record the result
		githubIcon.click();
		// assertTrue(githubIcon.isDisplayed());
		// System.out.println(title);

		// driver.quit();
	}
}
