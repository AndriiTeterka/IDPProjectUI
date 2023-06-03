package tests.Ordering.Order_Details;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyAddToCartButtonRedirectsToOrderConfirmationPage class is a test class that verifies whether the
 "Add to Cart" button redirects to the order confirmation page. It assumes that the user has searched for a
 specific item and is on the product details page. It performs the following steps:
 Search for a specific item using the search bar.
 Select a random search result item with price.
 Click on the "Add to Cart" button.
 Verify that the order confirmation page is displayed.
 Note: The test uses a Faker library to generate random data for testing purposes, such as the order number.
 */
public class VerifyAddToCartButtonRedirectsToOrderConfirmationPage extends BaseTest {

    @Description("Verify Add to Cart button redirects to Product Confirmation Page")
    @Test(description = "Verify Add to Cart button redirects to Product Confirmation Page")
    public void verifyAddToCartButtonRedirectsToOrderConfirmationPage() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.verifyProductConfirmationPageIsDisplayed();

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
