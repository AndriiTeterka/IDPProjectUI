package tests.Search;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 * The VerifyUpdatingSearchDropdownByFilter class is a test class that verifies the updating of the search dropdown by filter.
 * It performs the following steps:
 * Searches for the desired item name (in this case, laptop).
 * Asserts that the selected option in the search dropdown is the default value.
 * Gets the text of the first link in the departments filter sidebar.
 * Clicks on the first link in the departments filter sidebar.
 * Asserts that the selected option in the search dropdown is now the same as the text of the first link in the departments filter sidebar.
 * Note: The test extends the BaseTest class, which provides the common setup and teardown for the test.
 */
public class VerifyUpdatingSearchDropdownByFilter extends BaseTest {

    @Description("Verify updating search dropdown by filter")
    @Test(description = "Verify updating search dropdown by filter")
    public void VerifyUpdatingSearchDropdownByFilter() {
        searchBar.searchForItem(ConfigProvider.LAPTOP_NAME);
        Assert.assertEquals(searchBar.searchDropdownSelectedGetText(), ConfigProvider.DEFAULT_SEARCH_DROPDOWN_VALUE);

        String departmentsFirstLinkText = filtersSidebar.departmentsFirstLinkGetText();
        filtersSidebar.clickOnDepartmentsFirstLink();
        Assert.assertEquals(searchBar.searchDropdownSelectedGetText(), departmentsFirstLinkText);
    }
}
