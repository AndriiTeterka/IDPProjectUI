package tests.Ordering.Cart;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyAddedToCartProductPrice class is a test class that verifies the product price of an added item in the cart.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test assumes that a search is performed for a specific item (TV_NAME) and one of the search results is selected.
 The product price is retrieved from the product details page, and the item is added to the cart.
 The cart page is then accessed, and it is verified that the added product's price is displayed correctly in the cart.
 After the verification, all items are removed from the cart for cleanup.
 */
public class VerifyAddedToCartProductPrice extends BaseTest {

    @Description("Verify added to cart product price")
    @Test(description = "Verify added to cart product price")
    public void verifyAddedToCartProductPrice() {
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
