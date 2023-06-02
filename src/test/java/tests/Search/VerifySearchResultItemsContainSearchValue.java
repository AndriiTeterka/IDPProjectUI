package tests.Search;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifySearchResultItemsContainSearchValue extends BaseTest {

    @Description("Verify search result contain search value")
    @Test
    public void verifySearchResultItemsContainSearchValue() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.searchForItem(searchValue);
        searchResultsPage.verifySearchResultItemsContainSearchValue(searchValue.substring(0, searchValue.indexOf(" ")));
    }
}
