package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.Base.BaseTest;
import utils.ConfigProvider;

public class VerifyIncorrectEmailSignIn extends BaseTest {

    @Description("Sign in with incorrect email")
    @Test(enabled = false)
    public void verifyIncorrectEmailSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.enterEmail(ConfigProvider.INCORRECT_EMAIL);
        signInPage.clickOnContinueButton();
        signInPage.verifyErrorMessageText(ConfigProvider.GENERAL_ERROR + "\n" + ConfigProvider.INCORRECT_EMAIL_ERROR);
    }
}
