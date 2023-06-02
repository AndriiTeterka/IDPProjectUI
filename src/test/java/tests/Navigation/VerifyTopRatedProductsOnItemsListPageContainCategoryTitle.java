package tests.Navigation;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyTopRatedProductsOnItemsListPageContainCategoryTitle extends BaseTest {

    @Description("Verify top rated products on items list page contain category title")
    @Test
    public void VerifyTopRatedProductsOnItemsListPageContainCategoryTitle() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.signInExistingUser(ConfigProvider.EMAIL2, ConfigProvider.PASSWORD);
        headerNavigationBar.clickOnHamburgerMenuButton();
        mainMenuSidebar.clickOnComputersLink();
        mainMenuSidebar.clickOnMonitorsLink();
        itemsListPage.verifyTopRatedItemsContainTitle(ConfigProvider.MONITORS_CATEGORY.replaceAll("s", ""));
    }
}
