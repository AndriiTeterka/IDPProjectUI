package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyEmptyPasswordSignIn class is used to test the sign-in functionality with an empty password.
 It extends the BaseTest class and contains a single test method.
 */
public class VerifyEmptyPasswordSignIn extends BaseTest {

    @Description("Sign in with empty password")
    @Test(description = "Sign in with empty password")
    public void verifyEmptyPasswordSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.enterEmail(ConfigProvider.EMAIL1);
        signInPage.clickOnContinueButton();
        signInPage.clickOnSignInButton();
        signInPage.verifyMissingPasswordAlertText(ConfigProvider.MISSING_PASSWORD_ALERT);
    }
}
