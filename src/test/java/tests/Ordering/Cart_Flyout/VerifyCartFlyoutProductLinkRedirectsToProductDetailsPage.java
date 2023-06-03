package tests.Ordering.Cart_Flyout;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyCartFlyoutProductLinkRedirectsToProductDetailsPage class is a test class that verifies the functionality
 of the product link in the Cart Flyout. It checks whether clicking on the product link redirects the user to the
 Product Details page. The test assumes that the user has searched for an item and the search results are displayed.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test uses a Faker library to generate random data for testing purposes, such as selecting a random product
 from the search results.
 */
public class VerifyCartFlyoutProductLinkRedirectsToProductDetailsPage extends BaseTest {

    @Description("Verify cart flyout product link redirects to Product Details Page")
    @Test(description = "Verify cart flyout product link redirects to Product Details Page")
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
