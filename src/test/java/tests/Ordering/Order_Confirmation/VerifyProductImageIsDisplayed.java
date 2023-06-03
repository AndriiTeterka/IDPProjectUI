package tests.Ordering.Order_Confirmation;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;


/**
 The VerifyProductImageIsDisplayed class is a test class that verifies whether the product image is displayed
 on the order confirmation page. It assumes that the user has added a product to the cart and performs the following steps:
 Search for a specific item using the search bar.
 Select a random search result item with price.
 Click on the "Add to Cart" button on the product details page.
 Verify that the product image is displayed on the order confirmation page.
 Note: The test uses a Faker library to generate random data for testing purposes, such as the order number.
 */
public class VerifyProductImageIsDisplayed extends BaseTest {

    @Description("Verify product image is displayed")
    @Test(description = "Verify product image is displayed")
    public void verifyProductImageIsDisplayed() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.verifyProductImageIsDisplayed();

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
