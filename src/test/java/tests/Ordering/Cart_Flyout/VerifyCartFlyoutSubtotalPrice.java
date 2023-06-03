package tests.Ordering.Cart_Flyout;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;


/**
 The VerifyCartFlyoutSubtotalPrice class is a test class that verifies the correctness of the subtotal price
 displayed in the Cart Flyout. It checks whether the subtotal price of the products in the cart matches the price
 displayed in the Cart Flyout. The test assumes that the user has searched for an item and the search results are displayed.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test uses a Faker library to generate random data for testing purposes, such as selecting a random product
 from the search results.
 */
public class VerifyCartFlyoutSubtotalPrice extends BaseTest {

    @Description("Verify cart flyout subtotal price")
    @Test(description = "Verify cart flyout subtotal price")
    public void verifyCartFlyoutSubtotalPrice() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productPrice = productDetailsPage.getProductPriceText();
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.verifyCartFlyoutSubtotalPrice(productPrice);

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
