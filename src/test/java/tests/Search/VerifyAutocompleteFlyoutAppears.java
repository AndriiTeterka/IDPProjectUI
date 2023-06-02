package tests.Search;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

public class VerifyAutocompleteFlyoutAppears extends BaseTest {

    @Description("Verify autocomplete flyout appears")
    @Test
    public void verifyAutocompleteFlyoutAppears() {
        searchBar.clickOnSearchBar();
        searchBar.verifyAutocompleteFlyoutIsDisplayed();
    }
}
