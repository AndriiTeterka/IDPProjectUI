package tests.Ordering.Cart;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyProceedToCheckoutButtonRedirectsToCheckoutPage extends BaseTest {

    @Description("Verify Proceed to Checkout button redirects to Checkout page")
    @Test
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
