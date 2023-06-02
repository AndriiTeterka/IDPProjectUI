package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifySuccessfulSignIn extends BaseTest {

    @Description("Sign in with correct email and password")
    @Test
    public void verifySuccessfulSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.enterEmail(ConfigProvider.EMAIL2);
        signInPage.clickOnContinueButton();
        signInPage.enterPassword(ConfigProvider.PASSWORD);
        signInPage.clickOnSignInButton();
        headerNavigationBar.verifyUserIsSignedIn(ConfigProvider.USER_NAME);
    }
}