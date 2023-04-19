package tests.SignIn;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import utils.ConfigProvider;

public class IncorrectEmailSignIn extends BaseTest {

    @Description("Sign in with incorrect email")
    @Test
    public void IncorrectEmailSignIn() {
        new HomePage().clickOnSignInLink()
                .enterEmail(ConfigProvider.INCORRECT_EMAIL)
                .clickOnContinueButton()
                .verifyErrorText(ConfigProvider.GENERAL_ERROR + "\n" + ConfigProvider.INCORRECT_EMAIL_ERROR);
    }
}
