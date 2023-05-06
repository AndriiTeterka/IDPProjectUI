package tests.Authentication;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifySignOut extends BaseTest {

    @Description("User sign out")
    @Test
    public void verifySignOut() {
        headerNavigationBar.clickOnSignInLink();
        signInPage.enterEmail(ConfigProvider.EMAIL);
        signInPage.clickOnContinueButton();
        signInPage.enterPassword(ConfigProvider.PASSWORD);
        signInPage.clickOnSignInButton();
        headerNavigationBar.hoverMouseOnSignInLink();
        accountListFlyout.clickOnSignOutLink();
        Assert.assertEquals(Selenide.title(), "Amazon Sign-In");
    }
}
