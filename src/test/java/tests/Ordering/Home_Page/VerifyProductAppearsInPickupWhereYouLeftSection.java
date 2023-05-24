package tests.Ordering.Home_Page;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyProductAppearsInPickupWhereYouLeftSection extends BaseTest {

    @Description("Verify product appears in pick up where you left section")
    @Test
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
