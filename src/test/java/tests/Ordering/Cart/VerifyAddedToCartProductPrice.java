package tests.Ordering.Cart;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyAddedToCartProductPrice extends BaseTest {

    @Description("Verify added to cart product price")
    @Test
    public void verifySelectedProductTitle() {
        int order = 9;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productPrice = productDetailsPage.getProductPriceText();
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        Assert.assertTrue(cartPage.isAddedProductsPriceContainsText(productPrice));
    }
}
