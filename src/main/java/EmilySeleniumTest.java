import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmilySeleniumTest {
	private WebDriver driver;
	private WebElement element;

	// Use WebDriverManager Maven package to download the correct version of a driver to automate
	// Chrome browser. This method will run once before all of the tests in our class
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	// 1. Initialise ChromeDriver
	@Before
	public void setupTest() {
		driver = new ChromeDriver();
	}

	// 7. quit session
	@After
	public void teardown() {
		if (driver != null) {
			driver.close();
		}
	}

	@Test
	public void emilyPortfolioTest(){
		// 2. Navigation
		// driver.get("http://yingyao.codes/");
		driver.navigate().to("https://emilylu123.github.io");

		// Test Github Link
		testLink();

		// Test contact form
		testContact();

		// Test thanks pages
		testThanksPage();
	}

	@Test
	// test Github link and go back
	public void testLink(){
		// 3. Find element
		element = driver.findElement(By.className("fa-github"));
		// 4. check the state
		assertTrue(element.isDisplayed());
		// 5. take action
		element.click();
		driver.navigate().back();
	}

	@Test
	// Fill in email and message and click submit btn
	public void testContact(){
		// Find, restore and act
		WebElement inputEmail = driver.findElement(By.id("contact-email"));
		inputEmail.sendKeys("test@gmail.com");

		WebElement inputMessage = driver.findElement(By.name("message"));
		inputMessage.sendKeys("Test: " + (int)(Math.random()*1000));

		// submit contact form
		WebElement btnSubmit = driver.findElement(By.id("btn-submit-form"));
		btnSubmit.submit();
	}

	@Test
	// test confirmation page
	public void testThanksPage(){
		// driver.get("https://formspree.io/thanks?language=zh");
		// select return message in the forwarded page
		element = driver.findElement(By.xpath("//h1/following-sibling::p"));
		System.out.println(element.toString());

		// check successful message
		assertTrue(element.getText().contains("successful"));
		// 6. record the result
		System.out.println(element.getText());
	}
}
