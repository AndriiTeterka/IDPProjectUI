package tests.Search;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyUpdatingSearchDropdownByFilter extends BaseTest {

    @Description("Verify updating search dropdown by filter")
    @Test
    public void VerifyUpdatingSearchDropdownByFilter() {
        searchBar.searchForItem(ConfigProvider.LAPTOP_NAME);
        Assert.assertEquals(searchBar.searchDropdownSelectedGetText(), ConfigProvider.DEFAULT_SEARCH_DROPDOWN_VALUE);

        String departmentsFirstLinkText = filtersSidebar.departmentsFirstLinkGetText();
        filtersSidebar.clickOnDepartmentsFirstLink();
        Assert.assertEquals(searchBar.searchDropdownSelectedGetText(), departmentsFirstLinkText);
    }
}
