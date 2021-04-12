import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {

	@Test
	public void helloTest() {
		// Initialise & set path
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		// 2. Navigation
		driver.navigate().to("https://emilylu123.github.io");

		// 3. Find
		// 4. Store
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();

		// 5. Act
		System.out.println(title);
		System.out.println(url);
		// 7. Quit session
		driver.quit();
	}
}
