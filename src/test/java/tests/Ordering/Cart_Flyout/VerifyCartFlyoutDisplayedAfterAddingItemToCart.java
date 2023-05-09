package tests.Ordering.Cart_Flyout;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyCartFlyoutDisplayedAfterAddingItemToCart extends BaseTest {

    @Description("Verify cart flyout is displayed after adding item to cart")
    @Test
    public void verifyCartFlyoutDisplayedAfterAddingItemToCart() {
        int order = 6;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.verifyCartFlyoutIsDisplayed();
    }
}
