package gradle.pages;

import gradle.utils.ConfigReader;
import gradle.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Home page related locators and actions to perform
 *
 *
 */
public class HomePage {
	public WebDriverUtils utility;
	public WebDriver driver;

	@FindBy(xpath = "//input[@name='date']")
	WebElement dateSearchBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='col-md-6'][2]/div")
	WebElement serachResult;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new WebDriverUtils(driver);
	}

	public void searchItem(String date) {
		utility.waitTillElementFound(dateSearchBox,5);
		dateSearchBox.sendKeys(date);
		utility.waitTillElementFound(searchButton, 5);
		searchButton.click();
	}

	public void verifyTheSearch(String expectedResult) {
		utility.waitTillElementFound(serachResult,20);
		String actualResult = serachResult.getText();
		Assert.assertEquals(actualResult, expectedResult, "Actual and expected not matching");
	}

	public void goToHomePage() {
		Reporter.log("Navigating to home page", true);
		driver.navigate().to(ConfigReader.getConfigValue("url"));
		Assert.assertEquals(driver.getTitle(), "Propine Date Parser");
		Reporter.log("Navigated to home page", true);
	}
}
