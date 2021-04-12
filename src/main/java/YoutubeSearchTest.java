import static org.junit.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class YoutubeSearchTest {
	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void skipAdsTest() throws InterruptedException {

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
		WebElement element = driver.findElement(By.id("search"));
		// private String searchKey = "lofi hiphop";
		String searchKey = "music 2021";
		element.sendKeys(searchKey);

		// enter search result
		element = driver.findElement(By.id("search-icon-legacy"));
		element.click();
		Thread.sleep(1500);

		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("thumbnail")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container" + "'][@class='style-scope ytd-search']")));
		// click on the first video as soon as it is visible
		WebElement container = driver.findElement(By.xpath("//div[@id='container" + "'][@class='style-scope ytd-search']"));
		List<WebElement> elements = container.findElements(By.id("thumbnail"));
		elements.get(3).click();

		Thread.sleep(8000);
		boolean isSkip = driver.findElements(By.className("ytp-ad-skip-button-container")).size() > 0;
		if (isSkip) {
			WebElement skipBtn = driver.findElement(By.className("ytp-ad-skip-button-container"));
			skipBtn.click();
			System.out.println("Skipping Ads successful");
		} else System.out.println("No Ads are able to skip");

		// wait 5 secs and then quit session
		Thread.sleep(5000);
		driver.quit();
	}
}
