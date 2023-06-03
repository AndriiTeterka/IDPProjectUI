package tests.Ordering.Cart;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyCartButtonRedirectsToCartPage class is a test class that verifies the functionality of the Cart button,
 specifically whether it redirects the user to the Cart page when clicked. It extends the BaseTest class to inherit
 the setup and teardown methods.
 Note: The test assumes that the Cart button is present on the page and clickable. When the Cart button is clicked,
 it is verified that the resulting page title contains the expected Cart page title. This ensures that the user is
 redirected to the Cart page successfully.
 */
public class VerifyCartButtonRedirectsToCartPage extends BaseTest {

    @Description("Verify Cart button redirects to Cart page")
    @Test(description = "Verify Cart button redirects to Cart page")
    public void verifyCartButtonRedirectsToCartPage() {
        headerNavigationBar.clickOnCartButton();
        Assert.assertTrue(cartPage.getPageTitle().contains(ConfigProvider.CART_PAGE_TITLE), "Page title does not match");
    }
}
