package tests.Search;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifySelectionOfAutocompleteSuggestion extends BaseTest {

    @Description("Verify selection of autocomplete suggestion")
    @Test
    public void verifySelectionOfAutocompleteSuggestion() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.clickOnSearchBar();
        searchBar.inputValueIntoSearchBar(searchValue);
        searchBar.clickOnSuggestionByOrder(4);
        String suggestion = searchBar.searchBarGetText();
        searchResultsPage.verifySearchResultInfoBarContainsText(suggestion);
    }
}
