package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 * The VerifyEmptyEmailSignIn class is used to test the sign-in functionality with an empty email.
 * It extends the BaseTest class and contains a single test method.
 */
public class VerifyEmptyEmailSignIn extends BaseTest {

    @Description("Sign in with empty email")
    @Test(description = "Sign in with empty email")
    public void verifyEmptyEmailSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.clickOnContinueButton();
        signInPage.verifyMissingEmailAlertText(ConfigProvider.MISSING_EMAIL_ALERT);
    }
}
