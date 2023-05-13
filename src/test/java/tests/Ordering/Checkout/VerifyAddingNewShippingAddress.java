package tests.Ordering.Checkout;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyAddingNewShippingAddress extends BaseTest {

    @Description("Verify adding a new shipping address")
    @Test
    public void verifyAddingNewShippingAddress() {
        Faker faker = new Faker();
        int order = 0;

        headerNavigationBar.clickOnAccountListLink();
        signInPage.signInExistingUser(ConfigProvider.EMAIL2, ConfigProvider.PASSWORD);
        /*searchBar.searchForItem(ConfigProvider.TV_NAME);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        productDetailsPage.clickOnBuyNowButton();
        productCheckoutPage.clickOnShippingAddressLink();
        productCheckoutPage.clickOnAddNewAddressLink();
        productCheckoutPage.enterPhoneNumber(faker.phoneNumber().phoneNumber());
        productCheckoutPage.enterAddressLine1(faker.lorem().fixedString(1));
        productCheckoutPage.selectAddressLine1SuggestionsByOrder(faker.number().numberBetween(0, 4));
        productCheckoutPage.clickOnUseThisAddressButton();
        productCheckoutPage.verifyUseThisPaymentButtonIsDisplayed();*/

        //Address cleanup
        /*productCheckoutPage.clickOnHomePageLink();
        productCheckoutPage.clickOnReturnToCartButton();*/
        headerNavigationBar.clickOnAccountListLink();
        yourAccountPage.clickOnYourAddressesLink();
        yourAddressesPage.removeAllAddresses();
    }
}
