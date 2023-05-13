package tests.Ordering.Cart;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyAddedToCartProductsSubtotal extends BaseTest {

    @Description("Verify added to cart products subtitle")
    @Test
    public void verifySelectedProductTitle() {
        int order = 9;
        int secondOrder = 2;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.pressBack(2);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(secondOrder);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        Assert.assertEquals(cartPage.calculateAddedProductsSubtotal(), cartPage.getAddedProductsSubtotalAsDouble());
    }
}
