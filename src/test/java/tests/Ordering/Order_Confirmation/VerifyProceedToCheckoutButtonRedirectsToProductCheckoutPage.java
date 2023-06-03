package tests.Ordering.Order_Confirmation;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyProceedToCheckoutButtonRedirectsToProductCheckoutPage class is a test class that verifies whether the
 "Proceed to Checkout" button on the order confirmation page redirects to the product checkout page. It assumes that
 the user has added a product to the cart and performs the following steps:
 Search for a specific item using the search bar.
 Select a random search result item with price.
 Click on the "Add to Cart" button on the product details page.
 Click on the "Proceed to Checkout" button on the order confirmation page.
 Sign in as an existing user.
 Click on the "Shipping Address" link on the product checkout page.
 Assert that the page title of the product checkout page contains the expected checkout page title.
 Note: The test uses a Faker library to generate random data for testing purposes, such as the order number.
 */
public class VerifyProceedToCheckoutButtonRedirectsToProductCheckoutPage extends BaseTest {

    @Description("Verify Proceed to Checkout button redirects to Product Checkout page")
    @Test(description = "Verify Proceed to Checkout button redirects to Product Checkout page")
    public void verifyProceedToCheckoutButtonRedirectsToProductCheckoutPage() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnProceedToCheckoutButton();
        signInPage.signInExistingUser(ConfigProvider.EMAIL2, ConfigProvider.PASSWORD);
        productCheckoutPage.clickOnShippingAddressLink();
        Assert.assertTrue(productCheckoutPage.getPageTitle().contains(ConfigProvider.CHECKOUT_PAGE_TITLE), "Page title does not match");

        //Cart cleanup
        productCheckoutPage.clickOnHomePageLink();
        productCheckoutPage.clickOnReturnToCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
