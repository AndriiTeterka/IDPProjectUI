package tests.Ordering.Cart;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyAddedToCartProductTitle extends BaseTest {

    @Description("Verify added to cart product title")
    @Test
    public void verifySelectedProductTitle() {
        int order = 9;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        String itemText = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        Assert.assertTrue(cartPage.isAddedProductsTitleContainsText(itemText));
    }
}
