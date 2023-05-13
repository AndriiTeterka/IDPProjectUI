package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyEmptyPasswordSignIn extends BaseTest {

    @Description("Sign in with incorrect email")
    @Test
    public void verifyEmptyPasswordSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.enterEmail(ConfigProvider.EMAIL1);
        signInPage.clickOnContinueButton();
        signInPage.clickOnSignInButton();
        signInPage.verifyMissingPasswordAlertText(ConfigProvider.MISSING_PASSWORD_ALERT);
    }
}
