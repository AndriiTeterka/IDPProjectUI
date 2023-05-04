package tests.Search;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyPreviousSearchIsDisplayedAsSuggestion extends BaseTest {

    @Description("Verify selection of autocomplete suggestion")
    @Test
    public void verifySelectionOfAutocompleteSuggestion() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.clickOnSearchBar();
        searchBar.inputValueIntoSearchBar(searchValue);
        searchBar.clickOnSuggestionByOrder(8);
        String suggestion = searchBar.searchBarGetText();
        headerNavigationBar.clickOnHomePageLogo();
        searchBar.clickOnSearchBar();
        searchBar.verifyOneOfSuggestionsContainSearchValue(suggestion);
    }
}
