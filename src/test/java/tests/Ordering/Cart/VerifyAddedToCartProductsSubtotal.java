package tests.Ordering.Cart;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyAddedToCartProductsSubtotal extends BaseTest {

    @Description("Verify added to cart products subtitle")
    @Test
    public void verifySelectedProductTitle() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.pressBack(2);
        int newOrder = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(newOrder);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        Assert.assertEquals(cartPage.calculateAddedProductsSubtotal(), cartPage.getAddedProductsSubtotalAsDouble(), "Subtotal price does not match");

        //Cart cleanup
        cartPage.removeAllItemsFromCart();
    }
}
