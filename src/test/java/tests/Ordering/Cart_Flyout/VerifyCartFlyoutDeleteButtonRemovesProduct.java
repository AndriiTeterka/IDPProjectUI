package tests.Ordering.Cart_Flyout;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyCartFlyoutDeleteButtonRemovesProduct class is a test class that verifies the functionality
 of the Cart Flyout Delete button. It checks whether the button removes the product from the cart when clicked.
 The test assumes that the user has added a product to the cart and the Cart Flyout is visible.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test uses a Faker library to generate random data for testing purposes, such as selecting a random product
 from the search results.
 */
public class VerifyCartFlyoutDeleteButtonRemovesProduct extends BaseTest {

    @Description("Verify cart flyout product price")
    @Test(description = "Verify cart flyout product price")
    public void verifyCartFlyoutProductPrice() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.clickOnCartFlyoutProductDeleteButton();
        cartFlyout.verifyCartFlyoutProductRemovedFromCartText(ConfigProvider.REMOVED_FROM_SHOPPING_CART_MESSAGE);
    }
}
