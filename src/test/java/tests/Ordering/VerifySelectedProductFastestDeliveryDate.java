package tests.Ordering;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifySelectedProductFastestDeliveryDate extends BaseTest {

    @Description("Verify selected product fastest delivery date")
    @Test
    public void verifySelectedProductFastestDeliveryDate() {
        int order = 3;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        String itemText = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String fastestDeliveryDate = productDetailsPage.getFreeDeliveryDateText();
        Assert.assertTrue(itemText.contains(fastestDeliveryDate));
    }
}
