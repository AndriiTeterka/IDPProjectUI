package tests.Ordering.Cart_Flyout;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyCartFlyoutGoToCartButtonRedirectsToCartPage extends BaseTest {

    @Description("Verify cart flyout Go to Cart button redirects to Cart Page")
    @Test
    public void verifyCartFlyoutGoToCartButtonRedirectsToCartPage() {
        int order = 6;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.clickOnCartFlyoutGoToCartButton();
        Assert.assertTrue(cartPage.getPageTitle().contains(ConfigProvider.CART_PAGE_TITLE));
    }
}
