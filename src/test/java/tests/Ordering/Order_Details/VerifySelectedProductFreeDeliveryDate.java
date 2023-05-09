package tests.Ordering.Order_Details;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifySelectedProductFreeDeliveryDate extends BaseTest {

    @Description("Verify selected product free delivery date")
    @Test
    public void verifySelectedProductFreeDeliveryDate() {
        int order = 3;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        String itemText = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String freeDeliveryDate = productDetailsPage.getFreeDeliveryDateText();
        Assert.assertTrue(itemText.contains(freeDeliveryDate));
    }
}
