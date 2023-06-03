package tests.Search;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifySelectionOfAutocompleteSuggestion class is a test class that verifies the selection of an autocomplete suggestion.
 It performs the following steps:
 Sets the search value to the desired item name.
 Clicks on the search bar to open the autocomplete flyout.
 Inputs the search value into the search bar.
 Clicks on the suggestion by order (4th suggestion in this case).
 Gets the selected suggestion text.
 Verifies that the search result info bar contains the selected suggestion text.
 Note: The test extends the BaseTest class, which provides the common setup and teardown for the test.
 */
public class VerifySelectionOfAutocompleteSuggestion extends BaseTest {

    @Description("Verify selection of autocomplete suggestion")
    @Test(description = "Verify selection of autocomplete suggestion")
    public void verifySelectionOfAutocompleteSuggestion() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.clickOnSearchBar();
        searchBar.inputValueIntoSearchBar(searchValue);
        searchBar.clickOnSuggestionByOrder(4);
        String suggestion = searchBar.getSearchBarText();
        searchResultsPage.verifySearchResultInfoBarContainsText(suggestion);
    }
}
