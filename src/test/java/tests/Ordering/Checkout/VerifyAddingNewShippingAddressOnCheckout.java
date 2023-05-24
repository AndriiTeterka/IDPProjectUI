package tests.Ordering.Checkout;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyAddingNewShippingAddressOnCheckout extends BaseTest {

    @Description("Verify adding a new shipping address on checkout")
    @Test
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
