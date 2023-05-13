package tests.Ordering.Cart;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyProceedToCheckoutButtonRedirectsToCheckoutPage extends BaseTest {

    @Description("Verify Proceed to Checkout button redirects to Checkout page")
    @Test
    public void verifyProceedToCheckoutButtonRedirectsToCheckoutPage() {
        int order = 9;

        headerNavigationBar.clickOnAccountListLink();
        signInPage.signInExistingUser(ConfigProvider.EMAIL2, ConfigProvider.PASSWORD);
        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        cartPage.clickOnProceedToCheckoutButton();
        Assert.assertTrue(productCheckoutPage.getPageTitle().contains(ConfigProvider.CHECKOUT_PAGE_TITLE));
    }
}
