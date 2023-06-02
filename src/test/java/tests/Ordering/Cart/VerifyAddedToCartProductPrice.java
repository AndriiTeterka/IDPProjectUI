package tests.Ordering.Cart;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyAddedToCartProductPrice extends BaseTest {

    @Description("Verify added to cart product price")
    @Test
    public void verifySelectedProductTitle() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productPrice = productDetailsPage.getProductPriceText();
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        Assert.assertTrue(cartPage.isAddedProductsPriceContainsText(productPrice));

        //Cart cleanup
        cartPage.removeAllItemsFromCart();
    }
}
