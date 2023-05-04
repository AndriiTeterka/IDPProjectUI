package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class EmptyPasswordSignIn extends BaseTest {

    @Description("Sign in with incorrect email")
    @Test
    public void incorrectEmailSignIn() {
        headerNavigationBar.clickOnSignInLink();
        signInPage.enterEmail(ConfigProvider.EMAIL);
        signInPage.clickOnContinueButton();
        signInPage.clickOnSignInButton();
        signInPage.verifyMissingPasswordAlertText(ConfigProvider.MISSING_PASSWORD_ALERT);
    }
}
