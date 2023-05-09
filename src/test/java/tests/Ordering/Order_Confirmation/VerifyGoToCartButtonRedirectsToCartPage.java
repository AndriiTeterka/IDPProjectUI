package tests.Ordering.Order_Confirmation;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyGoToCartButtonRedirectsToCartPage extends BaseTest {

    @Description("Verify Go to Cart button redirects to cart page")
    @Test
    public void verifyGoToCartButtonRedirectsToCartPage() {
        int order = 5;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        Assert.assertTrue(cartPage.getPageTitle().contains(ConfigProvider.CART_PAGE_TITLE));
    }
}
