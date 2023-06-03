package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

/**
 The VerifyIncorrectEmailSignIn class is used to test the sign-in functionality with an incorrect email.
 It extends the BaseTest class and contains a single test method.
 */
public class VerifyIncorrectEmailSignIn extends BaseTest {

    @Description("Sign in with incorrect email")
    @Test(description = "Sign in with incorrect email")
    public void verifyIncorrectEmailSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.enterEmail(ConfigProvider.INCORRECT_EMAIL);
        signInPage.clickOnContinueButton();
        signInPage.verifyErrorMessageText(ConfigProvider.GENERAL_ERROR + "\n" + ConfigProvider.INCORRECT_EMAIL_ERROR);
    }
}
