package tests.Ordering.Cart_Flyout;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyCartFlyoutDeleteButtonRemovesProduct extends BaseTest {

    @Description("Verify cart flyout product price")
    @Test
    public void verifyCartFlyoutProductPrice() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.clickOnCartFlyoutProductDeleteButton();
        cartFlyout.verifyCartFlyoutProductRemovedFromCartText(ConfigProvider.REMOVED_FROM_SHOPPING_CART_MESSAGE);
    }
}
