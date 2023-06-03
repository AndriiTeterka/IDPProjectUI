package tests.Ordering.Home_Page;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyProductAppearsInPickupWhereYouLeftSection class is a test class that verifies whether a product appears
 in the "Pickup Where You Left" section on the home page. It assumes that the user is signed in and performs
 the following steps:
 Sign in to an existing user account.
 Search for a specific item using the search bar.
 Select a random search result item with price.
 Click on the Home page logo to navigate back to the home page.
 Verify that the "Pickup Where You Left" section contains the title of the selected item.
 Assert that the title is found.
 Note: The test uses a Faker library to generate random data for testing purposes, such as the order number and item title.
 */
public class VerifyProductAppearsInPickupWhereYouLeftSection extends BaseTest {

    @Description("Verify product appears in pick up where you left section")
    @Test(description = "Verify product appears in pick up where you left section")
    public void verifyProductAppearsInPickupWhereYouLeftSection() {
        Faker faker = new Faker();

        headerNavigationBar.clickOnAccountListLink();
        signInPage.signInExistingUser(ConfigProvider.EMAIL2, ConfigProvider.PASSWORD);
        searchBar.searchForItem(ConfigProvider.TV_NAME);
        int order = faker.number().numberBetween(0, searchResultsPage.getSearchResultItemsWithPrice().size());
        String itemTitle = searchResultsPage.searchResultItemWithPriceByOrderGetText(order);
        searchResultsPage.selectSearchResultItemWithPriceByOrder(order);
        headerNavigationBar.clickOnHomePageLogo();
        Assert.assertTrue(homePage.isPickupWhereYouLeftItemsContainsTitle(itemTitle), "Title not found");
    }
}
