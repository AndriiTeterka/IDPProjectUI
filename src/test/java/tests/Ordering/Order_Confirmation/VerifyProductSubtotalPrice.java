package tests.Ordering.Order_Confirmation;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyProductSubtotalPrice class is a test class that verifies whether the product subtotal price is correct
 on the order confirmation page. It assumes that the user has added a product to the cart and performs the following steps:
 Search for a specific item using the search bar.
 Select a random search result item with price.
 Click on the "Add to Cart" button on the product details page.
 Verify that the product subtotal price matches the expected price on the order confirmation page.
 Note: The test uses a Faker library to generate random data for testing purposes, such as the order number.
 */
public class VerifyProductSubtotalPrice extends BaseTest {

    @Description("Verify product subtotal price")
    @Test(description = "Verify product subtotal price")
    public void verifyProductSubtotalPrice() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productPrice = productDetailsPage.getProductPriceText();
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.verifyCartSubtotalPrice(productPrice);

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
