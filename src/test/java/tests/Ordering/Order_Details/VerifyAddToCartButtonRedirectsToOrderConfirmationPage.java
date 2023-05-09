package tests.Ordering.Order_Details;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyAddToCartButtonRedirectsToOrderConfirmationPage extends BaseTest {

    @Description("Verify Add to Cart button redirects to Product Confirmation Page")
    @Test
    public void verifyAddToCartButtonRedirectsToOrderConfirmationPage() {
        int order = 5;

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnAddToCartButton();
        productConfirmationPage.verifyProductConfirmationPageIsDisplayed();
    }
}
