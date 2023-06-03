package tests.Search;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;


/**
 The VerifySearchResultItemsContainSearchValue class is a test class that verifies if the search results contain the search value.
 It performs the following steps:
 Sets the search value to the desired item name.
 Performs a search for the item using the search bar.
 Verifies that all search result items contain the search value.
 Note: The test extends the BaseTest class, which provides the common setup and teardown for the test.
 */
public class VerifySearchResultItemsContainSearchValue extends BaseTest {

    @Description("Verify search result contain search value")
    @Test(description = "Verify search result contain search value")
    public void verifySearchResultItemsContainSearchValue() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.searchForItem(searchValue);
        searchResultsPage.verifySearchResultItemsContainSearchValue(searchValue.substring(0, searchValue.indexOf(" ")));
    }
}
