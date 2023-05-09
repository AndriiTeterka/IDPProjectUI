package tests.Ordering.Cart_Flyout;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyCartFlyoutSubtotalPrice extends BaseTest {

    @Description("Verify cart flyout subtotal price")
    @Test
    public void verifyCartFlyoutSubtotalPrice() {
        int order = 6;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productPrice = productDetailsPage.getProductPriceText();
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.verifyCartFlyoutSubtotalPrice(productPrice);
    }
}
