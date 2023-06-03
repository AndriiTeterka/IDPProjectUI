package tests.Ordering.Cart_Flyout;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyCartFlyoutGoToCartButtonRedirectsToCartPage class is a test class that verifies the functionality
 of the "Go to Cart" button in the Cart Flyout. It checks whether clicking on the button redirects the user to the Cart page.
 The test assumes that the user has searched for an item and the search results are displayed.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test uses a Faker library to generate random data for testing purposes, such as selecting a random product
 from the search results.
 */
public class VerifyCartFlyoutGoToCartButtonRedirectsToCartPage extends BaseTest {

    @Description("Verify cart flyout Go to Cart button redirects to Cart Page")
    @Test(description = "Verify cart flyout Go to Cart button redirects to Cart Page")
    public void verifyCartFlyoutGoToCartButtonRedirectsToCartPage() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.clickOnCartFlyoutGoToCartButton();
        Assert.assertTrue(cartPage.getPageTitle().contains(ConfigProvider.CART_PAGE_TITLE), "Page title does not match");

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
