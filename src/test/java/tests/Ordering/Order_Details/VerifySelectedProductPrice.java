package tests.Ordering.Order_Details;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifySelectedProductPrice class is a test class that verifies the price of a selected product.
 It assumes that the user has searched for a specific item and is on the search results page. It performs the following steps:
 Search for a specific item using the search bar.
 Select a random search result item with price.
 Get the text of the selected item.
 Get the price from the product details page.
 Assert that the price is contained within the item text.
 Note: The test uses a Faker library to generate random data for testing purposes, such as the order number.
 */
public class VerifySelectedProductPrice extends BaseTest {

    @Description("Verify selected product price")
    @Test(description = "Verify selected product price")
    public void verifySelectedProductPrice() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        String itemText = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productPrice = productDetailsPage.getProductPriceText();
        Assert.assertTrue(itemText.contains(productPrice), "Product price does not match");
    }
}
