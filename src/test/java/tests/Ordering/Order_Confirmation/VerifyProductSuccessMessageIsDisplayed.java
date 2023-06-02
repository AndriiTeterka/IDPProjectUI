package tests.Ordering.Order_Confirmation;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyProductSuccessMessageIsDisplayed extends BaseTest {

    @Description("Verify product subtotal price")
    @Test
    public void verifyProductSubtotalPrice() {
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
