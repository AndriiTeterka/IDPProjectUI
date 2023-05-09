package tests.Ordering.Order_Confirmation;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyGoToCartButtonRedirectsToProductCheckoutPage extends BaseTest {

    @Description("Verify Go to Cart button redirects to Product Checkout page")
    @Test
    public void verifyGoToCartButtonRedirectsToProductCheckoutPage() {
        int order = 5;

        headerNavigationBar.clickOnSignInLink();
        signInPage.signInExistingUser(ConfigProvider.EMAIL, ConfigProvider.PASSWORD);
        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnProceedToCheckoutButton();
        productCheckoutPage.verifyCheckoutHeaderText(ConfigProvider.CHECKOUT_HEADER_TEXT);
    }
}
