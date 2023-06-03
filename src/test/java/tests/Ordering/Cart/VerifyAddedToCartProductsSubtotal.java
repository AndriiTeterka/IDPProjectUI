package tests.Ordering.Cart;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyAddedToCartProductsSubtotal class is a test class that verifies the subtotal of the added products in the cart.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test assumes that a search is performed for a specific item (TV_NAME) and two search results are selected.
 The items are added to the cart, and it is verified that the subtotal of the added products matches the calculated subtotal.
 After the verification, all items are removed from the cart for cleanup.
 */
public class VerifyAddedToCartProductsSubtotal extends BaseTest {

    @Description("Verify added to cart products subtotal")
    @Test(description = "Verify added to cart products subtotal")
    public void verifyAddedToCartProductsSubtotal() {
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
