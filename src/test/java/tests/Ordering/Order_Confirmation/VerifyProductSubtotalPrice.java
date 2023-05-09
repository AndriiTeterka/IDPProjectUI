package tests.Ordering.Order_Confirmation;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyProductSubtotalPrice extends BaseTest {

    @Description("Verify product subtotal price")
    @Test
    public void verifyProductSubtotalPrice() {
        int order = 5;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productPrice = productDetailsPage.getProductPriceText();
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.verifyCartSubtotalPrice(productPrice);
    }
}
