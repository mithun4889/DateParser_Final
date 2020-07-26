package propine;

import org.testng.annotations.DataProvider;

public class DatesDataProvider {
    /**
     * Provides search items for the test
     */

    @DataProvider(name = "positiveDates")
    public static Object[][] positiveDates() {
        return new Object[][]{{"10/10/1989","Tue Oct 10 1989 00:00:00 GMT+0000"},
                {"11-11-2000","Sat Nov 11 2000 00:00:00 GMT+0000"},
                {"11,05,2000","Sun Nov 05 2000 00:00:00 GMT+0000"},
                {"22-April-2001","Sun Apr 22 2001 00:00:00 GMT+0000"},
                {"11/08/98","Sun Nov 08 1998 00:00:00 GMT+0000"},
                {"1/1/1","Mon Jan 01 2001 00:00:00 GMT+0000"}};
    }

    @DataProvider(name = "negativeDates")
    public static Object[][] negativeDates() {
        return new Object[][]{{"15/15/2000","Invalid date"},
                {"10101989","Invalid date"},
                {"asdasdasd","Invalid date"},
                {"0/0/0","Invalid date"}};
    }
}
