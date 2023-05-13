package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyEmptyEmailSignIn extends BaseTest {

    @Description("Sign in with incorrect email")
    @Test
    public void verifyEmptyEmailSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.clickOnContinueButton();
        signInPage.verifyMissingEmailAlertText(ConfigProvider.MISSING_EMAIL_ALERT);
    }
}
