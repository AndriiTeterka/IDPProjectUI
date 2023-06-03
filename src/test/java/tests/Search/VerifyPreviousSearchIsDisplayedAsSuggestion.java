package tests.Search;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**

 The VerifyPreviousSearchIsDisplayedAsSuggestion class is a test class that verifies the previous search is displayed as a suggestion
 when the user clicks on the search bar after navigating to a different page. It assumes that the user has performed a search
 and the previous search value is stored as a suggestion.
 It performs the following steps:
 Clicks on the search bar.
 Inputs the search value into the search bar.
 Clicks on one of the autocomplete suggestions.
 Retrieves the suggestion text.
 Clicks on the home page logo to navigate to a different page.
 Clicks on the search bar.
 Verifies that one of the autocomplete suggestions contains the previous search value.
 Note: The test extends the BaseTest class, which provides the common setup and teardown for the test.
 */
public class VerifyPreviousSearchIsDisplayedAsSuggestion extends BaseTest {

    @Description("Verify selection of autocomplete suggestion")
    @Test(description = "Verify selection of autocomplete suggestion")
    public void verifySelectionOfAutocompleteSuggestion() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.clickOnSearchBar();
        searchBar.inputValueIntoSearchBar(searchValue);
        searchBar.clickOnSuggestionByOrder(8);
        String suggestion = searchBar.getSearchBarText();
        headerNavigationBar.clickOnHomePageLogo();
        searchBar.clickOnSearchBar();
        searchBar.verifyOneOfSuggestionsContainSearchValue(suggestion);
    }
}
