package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class EmptyEmailSignIn extends BaseTest {

    @Description("Sign in with incorrect email")
    @Test
    public void incorrectEmailSignIn() {
        headerNavigationBar.clickOnSignInLink();
        signInPage.clickOnContinueButton();
        signInPage.verifyMissingEmailAlertText(ConfigProvider.MISSING_EMAIL_ALERT);
    }
}
