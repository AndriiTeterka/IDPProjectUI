package tests.Authentication;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ConfigProvider;

public class VerifyIncorrectPasswordSignIn extends BaseTest {

    @Description("Sign in with incorrect password")
    @Test
    public void verifyIncorrectPasswordSignIn() {
        headerNavigationBar.clickOnAccountListLink();
        signInPage.enterEmail(ConfigProvider.EMAIL1);
        signInPage.clickOnContinueButton();
        signInPage.enterPassword(ConfigProvider.INCORRECT_PASSWORD);
        signInPage.clickOnSignInButton();
        signInPage.verifyErrorMessageText(ConfigProvider.GENERAL_ERROR + "\n" + ConfigProvider.INCORRECT_PASSWORD_ERROR);
    }
}
