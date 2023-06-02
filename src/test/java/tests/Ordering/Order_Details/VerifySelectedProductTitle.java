package tests.Ordering.Order_Details;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifySelectedProductTitle extends BaseTest {

    @Description("Verify selected product title")
    @Test
    public void verifySelectedProductTitle() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        String itemText = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productTitle = productDetailsPage.getProductTitleText();
        Assert.assertTrue(itemText.contains(productTitle), "Product title does not match");
    }
}
