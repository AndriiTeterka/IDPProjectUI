package tests.Ordering;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifySelectedProductPrice extends BaseTest {

    @Description("Verify selected product price")
    @Test
    public void verifySelectedProductPrice() {
        int order = 3;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        String itemText = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productPrice = productDetailsPage.getProductPriceText();
        Assert.assertTrue(itemText.contains(productPrice));
    }
}
