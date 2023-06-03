package tests.Ordering.Cart;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyProceedToCheckoutButtonRedirectsToCheckoutPage class is a test class that verifies the functionality
 of the Proceed to Checkout button. It checks whether the button redirects the user to the Checkout page when clicked.
 The test assumes that the user has added a product to the cart and is on the Cart page. It extends the BaseTest class
 to inherit the setup and teardown methods.
 Note: The test uses a Faker library to generate random data for testing purposes, such as selecting a random product
 from the search results. It also assumes that the Checkout process requires the user to sign in with an existing
 email and password before proceeding to the Checkout page.
 */
public class VerifyProceedToCheckoutButtonRedirectsToCheckoutPage extends BaseTest {

    @Description("Verify Proceed to Checkout button redirects to Checkout page")
    @Test(description = "Verify Proceed to Checkout button redirects to Checkout page")
    public void verifyProceedToCheckoutButtonRedirectsToCheckoutPage() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        cartPage.clickOnProceedToCheckoutButton();
        signInPage.signInExistingUser(ConfigProvider.EMAIL2, ConfigProvider.PASSWORD);
        productCheckoutPage.clickOnShippingAddressLink();
        Assert.assertTrue(productCheckoutPage.getPageTitle().contains(ConfigProvider.CHECKOUT_PAGE_TITLE), "Page title foes not match");

        //Cart cleanup
        productCheckoutPage.clickOnHomePageLink();
        productCheckoutPage.clickOnReturnToCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
