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

public class EmilySeleniumTest {
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
	public void emilyProfileTest(){
		// 2. Navigation
		// driver.get("http://yingyao.codes/");
		driver.navigate().to("https://emilylu123.github.io");

		// 3. Find element
		// 4. check the state
		// wait 10 seconds
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement githubIcon = wait.until(ExpectedConditions.elementToBeClickable(By.className(
				"fa-github")));
		// 5. take action
		// 6. record the result
		// test github link and go back
		githubIcon.click();
		driver.navigate().back();

		// Test contact form
		// fill in email and message and click submit btn
		WebElement inputEmail = driver.findElement(By.id("email"));
		inputEmail.sendKeys("emilylu@gmail.com");

		WebElement inputMessage = driver.findElement(By.name("message"));
		inputMessage.sendKeys("Test Test Test");

		WebElement btnSubmit = driver.findElement(By.className("btn-primary"));
		btnSubmit.submit();

		// assertTrue(githubIcon.isDisplayed());
		// System.out.println(title);
		// 7. quit session
		// driver.quit();
	}
}
