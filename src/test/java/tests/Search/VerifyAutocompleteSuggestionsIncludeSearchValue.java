package tests.Search;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyAutocompleteSuggestionsIncludeSearchValue extends BaseTest {

    @Description("Verify autocomplete suggestions include search value")
    @Test
    public void VerifyAutocompleteSuggestionsIncludeSearchValue() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.clickOnSearchBar();
        searchBar.inputValueIntoSearchBar(searchValue);
        searchBar.verifyAllSuggestionsContainSearchValue(searchValue);
    }
}
