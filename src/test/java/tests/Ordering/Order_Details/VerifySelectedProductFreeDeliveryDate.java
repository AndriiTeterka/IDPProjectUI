package tests.Ordering.Order_Details;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifySelectedProductFreeDeliveryDate extends BaseTest {

    @Description("Verify selected product free delivery date")
    @Test
    public void verifySelectedProductFreeDeliveryDate() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        String itemText = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String freeDeliveryDate = productDetailsPage.getFreeDeliveryDateText();
        Assert.assertTrue(itemText.contains(freeDeliveryDate), "Product free delivery date does not match");
    }
}
