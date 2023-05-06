package tests.Ordering;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifySelectedProductTitle extends BaseTest {

    @Description("Verify selected product title")
    @Test
    public void verifySelectedProductTitle() {
        int order = 3;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        String itemText = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productTitle = productDetailsPage.getProductTitleText();
        Assert.assertTrue(itemText.contains(productTitle));
    }
}
