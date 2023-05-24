package tests.Ordering.Cart_Flyout;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyCartFlyoutProductLinkRedirectsToProductDetailsPage extends BaseTest {

    @Description("Verify cart flyout product link redirects to Product Details Page")
    @Test
    public void verifyCartFlyoutProductLinkRedirectsToProductDetailsPage() {
        Faker faker = new Faker();

        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        String productTitle = productDetailsPage.getProductTitleText();
        productDetailsPage.clickOnAddToCartButton();
        cartFlyout.clickOnCartFlyoutProductLink();
        Assert.assertEquals(productTitle, productDetailsPage.getProductTitleText(), "Product title does not match");

        //Cart cleanup
        headerNavigationBar.clickOnCartButton();
        cartPage.removeAllItemsFromCart();
    }
}
