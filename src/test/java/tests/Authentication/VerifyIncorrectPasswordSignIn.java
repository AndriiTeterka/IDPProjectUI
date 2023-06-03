package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyIncorrectPasswordSignIn class is used to test the sign-in functionality with an incorrect password.
 It extends the BaseTest class and contains a single test method.
 */
public class VerifyIncorrectPasswordSignIn extends BaseTest {

    @Description("Sign in with incorrect password")
    @Test(description = "Sign in with incorrect password")
    public void verifyIncorrectPasswordSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.enterEmail(ConfigProvider.EMAIL1);
        signInPage.clickOnContinueButton();
        signInPage.enterPassword(ConfigProvider.INCORRECT_PASSWORD);
        signInPage.clickOnSignInButton();
        signInPage.verifyErrorMessageText(ConfigProvider.GENERAL_ERROR + "\n" + ConfigProvider.INCORRECT_PASSWORD_ERROR);
    }
}
