package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyIncorrectEmailSignIn extends BaseTest {

    @Description("Sign in with incorrect email")
    @Test
    public void verifyIncorrectEmailSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.enterEmail(ConfigProvider.INCORRECT_EMAIL);
        signInPage.clickOnContinueButton();
        signInPage.verifyErrorMessageText(ConfigProvider.GENERAL_ERROR + "\n" + ConfigProvider.INCORRECT_EMAIL_ERROR);
    }
}
