package tests.Ordering.Checkout;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyAddingNewShippingAddressOnCheckout class is a test class that verifies the functionality of adding
 a new shipping address during the checkout process. It checks whether a new shipping address can be added
 successfully and used for the checkout. The test assumes that the user is signed in and has added a product to the cart.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test uses a Faker library to generate random data for testing purposes, such as the phone number and address.
 */
public class VerifyAddingNewShippingAddressOnCheckout extends BaseTest {

    @Description("Verify adding a new shipping address on checkout")
    @Test(description = "Verify adding a new shipping address on checkout")
    public void VerifyAddingNewShippingAddressOnCheckout() {
        Faker faker = new Faker();

        headerNavigationBar.clickOnAccountListLink();
        signInPage.signInExistingUser(ConfigProvider.EMAIL2, ConfigProvider.PASSWORD);
        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnBuyNowButton();
        productCheckoutPage.clickOnShippingAddressLink();
        productCheckoutPage.clickOnAddNewAddressLink();
        productCheckoutPage.enterPhoneNumber(faker.phoneNumber().phoneNumber());
        productCheckoutPage.enterAddressLine1(faker.lorem().fixedString(1));
        productCheckoutPage.selectAddressLine1SuggestionsByOrder(faker.number().numberBetween(0, 4));
        productCheckoutPage.clickOnUseThisAddressButton();
        productCheckoutPage.verifyUseThisPaymentButtonIsDisplayed();

        //Cart cleanup
        productCheckoutPage.clickOnHomePageLink();
        productCheckoutPage.clickOnReturnToCartButton();
        cartPage.removeAllItemsFromCart();

        //Address cleanup
        headerNavigationBar.clickOnAccountListLink();
        yourAccountPage.clickOnYourAddressesLink();
        yourAddressesPage.removeAllAddresses();

    }
}
