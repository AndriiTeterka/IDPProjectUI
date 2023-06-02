package tests.Ordering.Cart;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyCartButtonRedirectsToCartPage extends BaseTest {

    @Description("Verify Cart button redirects to Cart page")
    @Test
    public void verifyCartButtonRedirectsToCartPage() {
        headerNavigationBar.clickOnCartButton();
        Assert.assertTrue(cartPage.getPageTitle().contains(ConfigProvider.CART_PAGE_TITLE), "Page title does not match");
    }
}
