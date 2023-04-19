package tests.SignIn;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import utils.ConfigProvider;

public class SuccessfulSignIn extends BaseTest {

    @Description("Sign in with correct email and password")
    @Test
    public void SuccessfulSignIn() {
        new HomePage().clickOnSignInLink()
                .enterEmail(ConfigProvider.EMAIL)
                .clickOnContinueButton()
                .enterPassword(ConfigProvider.PASSWORD)
                .clickOnSignInButton()
                .verifyUserIsSignedIn(ConfigProvider.USER_NAME);
    }
}
