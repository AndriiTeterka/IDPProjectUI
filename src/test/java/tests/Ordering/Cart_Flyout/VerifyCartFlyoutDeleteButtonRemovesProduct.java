package tests.Ordering.Cart_Flyout;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyCartFlyoutDeleteButtonRemovesProduct extends BaseTest {

    @Description("Verify cart flyout product price")
    @Test
    public void verifyCartFlyoutProductPrice() {
        int order = 6;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.clickOnCartFlyoutProductDeleteButton();
        cartFlyout.verifyCartFlyoutProductRemovedFromCartText(ConfigProvider.REMOVED_FROM_SHOPPING_CART_MESSAGE);
    }
}
