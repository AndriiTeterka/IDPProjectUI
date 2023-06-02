package tests.Ordering.Order_Confirmation;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyProceedToCheckoutButtonRedirectsToProductCheckoutPage extends BaseTest {

    @Description("Verify Proceed to Checkout button redirects to Product Checkout page")
    @Test
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
