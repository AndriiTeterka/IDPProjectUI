package tests.Ordering.Cart;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;


/**
 The VerifyAddedToCartProductTitle class is a test class that verifies the title of the added product in the cart.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test assumes that a search is performed for a specific item (TV_NAME) and a search result is selected.
 The item is added to the cart, and it is verified that the title of the added product matches the expected title.
 After the verification, all items are removed from the cart for cleanup.
 */
public class VerifyAddedToCartProductTitle extends BaseTest {

    @Description("Verify added to cart product title")
    @Test(description = "Verify added to cart product title")
    public void verifySelectedProductTitle() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        String itemText = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.clickOnGoToCartButton();
        Assert.assertTrue(cartPage.isAddedProductsTitleContainsText(itemText));

        //Cart cleanup
        cartPage.removeAllItemsFromCart();
    }
}
