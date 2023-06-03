package tests.Ordering.Order_Confirmation;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyGoToCartButtonRedirectsToCartPage class is a test class that verifies whether the "Go to Cart" button
 on the order confirmation page redirects to the cart page. It assumes that the user has added a product to the cart
 and performs the following steps:
 Search for a specific item using the search bar.
 Select a random search result item with price.
 Click on the "Add to Cart" button on the product details page.
 Click on the "Go to Cart" button on the order confirmation page.
 Assert that the page title of the cart page contains the expected cart page title.
 Note: The test uses a Faker library to generate random data for testing purposes, such as the order number.
 */
public class VerifyGoToCartButtonRedirectsToCartPage extends BaseTest {

    @Description("Verify Go to Cart button redirects to cart page")
    @Test(description = "Verify Go to Cart button redirects to cart page")
    public void verifyGoToCartButtonRedirectsToCartPage() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        Assert.assertTrue(cartPage.getPageTitle().contains(ConfigProvider.CART_PAGE_TITLE));

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
