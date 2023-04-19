package tests.SignIn;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import utils.ConfigProvider;

public class IncorrectPasswordSignIn extends BaseTest {

    @Description("Sign in with incorrect password")
    @Test
    public void IncorrectPasswordSignIn() {
        new HomePage().clickOnSignInLink()
                .enterEmail(ConfigProvider.EMAIL)
                .clickOnContinueButton()
                .enterPassword(ConfigProvider.INCORRECT_PASSWORD)
                .pressEnterOnSignInButton()
                .verifyErrorText(ConfigProvider.GENERAL_ERROR + "\n" + ConfigProvider.INCORRECT_PASSWORD_ERROR);
    }
}
