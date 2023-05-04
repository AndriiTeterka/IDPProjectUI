package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class SuccessfulSignIn extends BaseTest {

    @Description("Sign in with correct email and password")
    @Test
    public void successfulSignIn() {
        headerNavigationBar.clickOnSignInLink();
        signInPage.enterEmail(ConfigProvider.EMAIL);
        signInPage.clickOnContinueButton();
        signInPage.enterPassword(ConfigProvider.PASSWORD);
        signInPage.clickOnSignInButton();
        headerNavigationBar.verifyUserIsSignedIn(ConfigProvider.USER_NAME);
    }
}
