package propine;

import gradle.base.BaseTest;
import gradle.pages.HomePage;
import org.testng.annotations.Test;


public class ParseDate extends BaseTest {
    /**
     * Test case to parse date
     *
     */

    @Test(groups = "search", priority = 0, dataProvider = "positiveDates", dataProviderClass = DatesDataProvider.class)
    public void positiveParse(String date, String result) {
		HomePage homePage = new HomePage(driver);
		homePage.goToHomePage();
		homePage.searchItem(date);
		homePage.verifyTheSearch(result);
    }

    @Test(groups = "search", priority = 0, dataProvider = "negativeDates", dataProviderClass = DatesDataProvider.class)
    public void negativeParse(String date, String result) {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        homePage.searchItem(date);
        homePage.verifyTheSearch(result);
    }
}
