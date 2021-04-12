import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeSearchTest {
	private String searchKey = "lofi hiphop";
	// private String searchKey = "new movie trailers";
	private WebElement element;

	@Test
	public void smarterTest() throws InterruptedException {
		//Use WebDriverManager Maven package to download the correct version of
		//a driver to automate Chrome browser
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		//Set variable driver to an instance of ChromeDriver
		WebDriver driver = new ChromeDriver();
		//Open the URL
		driver.get("https://www.youtube.com/");
		//Assert that the title of the page = Swag Labs
		assertEquals("YouTube", driver.getTitle());

		// enter search keywords in the inputs
		element = driver.findElement(By.id("search"));
		element.sendKeys(searchKey);

		// enter search result
		element = driver.findElement(By.id("search-icon-legacy"));
		element.click();

		// click first video
		element = driver.findElement(By.id("thumbnail"));
		element.click();

		Thread.sleep(8000);
		boolean isSkip = driver.findElements(By.className("ytp-ad-skip-button-container")).size() > 0;
		if (isSkip) {
			WebElement skipBtn = driver.findElement(By.className("ytp-ad-skip-button-container"));
			skipBtn.click();
			System.out.println("Ads skipped");
		} else System.out.println("No ads to skip");

		Thread.sleep(10000);

		//Quit the browser
		driver.quit();
	}
}
