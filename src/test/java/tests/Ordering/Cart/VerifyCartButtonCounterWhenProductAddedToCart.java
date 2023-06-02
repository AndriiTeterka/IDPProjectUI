package tests.Ordering.Cart;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyCartButtonCounterWhenProductAddedToCart extends BaseTest {

    @Description("Verify cart button counter when product added to cart")
    @Test
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
