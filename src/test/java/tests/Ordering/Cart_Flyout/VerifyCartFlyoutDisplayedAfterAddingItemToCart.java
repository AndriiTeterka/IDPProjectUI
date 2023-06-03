package tests.Ordering.Cart_Flyout;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyCartFlyoutDisplayedAfterAddingItemToCart class is a test class that verifies the functionality
 of the Cart Flyout. It checks whether the flyout is displayed after adding an item to the cart.
 The test assumes that the user has searched for an item and the search results are displayed.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test uses a Faker library to generate random data for testing purposes, such as selecting a random product
 from the search results.
 */
public class VerifyCartFlyoutDisplayedAfterAddingItemToCart extends BaseTest {

    @Description("Verify cart flyout is displayed after adding item to cart")
    @Test(description = "Verify cart flyout is displayed after adding item to cart")
    public void verifyCartFlyoutDisplayedAfterAddingItemToCart() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.verifyCartFlyoutIsDisplayed();

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
