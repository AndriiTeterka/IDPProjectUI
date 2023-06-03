package tests.Search;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyAutocompleteSuggestionsIncludeSearchValue class is a test class that verifies the autocomplete suggestions in the search bar
 include the search value entered by the user. It assumes that the user is on a page with a search bar.
 It performs the following steps:
 Clicks on the search bar.
 Inputs the search value into the search bar.
 Verifies that all autocomplete suggestions contain the search value.
 Note: The test extends the BaseTest class, which provides the common setup and teardown for the test.
 */
public class VerifyAutocompleteSuggestionsIncludeSearchValue extends BaseTest {

    @Description("Verify autocomplete suggestions include search value")
    @Test(description = "Verify autocomplete suggestions include search value")
    public void VerifyAutocompleteSuggestionsIncludeSearchValue() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.clickOnSearchBar();
        searchBar.inputValueIntoSearchBar(searchValue);
        searchBar.verifyAllSuggestionsContainSearchValue(searchValue);
    }
}
