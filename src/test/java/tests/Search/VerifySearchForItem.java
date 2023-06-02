package tests.Search;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifySearchForItem extends BaseTest {

    @Description("Search for item")
    @Test
    public void verifySearchForItem() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.searchForItem(searchValue);
        searchResultsPage.verifySearchResultInfoBarIsDisplayed();
        Assert.assertTrue(searchResultsPage.getPageTitle().contains(searchValue));
    }
}
