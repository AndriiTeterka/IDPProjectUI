package tests.Ordering.Cart;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyCartButtonCounterWhenProductAddedToCart class is a test class that verifies the cart button counter
 when a product is added to the cart. It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test assumes that a search is performed for a specific item (TV_NAME) and a search result is selected.
 The item is added to the cart, and it is verified that the cart button counter displays the correct quantity.
 The test also verifies that changing the quantity option in the cart flyout updates the cart button counter accordingly.
 After the verification, all items are removed from the cart for cleanup.
 */
public class VerifyCartButtonCounterWhenProductAddedToCart extends BaseTest {

    @Description("Verify cart button counter when product added to cart")
    @Test(description = "Verify cart button counter when product added to cart")
    public void verifyCartButtonCounterWhenProductAddedToCart() {
        Faker faker = new Faker();
        int quantityOption = 3;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        headerNavigationBar.verifyCarButtonCounterText("1");

        cartFlyout.selectCartFlyoutQuantityOption(quantityOption);
        headerNavigationBar.verifyCarButtonCounterText(String.valueOf(quantityOption));

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
