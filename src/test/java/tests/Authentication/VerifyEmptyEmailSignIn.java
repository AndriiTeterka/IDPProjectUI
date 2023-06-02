package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyEmptyEmailSignIn extends BaseTest {

    @Description("Sign in with incorrect email")
    @Test(enabled = false)
    public void verifyEmptyEmailSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.clickOnContinueButton();
        signInPage.verifyMissingEmailAlertText(ConfigProvider.MISSING_EMAIL_ALERT);
    }
}
