package tests.Search;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifySearchForItem class is a test class that verifies the search functionality by searching for a specific item.
 It performs the following steps:
 Sets the search value to the desired item name.
 Performs a search for the item using the search bar.
 Verifies that the search result info bar is displayed.
 Asserts that the search value is contained in the page title.
 Note: The test extends the BaseTest class, which provides the common setup and teardown for the test.
 */
public class VerifySearchForItem extends BaseTest {

    @Description("Search for item")
    @Test(description = "Search for item")
    public void verifySearchForItem() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.searchForItem(searchValue);
        searchResultsPage.verifySearchResultInfoBarIsDisplayed();
        Assert.assertTrue(searchResultsPage.getPageTitle().contains(searchValue));
    }
}
