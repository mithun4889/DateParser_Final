package gradle.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
	public WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			 
			// Initialize browser
			driver=new ChromeDriver();
			
		}
		
	}

	@AfterSuite(alwaysRun = true)
	public void shutDownBrowser() {
		
			driver.quit();
		}

}
