package tests.Ordering.Order_Details;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyAddToCartButtonRedirectsToOrderConfirmationPage extends BaseTest {

    @Description("Verify Add to Cart button redirects to Product Confirmation Page")
    @Test
    public void verifyAddToCartButtonRedirectsToOrderConfirmationPage() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.verifyProductConfirmationPageIsDisplayed();

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
