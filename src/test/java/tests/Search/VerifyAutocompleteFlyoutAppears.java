package tests.Search;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

/**
 The VerifyAutocompleteFlyoutAppears class is a test class that verifies the appearance of the autocomplete flyout in the search bar.
 It assumes that the user is on a page with a search bar. It performs the following steps:
 Clicks on the search bar.
 Verifies that the autocomplete flyout is displayed.
 Note: The test extends the BaseTest class, which provides the common setup and teardown for the test.
 */
public class VerifyAutocompleteFlyoutAppears extends BaseTest {

    @Description("Verify autocomplete flyout appears")
    @Test(description = "Verify autocomplete flyout appears")
    public void verifyAutocompleteFlyoutAppears() {
        searchBar.clickOnSearchBar();
        searchBar.verifyAutocompleteFlyoutIsDisplayed();
    }
}
