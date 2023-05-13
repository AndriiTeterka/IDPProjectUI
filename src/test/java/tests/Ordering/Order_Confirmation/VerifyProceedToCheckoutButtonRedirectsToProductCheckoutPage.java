package tests.Ordering.Order_Confirmation;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyProceedToCheckoutButtonRedirectsToProductCheckoutPage extends BaseTest {

    @Description("Verify Proceed to Checkout button redirects to Product Checkout page")
    @Test
    public void verifyProceedToCheckoutButtonRedirectsToProductCheckoutPage() {
        int order = 5;

        headerNavigationBar.clickOnAccountListLink();
        signInPage.signInExistingUser(ConfigProvider.EMAIL2, ConfigProvider.PASSWORD);
        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnProceedToCheckoutButton();
        Assert.assertTrue(productCheckoutPage.getPageTitle().contains(ConfigProvider.CHECKOUT_PAGE_TITLE));
    }
}
