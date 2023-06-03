package tests.Navigation;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyTopRatedProductsOnItemsListPageContainCategoryTitle class is a test class that verifies
 that the top rated products on the items list page contain the category title.
 It extends the BaseTest class to inherit the setup and teardown methods.
 Note: The test assumes that the user is signed in and navigates to the items list page for the Monitors category.
 The category title is verified to be present in the top rated items.
 */
public class VerifyTopRatedProductsOnItemsListPageContainCategoryTitle extends BaseTest {

    @Description("Verify top rated products on items list page contain category title")
    @Test(description = "Verify top rated products on items list page contain category title")
    public void VerifyTopRatedProductsOnItemsListPageContainCategoryTitle() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.signInExistingUser(ConfigProvider.EMAIL2, ConfigProvider.PASSWORD);
        headerNavigationBar.clickOnHamburgerMenuButton();
        mainMenuSidebar.clickOnComputersLink();
        mainMenuSidebar.clickOnMonitorsLink();
        itemsListPage.verifyTopRatedItemsContainTitle(ConfigProvider.MONITORS_CATEGORY.replaceAll("s", ""));
    }
}
