package tests.Ordering.Cart;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyCartButtonCounterWhenProductAddedToCart extends BaseTest {

    @Description("Verify cart button counter when product added to cart")
    @Test
    public void verifyCartButtonCounterWhenProductAddedToCart() {
        int order = 9;
        int quantityOption = 3;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        headerNavigationBar.verifyCarButtonCounterText("1");

        cartFlyout.selectCartFlyoutQuantityOption(quantityOption);
        headerNavigationBar.verifyCarButtonCounterText(String.valueOf(quantityOption));
    }
}
