package tests.Search;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class SearchForItem extends BaseTest {

    @Description("Search for item")
    @Test
    public void searchForItem() {
        String searchValue = ConfigProvider.LAPTOP_NAME;

        searchBar.searchForItem(searchValue);
        searchResultsPage.verifySearchResultInfoBarIsDisplayed();
        Assert.assertTrue(Selenide.title().contains(searchValue));
    }
}
