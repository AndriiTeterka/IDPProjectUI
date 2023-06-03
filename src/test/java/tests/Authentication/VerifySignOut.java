package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifySignOut class is used to test the sign-out functionality.
 It extends the BaseTest class and contains a single test method.
 */
public class VerifySignOut extends BaseTest {

    @Description("User sign out")
    @Test(description = "User sign out")
    public void verifySignOut() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.enterEmail(ConfigProvider.EMAIL2);
        signInPage.clickOnContinueButton();
        signInPage.enterPassword(ConfigProvider.PASSWORD);
        signInPage.clickOnSignInButton();
        headerNavigationBar.hoverMouseOnSignInLink();
        accountListFlyout.clickOnSignOutLink();
        Assert.assertTrue(signInPage.getPageTitle().contains(ConfigProvider.SIGN_IN_PAGE_TITLE), "Page title does not match");
    }
}
