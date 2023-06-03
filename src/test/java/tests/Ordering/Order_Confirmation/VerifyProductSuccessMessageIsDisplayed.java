package tests.Ordering.Order_Confirmation;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyProductSuccessMessageIsDisplayed class is a test class that verifies whether the product success message
 is displayed on the order confirmation page after adding a product to the cart. It assumes that the user has added a
 product to the cart and performs the following steps:
 Search for a specific item using the search bar.
 Select a random search result item with price.
 Click on the "Add to Cart" button on the product details page.
 Verify that the success message displayed on the order confirmation page matches the expected message.
 Note: The test uses a Faker library to generate random data for testing purposes, such as the order number.
 */
public class VerifyProductSuccessMessageIsDisplayed extends BaseTest {

    @Description("Verify product success message is displayed")
    @Test(description = "Verify product success message is displayed")
    public void verifyProductSuccessMessageIsDisplayed() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.verifySuccessMessageText(ConfigProvider.ADDED_TO_CART_CONFIRMATION_MESSAGE);

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
